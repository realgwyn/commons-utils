package org.rafcio.commons.javafx.dragndrop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javafx.scene.Node;

import javax.imageio.ImageIO;

/**
 * @author rafal.kojta
 */
public class GraphicsUtils {

	public static String colorToHex(Color color) {
		return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}
	
	/**
	 * @param colorStr e.g. "#FFFFFF"
	 * @return java.awt.Color
	 */
	public static Color hexToColor(String hex){
		return new Color(
            Integer.valueOf(hex.substring(1, 3), 16),
            Integer.valueOf(hex.substring(3, 5), 16),
            Integer.valueOf(hex.substring(5, 7), 16));
	}
	
	public static void setBackgroundColor(Node component, Color color) {
		component.setStyle("-fx-background-color: "+colorToHex(color));
	}

	public static Point convertPoint(Node source, double locX, double locY) {
		double middleX = source.prefWidth(0) / 2;
		double middleY = source.prefHeight(0) / 2;
		return new Point((int)(locX - middleX), (int)(locY - middleY));
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
