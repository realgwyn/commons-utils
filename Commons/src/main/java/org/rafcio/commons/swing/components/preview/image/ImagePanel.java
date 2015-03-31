package org.rafcio.commons.swing.components.preview.image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * Draws an Image.
 * 
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

  private final Image image;

  public ImagePanel() {
    image = null;
    setBackground(Color.WHITE);
  }

  public ImagePanel(Image image) {
    this.image = image;
    setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
  }

  @Override
  public void paintComponent(Graphics g) {
    if (image == null) {
      super.paintComponent(g);
      // g.setColor(Color.black);
      // g.drawString("No Image selected", getWidth() / 2 - 30, getHeight() / 2);
    } else {
      g.drawImage(image, 0, 0, this);
    }
  }
}