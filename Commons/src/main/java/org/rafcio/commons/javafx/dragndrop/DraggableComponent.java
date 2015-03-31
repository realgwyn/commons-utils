package org.rafcio.commons.javafx.dragndrop;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import org.rafcio.commons.javafx.dragndrop.DroppableContainer.DropState;

public class DraggableComponent extends Pane {

	enum DragState {
		DEFAULT, ROLLOVER, DRAGGED
	}

	private DragContext context;
	private Node component;
	private List<DragAndDropListener> listeners = new ArrayList<DragAndDropListener>();
	private DraggableRenderer renderer;
	private Pane drawingArea;

	public DraggableComponent(Node component) {
		this(component, new DefaultDragResolver());
	}

	public DraggableComponent(Node component, DragAndDropListener listener) {
		this(component, listener, null);
	}

	public DraggableComponent(Node component, DragAndDropListener listener, DraggableRenderer renderer) {
		this.component = component;
		this.renderer = renderer;
		getChildren().add(component);
		listeners.add(listener);
		initActions();
	}

	public Node getComponent() {
		return component;
	}

	public void setRenderer(DraggableRenderer renderer) {
		this.renderer = renderer;
	}

	public void setDragState(DragState state) {
		if (renderer == null) {
			System.out.println("DraggableRenderer for Component " + component.getClass().getSimpleName()
					+ " have not been set up. Using DefaultDraggableRenderer");
			renderer = new DefaultDraggableRenderer(component);
		}
		switch (state) {
		case DEFAULT:
			renderer.renderStateDefault();
			break;
		case ROLLOVER:
			renderer.renderStateRollover();
			break;
		case DRAGGED:
			renderer.renderStateDragged();
			break;
		}
	}

	private Pane getDrawingArea() {
		if (drawingArea == null) {
			try {
				DraggablePane draggablePane = (DraggablePane) this.getScene().getRoot();
				drawingArea = draggablePane.getGlassPane();
			} catch (ClassCastException ex) {
				// TODO: catch this exception and inform user that DraggablePane
				// is not setup
				ex.printStackTrace();
			}
		}
		return drawingArea;
	}

	private void notifyDragAndDropListeners(DragContext context) {
		for (DragAndDropListener listener : listeners) {
			listener.notifyDragAndDropAction(context);
		}
	}

	private DragContext setupContext() {
		DragContext context = DragContext.getContext();
		ImageView draggedComponentImage = new ImageView(this.snapshot(new SnapshotParameters(), null));
		context.setup(this, getParentContainer(), draggedComponentImage);
		return context;
	}

	private DroppableContainer getParentContainer() {
		Node parent = this.getParent().getParent();
		if (parent instanceof DroppableContainer) {
			return (DroppableContainer) parent;
		}
		System.out.println("parent is null!");
		return null;
	}

	private void initActions() {
		final Node c = this.component;
		context = DragContext.getContext();

		c.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Pane drawingArea = getDrawingArea();
				if (drawingArea != null) {
					if (!context.isDragged) {// to avoid double mouse button  click
						context = setupContext();
						Point location = GraphicsUtils.convertPoint(c, e.getSceneX(), e.getSceneY());
						context.draggedComponentImage.setLayoutX(location.getX());
						context.draggedComponentImage.setLayoutY(location.getY());
						drawingArea.getChildren().add(context.draggedComponentImage);
						setDragState(DragState.DRAGGED);
					}
				}
			}
		});

		c.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				setDragState(DragState.DEFAULT);
				Pane drawingArea = getDrawingArea();
				if (drawingArea != null) {
					if (context.isDragged) {
						if (context.targetContainer != null) {
							context.targetContainer.setDropState(DropState.DEFAULT);
							notifyDragAndDropListeners(context);
						}
						// clear animation and context
						drawingArea.getChildren().remove(context.draggedComponentImage);
						context.clear();
					}
				}
			}
		});

		c.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (!context.isDragged) {
					setDragState(DragState.ROLLOVER);
				} else {
					// this enables dropping draggable objects on top of each
					// other
					DroppableContainer targetContainer = getParentContainer();
					if (targetContainer != null && targetContainer.hasFreeSlot()) {
						context.targetContainer = targetContainer;
					}
				}
			}
		});

		c.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (!context.isDragged) {
					setDragState(DragState.DEFAULT);
				}
			}
		});

		c.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Pane drawingArea = getDrawingArea();
				if (drawingArea != null) {
					if (context.isDragged) {
						Point location = GraphicsUtils.convertPoint(c, e.getSceneX(), e.getSceneY());
						context.draggedComponentImage.setLayoutX(location.getX());
						context.draggedComponentImage.setLayoutY(location.getY());
					}
				}
			}
		});
	}
}
