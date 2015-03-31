package org.rafcio.commons.javafx.dragndrop;

/**
 * Decides what to do with Dragged Component when Drop action was invoked. <br>
 * By default, it removes dragged component from original location and insets it
 * to new location.
 * 
 * @author rafal.kojta
 */
public class DefaultDragResolver implements DragAndDropListener {

	@Override
	public void notifyDragAndDropAction(DragContext context) {
		DraggableComponent c = context.draggedComponent;
		DroppableContainer parent = context.parentContainer;
		DroppableContainer target = context.targetContainer;

		parent.removeDraggableComponent(c);
		target.insertDraggableComponent(c);
	}

}
