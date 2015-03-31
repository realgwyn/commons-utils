package org.rafcio.commons.document.pdf;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

/**
 * @author rafal.kojta
 */
public class PdfRendererService implements PdfService {

  @Override
  public List<Image> generateImagesFromPdf(File file) {
    PDFFile pdf;
    List<Image> images = new ArrayList<Image>();
    try {
      Path path = Paths.get(file.getPath());
      byte[] data = Files.readAllBytes(path);
      pdf = new PDFFile(ByteBuffer.wrap(data));
    } catch (IOException e) {
      e.printStackTrace();
      return images;
    }

    for (int i = 1; i <= pdf.getNumPages(); i++) {
      PDFPage page = pdf.getPage(i);
      Image pageImage = page.getImage((int) page.getWidth(), (int) page.getHeight(), null, (ImageObserver) this);
      images.add(pageImage);
    }
    return images;
  }
}
