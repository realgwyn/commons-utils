package org.rafcio.commons.swing.components.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * This component can be used for displaying JComponents (JPanels, etc) in front of application main window.<br>
 * <br>
 * How to use:<br>
 * 
 * In application main window (JFrame) set <code>DefaultModalWindow</code> component as a glassPane:<br>
 * <br>
 * <code>
 * modalWindow = new DefaultModalWindow();<br>
 * jframe.setGlassPane(modalWindow);<br>
 * </code>
 * <br>
 * Displaying content in modal:<br>
 * <br>
 * <code>
 * JPanel fancyPanel = new FancyPanel();<br>
 * modalWindow.setContent(fancyPanel);<br>
 * modalWindow.showModal();<br>
 * ...<br>
 * modalWindo.hideModal();<br>
 * </code>
 * 
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class DefaultModalWindow extends JPanel implements ModalWindow{
  
  private ActionListener backgroundClickActionListener;
  private boolean backgroundClickActionEnabled = true;
  private JComponent content;
  private int marginTop = 100;
  private int marginRight = 100;
  private int marginBottom = 100;
  private int marginLeft = 100;
  private boolean stretch = true;
  private boolean isModalVisible = false;
  
  public DefaultModalWindow(){
    setOpaque(false);
    
    content = createDefaultPlaceholderPanel();
    backgroundClickActionListener = creadeDefaultCloseActionListener();
    
    reinitialize();
  }

  private void reinitialize() {
    removeAll();
    setLayout(buildLayout());
    add(content, "2, 2, fill, fill");
    initActions();
    repaint();
    revalidate();
  }
  
  private void initActions(){
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if(backgroundClickActionEnabled){
            backgroundClickActionListener.actionPerformed(new ActionEvent(this, MouseEvent.MOUSE_PRESSED, "ModalWindow.CloseAction"));           
        }
      }
    });
    
    //This listener is added to block backgroundClickActionListener (so the window won't close when clicking on the content panel)
    //it will not affect any custom mouse/action listeners added inside content panel. 
    content.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e){
      }
    });
  }
  
  @Override
  public void setMargin(int marginTop, int marginRight, int marginBottom, int marginLeft){
    this.marginTop = marginTop;
    this.marginLeft = marginRight;
    this.marginBottom = marginBottom;
    this.marginRight = marginLeft;
    reinitialize();
  }

  @Override
  public void setContent(JComponent component) {
    this.content = component;
    reinitialize();
  }

  @Override
  public JComponent getContent() {
    return content;
  }
  
  @Override
  public void showModal(){
    super.setVisible(true);
    isModalVisible = true;
  }
  
  @Override
  public void hideModal(){
    super.setVisible(false);
    isModalVisible = false;
  }
  
  @Override
  public boolean isModalVisible() {
    return isModalVisible;
  }
  
  @Override
  public void setStretchContent(boolean stretch){
    this.stretch = stretch;
    reinitialize();
  }
  
  @Override
  public void setBackgroundClickActionListener(ActionListener listener){
    this.backgroundClickActionListener = listener;
  }

  @Override
  public void setBackgroundClickActionEnabled(boolean enabled) {
    this.backgroundClickActionEnabled = enabled;
  }

  private FormLayout buildLayout(){
    if(stretch){
      return new FormLayout(new ColumnSpec[] {
          ColumnSpec.decode(marginTop+"px"),
          ColumnSpec.decode("default:grow"),
          ColumnSpec.decode(marginBottom+"px"),},
        new RowSpec[] {
          RowSpec.decode(marginLeft+"px"),
          RowSpec.decode("default:grow"),
          RowSpec.decode(marginRight+"px"),});
    }else{
      return new FormLayout(new ColumnSpec[] {
          ColumnSpec.decode("default:grow"),
          FormFactory.DEFAULT_COLSPEC,
          ColumnSpec.decode("default:grow"),},
        new RowSpec[] {
          RowSpec.decode("default:grow"),
          FormFactory.DEFAULT_ROWSPEC,
          RowSpec.decode("default:grow"),});
    }
  }
  
  private JPanel createDefaultPlaceholderPanel(){
    JPanel placeholder = new JPanel();
    placeholder.setLayout(new BorderLayout());
    JLabel label = new JLabel("[CONTENT]");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setFont(new Font("Tahoma", Font.PLAIN, 28));
    label.setForeground(new Color(200,200,200));
    placeholder.add(label, BorderLayout.CENTER);
    placeholder.setBackground(new Color(250,250,250));
    return placeholder;
  }
  
  private ActionListener creadeDefaultCloseActionListener(){
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          hideModal();
      }
    };
  }

}
