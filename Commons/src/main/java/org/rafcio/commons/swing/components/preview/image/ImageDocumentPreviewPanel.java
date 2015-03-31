package org.rafcio.commons.swing.components.preview.image;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.rafcio.commons.swing.components.preview.image.ImageGalleryPanel.ZoomMode;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author rafal.kojta
 */
@SuppressWarnings("serial")

public class ImageDocumentPreviewPanel extends JPanel implements NavigableComponent {


  private NavigationPanel navigationPanel;
  private ImageDocumentViewer imageDocumentViewer;

  private List<ImageDocument> openedDocuments = new ArrayList<ImageDocument>();
  private int currentPageIndex = 0;

  public ImageDocumentPreviewPanel() {
    initComponents();
  }

  public void initComponents() {
    setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("default:grow"), }, new RowSpec[] { RowSpec.decode("50px"),
        RowSpec.decode("default:grow"), }));

    navigationPanel = new NavigationPanel(this);
    JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setViewportView(navigationPanel);
    add(scrollPane, "1, 1, default, fill");

    imageDocumentViewer = new ImageDocumentViewer();
    imageDocumentViewer.setZoom(ZoomMode.ZOOM_FIT_WIDTH);
    add(imageDocumentViewer, "1, 2, default, fill");

  }

  public void displayImageDocuments(List<ImageDocument> imageDocuments) {
    this.openedDocuments = imageDocuments;
    if (openedDocuments.size() > 0) {
      currentPageIndex = 0;
      showDocument(imageDocuments.get(currentPageIndex));
      navigationPanel.enableNextPageButton(true);
      navigationPanel.enablePreviousPageButton(false);
    }

    if (openedDocuments.size() == 1) {
      navigationPanel.enableNextPageButton(false);
      navigationPanel.enablePreviousPageButton(false);
    }
  }

  @Override
  public void showNextDocument() {
    if (currentPageIndex < openedDocuments.size() - 1) {
      currentPageIndex++;
      showDocument(openedDocuments.get(currentPageIndex));
    }
    if (currentPageIndex == openedDocuments.size() - 1) {
      navigationPanel.enableNextPageButton(false);
    }
    navigationPanel.enablePreviousPageButton(true);
  }

  @Override
  public void showPreviousDocument() {
    if (currentPageIndex > 0) {
      currentPageIndex--;
      showDocument(openedDocuments.get(currentPageIndex));
    }
    if (currentPageIndex == 0) {
      navigationPanel.enablePreviousPageButton(false);
    }
    navigationPanel.enableNextPageButton(true);
  }

  private void showDocument(ImageDocument document) {
    imageDocumentViewer.displayImageDocument(document);
    navigationPanel.setHeaderText(document.getName());
    navigationPanel.setDetailsText(buildCurrentPageString());
  }

  private String buildCurrentPageString() {
    return "Document " + (currentPageIndex + 1) + " of " + openedDocuments.size();
  }

}
