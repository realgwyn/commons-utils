package org.rafcio.commons.javafx.dragndrop;

import java.awt.Color;

import javafx.scene.Node;

/**
 * Changes DraggedComponent view on DragState change.
 * 
 * @author rafal.kojta
 */
public class DefaultDraggableRenderer implements DraggableRenderer {

	Node component;
	public Color defaultColor;
	public Color rolloverColor;
	public Color draggedColor;

	public DefaultDraggableRenderer(Node component) {
		this.component = component;
		defaultColor = new Color(220, 150, 0);
		rolloverColor = new Color(0, 133, 206);
		draggedColor = new Color(200, 120, 50);
	}

	@Override
	public void renderStateDefault() {
		GraphicsUtils.setBackgroundColor(component, defaultColor);
	}

	@Override
	public void renderStateDragged() {
		GraphicsUtils.setBackgroundColor(component, draggedColor);
	}

	@Override
	public void renderStateRollover() {
		GraphicsUtils.setBackgroundColor(component, rolloverColor);
	}

}
