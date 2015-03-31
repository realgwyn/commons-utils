package org.rafcio.commons.swing.dragndrop.demo;

import org.rafcio.commons.swing.dragndrop.DragAndDropListener;
import org.rafcio.commons.swing.dragndrop.DragContext;
import org.rafcio.commons.swing.dragndrop.DraggableComponent;
import org.rafcio.commons.swing.dragndrop.DroppableContainer;


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
