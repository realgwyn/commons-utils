package org.rafcio.commons.swing.components.modal;

import java.awt.event.ActionListener;

import javax.swing.JComponent;

/**
 * @author rafal.kojta
 */
public interface ModalWindow {
  
  public void setMargin(int marginTop, int marginRight, int marginBottom, int marginLeft);

  public void setContent(JComponent component);
  
  public void showModal();
  
  public void hideModal();
  
  public boolean isModalVisible();
  
  public JComponent getContent();
  
  public void setStretchContent(boolean stretch);
  
  public void setBackgroundClickActionListener(ActionListener listener);

  public void setBackgroundClickActionEnabled(boolean enabled);
}
