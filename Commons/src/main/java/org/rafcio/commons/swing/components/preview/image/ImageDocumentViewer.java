package org.rafcio.commons.swing.components.preview.image;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ScrollPaneConstants;

/**
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class ImageDocumentViewer extends ImageGalleryPanel {

  private ZoomMode zoomMode = ZoomMode.ZOOM_FIT_WIDTH;

  private static int DEFAULT_WIDTH = 800;
  private static int DEFAULT_HEIGHT = 600;

  private ImageDocument imageDocument;

  public ImageDocumentViewer() {
    super();
    this.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        refresh();
      }
    });
  }

  public void displayImageDocument(ImageDocument document) {
    this.imageDocument = document;
    List<Image> renderedImages = new ArrayList<Image>(imageDocument.getRawImages().size());

    for (Image image : imageDocument.getRawImages()) {
      Dimension imageSize = resolveImageSize(image);
      Image newImage = image.getScaledInstance((int) (imageSize.width * zoomValue) + 1, (int) (imageSize.height * zoomValue) + 1,
          Image.SCALE_SMOOTH);
      renderedImages.add(newImage);
    }
    imageDocument.setRenderedImages(renderedImages);

    setImages(imageDocument.getRenderedImages());
  }

  @Override
  public void refresh() {
    if (imageDocument != null) {
      displayImageDocument(imageDocument);
    }
  }

  public void setZoom(ZoomMode zoomMode) {
    this.zoomMode = zoomMode;
    switch (zoomMode) {
    case ZOOM_FIT_WIDTH:
      setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      break;
    default:
      setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
  }

  private Dimension resolveImageSize(Image image) {
    Dimension panelSize = getDisplayAreaSize();

    if (panelSize.width + panelSize.height <= 2) {
      panelSize = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    if (image.getWidth(null) + image.getHeight(null) == 0) {
      return new Dimension(0, 0);
    }

    Dimension imageSize = null;
    double resizeRatio;

    switch (zoomMode) {
    case ZOOM_FIT_PAGE:
      imageSize = new Dimension(panelSize.width, panelSize.height);
      break;
    case ZOOM_ACTUAL_SIZE:
      imageSize = new Dimension(image.getWidth(null), image.getHeight(null));
      break;
    case ZOOM_FIT_HEIGHT:
      resizeRatio = (double) panelSize.height / (double) image.getHeight(null);
      imageSize = new Dimension((int) (image.getWidth(null) * resizeRatio), panelSize.height);
      break;
    case ZOOM_FIT_WIDTH:
      resizeRatio = (double) panelSize.width / (double) image.getWidth(null);
      imageSize = new Dimension(panelSize.width, (int) (image.getHeight(null) * resizeRatio));
      break;
    default:
      throw new IllegalArgumentException("Unknown zoom mode: " + zoomMode);
    }

    return imageSize;
  }

}
