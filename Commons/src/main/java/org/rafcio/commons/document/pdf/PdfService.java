package org.rafcio.commons.document.pdf;

import java.awt.Image;
import java.io.File;
import java.util.List;

/**
 * @author rafal.kojta
 */
public interface PdfService {

  public List<Image> generateImagesFromPdf(File file);

}
