package swing.dragndrop;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(Image img) {
    this.img = img;
    setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
  }

  @Override
  public void paintComponent(Graphics g) {
    if (img != null) {
      g.drawImage(img, 0, 0, this);
    }
  }
}
