package org.rafcio.commons.document.pdf;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * @author rafal.kojta
 */
public class PdfBoxService implements PdfService {

  @Override
  public List<Image> generateImagesFromPdf(File file) {
    PDDocument pdf;
    List<Image> images = new ArrayList<Image>();
    try {
      pdf = PDDocument.load(file);
    } catch (IOException e) {
      e.printStackTrace();
      return images;
    }

    for (Object page : pdf.getDocumentCatalog().getAllPages()) {
      images.add(convertToImage((PDPage) page));
    }

    return images;
  }

  private BufferedImage convertToImage(PDPage page) {
    try {
      return page.convertToImage();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}