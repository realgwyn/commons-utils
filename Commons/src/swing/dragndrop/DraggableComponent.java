package swing.dragndrop;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import swing.dragndrop.DroppableContainer.DropState;

/**
 * Wrapper for swing JComponent that gives it ability to be dragged around with mouse in JFrame window.
 * 
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class DraggableComponent extends JPanel {

  enum DragState {
    DEFAULT, ROLLOVER, DRAGGED
  }

  private DragContext context;
  private JComponent component;
  private List<DragAndDropListener> listeners = new ArrayList<DragAndDropListener>();
  private DraggableRenderer renderer;
  private JPanel drawingArea;
  private JFrame window;

  /**
   * @wbp.parser.constructor
   */
  public DraggableComponent(JComponent component) {
    this(component, new DefaultDragResolver());
  }

  public DraggableComponent(JComponent component, DragAndDropListener listener) {
    this(component, listener, null);
  }

  public DraggableComponent(JComponent component, DragAndDropListener listener, DraggableRenderer renderer) {
    this.component = component;
    this.renderer = renderer;
    setLayout(new BorderLayout(0, 0));
    add(component);
    listeners.add(listener);
    initActions();
  }

  public JComponent getComponent() {
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

  private void validateWindow() {
    if (window == null) {
      window = (JFrame) SwingUtilities.getWindowAncestor(component);
    }
    if (window != null) {
      window.validate();
    }
  }

  private void repaintWindow() {
    if (window == null) {
      window = (JFrame) SwingUtilities.getWindowAncestor(component);
    }
    if (window != null) {
      window.repaint();
    }
  }

  private JPanel getDrawingArea() {
    if (drawingArea == null) {
      JFrame window = (JFrame) SwingUtilities.getWindowAncestor(component);
      if (window != null) {
        drawingArea = (JPanel) window.getGlassPane();
        drawingArea.setLayout(null);
        drawingArea.setVisible(true);
        return drawingArea;
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
    BufferedImage img = GraphicsUtils.componentToImage(component, null);
    ImagePanel draggedComponentImage = new ImagePanel(img);
    draggedComponentImage.setSize(component.getSize());
    DragContext context = DragContext.getContext();
    context.setup(this, getParentContainer(), draggedComponentImage);
    return context;
  }

  private DroppableContainer getParentContainer() {
    Container parent = this.getParent().getParent();
    if (parent instanceof DroppableContainer) {
      return (DroppableContainer) parent;
    }
    return null;
  }

  private void initActions() {
    final JComponent c = component;
    context = DragContext.getContext();

    component.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        JPanel drawingArea = getDrawingArea();
        if (drawingArea != null) {
          if (!context.isDragged) {// to avoid double mouse button click
            Point loc = GraphicsUtils.convertPoint(c, e.getX(), e.getY(), drawingArea);
            context = setupContext();
            context.draggedComponentImage.setLocation(loc);
            drawingArea.add(context.draggedComponentImage);
            drawingArea.repaint();
            setDragState(DragState.DRAGGED);
          }
        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        setDragState(DragState.DEFAULT);
        JPanel drawingArea = getDrawingArea();
        if (drawingArea != null) {
          if (context.isDragged) {
            if (context.targetContainer != null) {
              context.targetContainer.setDropState(DropState.DEFAULT);
              notifyDragAndDropListeners(context);
            }
            // clear animation and context
            drawingArea.remove(context.draggedComponentImage);
            drawingArea.repaint();
            context.clear();
          }
          validateWindow();// to update view of other related swing components: scrollbars etc.
        }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        if (!context.isDragged) {
          setDragState(DragState.ROLLOVER);
        } else {
          // this enables dropping draggable objects on top of each other
          DroppableContainer targetContainer = getParentContainer();
          if (targetContainer != null && targetContainer.hasFreeSlot()) {
            context.targetContainer = targetContainer;
          }
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        if (!context.isDragged) {
          setDragState(DragState.DEFAULT);
        }
      }
    });

    component.addMouseMotionListener(new MouseAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        JPanel drawingArea = getDrawingArea();
        if (drawingArea != null) {
          if (context.isDragged) {
            Point loc = GraphicsUtils.convertPoint(c, e.getX(), e.getY(), drawingArea);
            context.draggedComponentImage.validate();
            context.draggedComponentImage.setLocation(loc.x, loc.y);
            repaintWindow();
          }
        }
      }
    });
  }

}
