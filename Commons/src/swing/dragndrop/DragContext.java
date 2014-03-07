package swing.dragndrop;

import javax.swing.JPanel;

//@formatter:off
/**
 * Contains all vital objects that are participating to current Drag&Drop action:
 * <ul>
 * <li>DraggedComponent draggedComponent - Component that is being dragged</li>
 * <li>JPanel draggedComponentImage - image representation of dragged JComponent</li>
 * <li>DroppableContainer parentContainer - parent container of JComponent from which it was dragged out</li>
 * <li>DroppableContainer targetContainer (optional) - when dragged JComponent hovers over DroppableComponent</li>
 * </ul>
 * 
 * @author rafal.kojta
 */
//@formatter: on
public class DragContext {

  public DraggableComponent draggedComponent;
  public JPanel draggedComponentImage;
  public DroppableContainer parentContainer;
  public DroppableContainer targetContainer;
  public boolean isDragged = false;

  private static volatile DragContext instance;
  private DragContext() {}

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

  public void setup(DraggableComponent draggedComponent, DroppableContainer parentContainer, JPanel draggedComponentImage) {
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
    return "DragContext [draggedComponent=" + draggedComponent + " parentContainer=" + parentContainer + " targetContainer="
        + targetContainer + "]";
  }
}
