package swing.dragndrop.demo;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import swing.dragndrop.DraggableComponent;
import swing.dragndrop.DroppableContainer;
import swing.dragndrop.GraphicsUtils;
import swing.dragndrop.ImagePanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * This demo shows how to use DragAndDrop classes to create components with drag and drop ability.
 * 
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class DragAndDropDemo extends JFrame {

  private JPanel contentPane;
  private JTextField textField;

  /**
   * Create the frame.
   */
  public DragAndDropDemo() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 724, 569);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("150dlu"),
        FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("150dlu"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("150dlu"),
        FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("110dlu"),
        FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("110dlu"), FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("110dlu"), }));

    DroppableContainer slot1 = new DroppableContainer();
    contentPane.add(slot1, "2, 2, fill, fill");
    DroppableContainer slot2 = new DroppableContainer();
    contentPane.add(slot2, "4, 2, fill, fill");
    DroppableContainer slot3 = new DroppableContainer();
    contentPane.add(slot3, "6, 2, fill, fill");
    DroppableContainer slot4 = new DroppableContainer();
    contentPane.add(slot4, "2, 4, fill, fill");
    DroppableContainer slot5 = new DroppableContainer();
    contentPane.add(slot5, "4, 4, fill, fill");
    DroppableContainer slot6 = new DroppableContainer();
    contentPane.add(slot6, "6, 4, fill, fill");
    DroppableContainer slot7 = new DroppableContainer();
    contentPane.add(slot7, "2, 6, fill, fill");
    DroppableContainer slot8 = new DroppableContainer();
    contentPane.add(slot8, "4, 6, fill, fill");
    DroppableContainer slot9 = new DroppableContainer();
    contentPane.add(slot9, "6, 6, fill, fill");

    initDraggableJComponents(slot4, slot5, slot6);
    initDraggablePanel(slot1);
    initDraggableWidget(slot2);

  }

  private void initDraggableJComponents(DroppableContainer slot1, DroppableContainer slot2, DroppableContainer slot3) {
    JLabel lblSimpleLabel = new JLabel("Simple Label");
    lblSimpleLabel.setBorder(new LineBorder(SystemColor.textHighlight));
    DraggableComponent c1 = new DraggableComponent(lblSimpleLabel);
    slot1.insertDraggableComponent(c1);

    JLabel lblImageLabel = new JLabel("Image Label");
    Image img2 = GraphicsUtils.loadImage("traffic_green.png");
    lblImageLabel.setIcon(new ImageIcon(img2));
    lblImageLabel.setOpaque(false);
    lblImageLabel.setBorder(new LineBorder(SystemColor.textHighlight));
    DraggableComponent c2 = new DraggableComponent(lblImageLabel);
    slot2.insertDraggableComponent(c2);

    Image img3 = GraphicsUtils.loadImage("traffic_red.png");
    ImagePanel imagePanel = new ImagePanel(img3);
    imagePanel.setBackground(SystemColor.textHighlight);
    DraggableComponent c3 = new DraggableComponent(imagePanel);
    slot3.insertDraggableComponent(c3);
  }

  private void initDraggablePanel(DroppableContainer slot) {
    JPanel panel = new JPanel();
    panel.setBorder(new LineBorder(SystemColor.textHighlight));
    panel.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
        FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
        FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, }));

    JLabel lblDraggablePanel = new JLabel("Complex Object");
    panel.add(lblDraggablePanel, "2, 2");

    textField = new JTextField();
    panel.add(textField, "2, 4, fill, default");
    textField.setColumns(10);

    JButton btnNewButton = new JButton("New button");
    panel.add(btnNewButton, "2, 6");

    JComboBox comboBox = new JComboBox();
    panel.add(comboBox, "2, 8, fill, default");

    DraggableComponent c = new DraggableComponent(panel);
    slot.insertDraggableComponent(c);
  }

  /**
   * DraggedComponents can have custom DragResolvers and Renderers.
   */
  private void initDraggableWidget(DroppableContainer slot) {
    Widget widget = new Widget();
    DraggableWidgetRenderer renderer = new DraggableWidgetRenderer(widget);
    WidgetDragResolver resolver = new WidgetDragResolver();
    DraggableComponent c = new DraggableComponent(widget, resolver, renderer);
    slot.insertDraggableComponent(c);
  }

  public static void resolveLookAndFeel() {
    try {
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Windows".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (Exception e) {
      // If Nimbus is not available, fall back to cross-platform
      e.printStackTrace();
      try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    resolveLookAndFeel();
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          DragAndDropDemo frame = new DragAndDropDemo();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

}
