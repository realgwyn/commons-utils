package org.rafcio.commons.swing.components.preview.image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class NavigationPanel extends JPanel {

  private NavigableComponent navigableComponent;

  private JPanel documentInfoPanel;
  private JLabel lblHeaderText;
  private JLabel lblDetailsText;

  private JButton btnNext;
  private JButton btnPrevious;

  public NavigationPanel(NavigableComponent navigableComponent) {
    this.navigableComponent = navigableComponent;
    initComponents();
    initActions();
  }

  public void initComponents() {
    setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("max(30dlu;default)"), FormFactory.RELATED_GAP_COLSPEC,
        ColumnSpec.decode("right:min:grow"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(200dlu;default):grow"),
        FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("right:min:grow"), FormFactory.RELATED_GAP_COLSPEC,
        ColumnSpec.decode("max(30dlu;default)"), }, new RowSpec[] { RowSpec.decode("fill:max(30dlu;default):grow"), }));

    documentInfoPanel = new JPanel();
    documentInfoPanel.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("center:default:grow"), }, new RowSpec[] {
        RowSpec.decode("default:grow"), FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), }));
    this.add(documentInfoPanel, "5, 1");

    lblHeaderText = new JLabel("");
    documentInfoPanel.add(lblHeaderText, "1, 1");

    lblDetailsText = new JLabel("No file selected");
    documentInfoPanel.add(lblDetailsText, "1, 3");

    btnPrevious = new JButton("Previous file");
    this.add(btnPrevious, "1, 1");

    btnNext = new JButton("Next file");
    this.add(btnNext, "9, 1");
  }

  public void initActions() {
    btnNext.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        navigableComponent.showNextDocument();
      }
    });
    btnPrevious.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        navigableComponent.showPreviousDocument();
      }
    });
  }

  public void setHeaderText(String text) {
    lblHeaderText.setText(text);
  }

  public void setDetailsText(String text) {
    lblDetailsText.setText(text);
  }

  public void enableNextPageButton(boolean value) {
    btnNext.setEnabled(value);
  }

  public void enablePreviousPageButton(boolean value) {
    btnPrevious.setEnabled(value);
  }

}
