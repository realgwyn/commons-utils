package swing.dragndrop;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Placeholder for DraggableComponents in swing GUI.
 * 
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class DroppableContainer extends JPanel {

  enum DropState {
    DEFAULT, ROLLOVER, DISABLED
  }

  DragContext context;
  DraggableComponent slot;
  boolean isEnabled = true;
  DropState currentState = DropState.DEFAULT;
  JPanel dropSpace;

  Color defaultColor = new Color(53, 206, 235);
  Color focusedColor = defaultColor.brighter();
  Color disabledColor = defaultColor.darker();

  public DroppableContainer() {
    setBackground(defaultColor);
    FormLayout layout = new FormLayout(new ColumnSpec[] { ColumnSpec.decode("10px"), ColumnSpec.decode("center:default:grow"),
        ColumnSpec.decode("10px"), }, new RowSpec[] { RowSpec.decode("10px"), RowSpec.decode("default:grow"),
        RowSpec.decode("10px"), });
    setLayout(layout);

    dropSpace = new JPanel();
    dropSpace.setOpaque(false);
    add(dropSpace, "2, 2, center, center");
    dropSpace.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

    initActions();
  }

  public DraggableComponent getDraggableComponent() {
    return slot;
  }

  public void insertDraggableComponent(DraggableComponent c) {
    slot = c;
    dropSpace.add(c);
    validate();
  }

  public void removeDraggableComponent(DraggableComponent c) {
    dropSpace.remove(c);
    slot = null;
    repaint();
  }

  public boolean hasFreeSlot() {
    return (slot == null && getDropState() != DropState.DISABLED);
  }

  public void setDropState(DropState state) {
    switch (state) {
    case DEFAULT:
      setBackground(defaultColor);
      break;
    case ROLLOVER:
      setBackground(focusedColor);
      break;
    case DISABLED:
      setBackground(disabledColor);
      break;
    }
    currentState = state;
  }

  public DropState getDropState() {
    return currentState;
  }

  private void initActions() {
    final DroppableContainer container = this;
    context = DragContext.getContext();

    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        // register droppable component that can accept draggable object
        System.out.println("entered");
        if (context.isDragged && hasFreeSlot()) {
          setDropState(DropState.ROLLOVER);
          context.targetContainer = container;
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        System.out.println("exited");
        if (getDropState() != DropState.DISABLED) {
          setDropState(DropState.DEFAULT);
          // deregister droppable component
          if (context.isDragged) {
            context.targetContainer = null;
          }
        }
      }
    });
  }

}
