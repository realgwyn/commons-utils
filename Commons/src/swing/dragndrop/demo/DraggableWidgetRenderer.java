package swing.dragndrop.demo;

import java.awt.Color;

import swing.dragndrop.DraggableRenderer;
import swing.dragndrop.GraphicsUtils;

/**
 * @author rafal.kojta
 */
public class DraggableWidgetRenderer implements DraggableRenderer {
  public Color defaultColor = new Color(62, 193, 53);
  public Color rolloverColor = new Color(0, 133, 206);
  public Color draggedColor = GraphicsUtils.addTransparency(rolloverColor, 0.45);

  Widget widget;

  public DraggableWidgetRenderer(Widget w) {
    this.widget = w;
    defaultColor = w.getBackground();
  }

  @Override
  public void renderStateDefault() {
    widget.setStateName("DEFAULT");
    widget.setBackground(defaultColor);
  }

  @Override
  public void renderStateDragged() {
    widget.setStateName("DRAGGED");
    widget.setBackground(draggedColor);
  }

  @Override
  public void renderStateRollover() {
    widget.setStateName("ROLLOVER");
    widget.setBackground(rolloverColor);
  }
}
