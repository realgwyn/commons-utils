package javafx.dragndrop;

/**
 * @author rafal.kojta
 */
public interface DragAndDropListener {
	/**
	 * Occurs when DraggablePanel was successfully Clicked, Dragged and Dropped
	 * on valid DroppableComponent
	 * 
	 * @param context - contains all nescesary drag and drop data
	 */
	public void notifyDragAndDropAction(DragContext context);

}
