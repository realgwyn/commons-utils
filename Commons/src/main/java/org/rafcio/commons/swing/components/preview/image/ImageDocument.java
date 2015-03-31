package org.rafcio.commons.swing.components.preview.image;

import java.awt.Image;
import java.io.File;
import java.util.List;

/**
 * @author rafal.kojta
 */
public class ImageDocument {

  private String name;
  private File file;
  private List<Image> rawImages;
  private List<Image> renderedImages;

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
    this.setName(file.getName());
  }

  public List<Image> getRawImages() {
    return rawImages;
  }

  public void setRawImages(List<Image> rawImages) {
    this.rawImages = rawImages;
  }

  public List<Image> getRenderedImages() {
    return renderedImages;
  }

  public void setRenderedImages(List<Image> renderedImages) {
    this.renderedImages = renderedImages;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
