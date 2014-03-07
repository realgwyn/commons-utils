package swing.dragndrop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

/**
 * @author rafal.kojta
 */
public class GraphicsUtils {

  public static Point convertPoint(Component source, int locX, int locY, Component rootComponent) {
    Point loc = SwingUtilities.convertPoint(source, locX, locY, rootComponent);
    int middleX = source.getWidth() / 2;
    int middleY = source.getHeight() / 2;
    return new Point(loc.x - middleX, loc.y - middleY);
  }

  public static BufferedImage componentToImage(Component component, Rectangle region) {
    BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics g = img.getGraphics();
    g.setColor(component.getForeground());
    g.setFont(component.getFont());
    component.paintAll(g);
    if (region == null) {
      region = new Rectangle(0, 0, img.getWidth(), img.getHeight());
    }
    return img.getSubimage(region.x, region.y, region.width, region.height);
  }

  public static Color addTransparency(Color color, double percent) {
    int alpha = (int) (255 * percent);
    return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
  }

  public static BufferedImage loadImage(String imageName) {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    InputStream s = classLoader.getResourceAsStream(imageName);
    BufferedImage img = null;
    try {
      img = ImageIO.read(s);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return img;
  }
}
