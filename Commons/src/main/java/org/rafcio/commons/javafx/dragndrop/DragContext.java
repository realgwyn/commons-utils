package org.rafcio.commons.javafx.dragndrop;

import javafx.scene.image.ImageView;


public class DragContext {
	public DraggableComponent draggedComponent;
	public ImageView draggedComponentImage;
	public DroppableContainer parentContainer;
	public DroppableContainer targetContainer;
	public boolean isDragged = false;

	private static volatile DragContext instance;

	private DragContext() {
	}

	public static DragContext getContext() {
		if (instance == null) {
			synchronized (DragContext.class) {
				if (instance == null) {
					instance = new DragContext();
				}
			}
		}
		return instance;
	}

	public void setup(DraggableComponent draggedComponent, DroppableContainer parentContainer, ImageView draggedComponentImage) {
		this.draggedComponent = draggedComponent;
		this.parentContainer = parentContainer;
		this.draggedComponentImage = draggedComponentImage;
		isDragged = true;
	}

	public void clear() {
		draggedComponent = null;
		parentContainer = null;
		targetContainer = null;
		draggedComponentImage = null;
		isDragged = false;
	}

	@Override
	public String toString() {
		return "DragContext [draggedComponent=" + draggedComponent + " parentContainer=" + parentContainer + " targetContainer=" + targetContainer + "]";
	}
}
