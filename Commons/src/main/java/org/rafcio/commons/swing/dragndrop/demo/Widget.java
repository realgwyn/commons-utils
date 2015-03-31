package org.rafcio.commons.swing.dragndrop.demo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class Widget extends JPanel {

  JLabel lblCurrentStateValue;
  JLabel lblNumber;
  Integer number = 0;

  public Widget() {
    setLayout(new FormLayout(new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("70dlu"),
        FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("50dlu"), FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
        FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
        FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormFactory.RELATED_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, }));

    setBackground(new Color(132, 206, 0));

    JLabel lblNewLabel = new JLabel("Draggable Widget");
    lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
    add(lblNewLabel, "2, 2, 3, 1");

    JLabel lblNewLabel_1 = new JLabel("extends JPanel");
    lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
    add(lblNewLabel_1, "2, 4");

    lblNumber = new JLabel(number.toString());
    lblNumber.setHorizontalAlignment(SwingConstants.RIGHT);
    lblNumber.setFont(new Font("Verdana", Font.PLAIN, 14));
    add(lblNumber, "4, 4");

    JLabel lblContent = new JLabel("<html>To enable drag & drop ability, this class is wrapped by DraggableComponent class.</html>");
    lblContent.setFont(new Font("Verdana", Font.PLAIN, 11));
    add(lblContent, "2, 6, 3, 1");

    JLabel lblNewLabel_2 = new JLabel("current state: ");
    lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
    add(lblNewLabel_2, "2, 8");

    lblCurrentStateValue = new JLabel("DEFAULT");
    lblCurrentStateValue.setFont(new Font("Verdana", Font.PLAIN, 13));
    add(lblCurrentStateValue, "4, 8");
  }

  public void setStateName(String state) {
    lblCurrentStateValue.setText(state);
  }

  public String getState() {
    return lblCurrentStateValue.getText();
  }

  public void incrementNumber() {
    number++;
    lblNumber.setText(number.toString());
  }
}
