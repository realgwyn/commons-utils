package org.rafcio.commons.swing.components.preview.image;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Swing component to display multiple images.
 *
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public abstract class ImageGalleryPanel extends JPanel {

  public static enum DisplayMode {
    DISPLAY_VERTICAL, DISPLAY_HORIZONTAL, DISPLAY_SINGLE_PAGE
  }

  public static enum ZoomMode {
    ZOOM_FIT_PAGE, ZOOM_ACTUAL_SIZE, ZOOM_FIT_HEIGHT, ZOOM_FIT_WIDTH
  }

  private DisplayMode displayMode = DisplayMode.DISPLAY_VERTICAL;
  private JPanel contentPanel;
  private JScrollPane scrollPane;
  private List<Image> images;

  private static final int PADDING = 10;

  public ImageGalleryPanel() {
    images = new ArrayList<Image>();
    setLayout(new BorderLayout(0, 0));

    contentPanel = new JPanel();
    scrollPane = new JScrollPane(contentPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    add(scrollPane);
    setScrollBarVerticalUnitIncrement(16);
  }

  public ImageGalleryPanel(DisplayMode displayMode) {
    this();
    setDisplayMode(displayMode);
  }

  public ImageGalleryPanel(List<Image> imagesList) {
    this();
    setImages(imagesList);
  }

  public ImageGalleryPanel(List<Image> imagesList, DisplayMode displayStrategy) {
    this();
    setDisplayMode(displayStrategy);
    setImages(imagesList);
  }

  public void setDisplayMode(DisplayMode displayMode) {
    this.displayMode = displayMode;
    if (displayMode == null) {
      throw new IllegalArgumentException("Display mode not set");
    }
    createDisplayLayout();
  }

  public void setImages(List<Image> images) {
    this.images = images;
    createDisplayLayout();
    revalidate();
    repaint();
  }

  public Dimension getDisplayAreaSize() {
    Dimension d = getSize();
    int verticalScrollWidth = scrollPane.getVerticalScrollBar().getWidth();
    int HorizontalScrollHeight = scrollPane.getHorizontalScrollBar().getHeight();
    d.width -= (verticalScrollWidth + 3 + (2 * PADDING));
    d.height -= (HorizontalScrollHeight + 3 + (2 * PADDING));

    // Avoid negative dimension size
    if (d.width <= 0 || d.height <= 0) {
      d = new Dimension(1, 1);
    }

    return d;
  }

  private void createDisplayLayout() {
    contentPanel.removeAll();
    switch (displayMode) {
    case DISPLAY_VERTICAL:
      createVerticalLayout();
      break;
    case DISPLAY_HORIZONTAL:
      createHorizontalLayout();
      break;
    case DISPLAY_SINGLE_PAGE:
      createSinglePageLayout();
      break;
    default:
      createVerticalLayout();
    }
  }

  private void createVerticalLayout() {
    FormLayout layout = new FormLayout(new ColumnSpec[] { ColumnSpec.decode(PADDING + "px"),
        ColumnSpec.decode("center:default:grow"), ColumnSpec.decode(PADDING + "px"), }, new RowSpec[] {});

    layout.appendRow(FormFactory.RELATED_GAP_ROWSPEC);
    contentPanel.setLayout(layout);

    int rowIndex = 2;
    for (Image image : images) {
      layout.appendRow(RowSpec.decode(image.getHeight(null) + "px"));
      ImagePanel pagePanel = new ImagePanel(image);
      contentPanel.add(pagePanel, "2, " + rowIndex);
      layout.appendRow(FormFactory.RELATED_GAP_ROWSPEC);
      rowIndex += 2;
    }
  }

  private void createHorizontalLayout() {
    FormLayout layout = new FormLayout(new ColumnSpec[] {}, new RowSpec[] { RowSpec.decode(PADDING + "px"),
        RowSpec.decode("center:default:grow"), RowSpec.decode(PADDING + "px"), });

    layout.appendColumn(FormFactory.RELATED_GAP_COLSPEC);
    contentPanel.setLayout(layout);

    int colIndex = 2;
    for (Image image : images) {
      layout.appendColumn(ColumnSpec.decode(image.getWidth(null) + "px"));
      ImagePanel pagePanel = new ImagePanel(image);
      contentPanel.add(pagePanel, colIndex + ", 2");
      layout.appendColumn(FormFactory.RELATED_GAP_COLSPEC);
      colIndex += 2;
    }
  }

  private void createSinglePageLayout() {
    throw new UnsupportedOperationException("Not implemented yet: Single Page Display Mode.");
  }

  public void setHorizontalScrollBarPolicy(int policy) {
    scrollPane.setHorizontalScrollBarPolicy(policy);
  }

  public void setVerticalScrollBarPolicy(int policy) {
    scrollPane.setVerticalScrollBarPolicy(policy);
  }

  public void setScrollBarVerticalUnitIncrement(int value) {
    scrollPane.getVerticalScrollBar().setUnitIncrement(value);
  }

  public abstract void refresh();

  protected float zoomValue = 1f;

  public void setZoomValue(float value) {
    zoomValue = value;
  }

}
