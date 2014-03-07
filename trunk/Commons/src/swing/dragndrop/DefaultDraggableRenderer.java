package swing.dragndrop;

import java.awt.Color;

import javax.swing.JComponent;

/**
 * Changes DraggedComponent view on DragState change.
 * 
 * @author rafal.kojta
 */
public class DefaultDraggableRenderer implements DraggableRenderer {

  JComponent component;
  public Color defaultColor;
  public Color rolloverColor;
  public Color draggedColor;

  public DefaultDraggableRenderer(JComponent component) {
    this.component = component;
    defaultColor = component.getBackground();
    rolloverColor = new Color(0, 133, 206);
    draggedColor = GraphicsUtils.addTransparency(rolloverColor, 0.45);
  }

  @Override
  public void renderStateDefault() {
    component.setBackground(defaultColor);
  }

  @Override
  public void renderStateDragged() {
    component.setBackground(draggedColor);
  }

  @Override
  public void renderStateRollover() {
    component.setBackground(rolloverColor);
  }

}
