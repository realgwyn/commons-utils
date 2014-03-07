package swing.dragndrop.demo;

import swing.dragndrop.DragAndDropListener;
import swing.dragndrop.DragContext;
import swing.dragndrop.DraggableComponent;
import swing.dragndrop.DroppableContainer;

/**
 * @author rafal.kojta
 */
public class WidgetDragResolver implements DragAndDropListener {

  @Override
  public void notifyDragAndDropAction(DragContext context) {
    DraggableComponent c = context.draggedComponent;
    DroppableContainer parent = context.parentContainer;
    DroppableContainer target = context.targetContainer;

    Widget widget = (Widget) c.getComponent();
    widget.incrementNumber();

    parent.removeDraggableComponent(c);
    target.insertDraggableComponent(c);
  }
}
