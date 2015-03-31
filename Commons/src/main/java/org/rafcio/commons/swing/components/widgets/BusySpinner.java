package org.rafcio.commons.swing.components.widgets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXBusyLabel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author rafal.kojta
 * @See Please see <code>view.component.modal.ModalWindowDemo.java</code> for use case examples.
 */
@SuppressWarnings("serial")
public class BusySpinner extends JPanel{
  
  private JXBusyLabel busyLabel;
  private JLabel lblMessage;
  private String defaultText;
  
  public BusySpinner(){
    setPreferredSize(new Dimension(200,100));
    setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new BevelBorder(BevelBorder.RAISED, null, null, null,
        null)));
    setBackground(Color.white);
    setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("default:grow"), FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), }, new RowSpec[] {
        FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormFactory.RELATED_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

    busyLabel = new JXBusyLabel();
    busyLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(busyLabel, "3, 4");
    
    defaultText = "Please Wait...";
    lblMessage = new JLabel(defaultText);
    lblMessage.setForeground(new Color(0, 0, 0));
    lblMessage.setBackground(Color.WHITE);
    lblMessage.setOpaque(true);
    add(lblMessage, "1, 8, 5, 1");
  }

  public void showBusySpinner() {
    showBusySpinner(defaultText);
  }

  public void showBusySpinner(String message) {
    lblMessage.setText(message);
    setVisible(true);
    busyLabel.setBusy(true);
  }

  public void hideBusySpinner() {
    setVisible(false);
    busyLabel.setBusy(false);
  }

}