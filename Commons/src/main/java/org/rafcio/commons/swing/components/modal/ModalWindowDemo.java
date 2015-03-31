package org.rafcio.commons.swing.components.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import org.rafcio.commons.swing.components.widgets.BusySpinner;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author rafal.kojta
 */
@SuppressWarnings("serial")
public class ModalWindowDemo extends JFrame{
  
  public JFrame mainWindowInstance = this;
  
  JPanel simplePanel;
  JPanel closeActionPanel;
  JPanel spinnerModalInterctionPanel;
  ModalWindow modalWindow;

  BusySpinner spinner;
  ModalWindow spinnerModalWindow;

  JButton btnSimpleModal;
  JButton btnCloseActionModal;
  JButton btnBusySpinnerModal;
  JButton btnModalSpinnerInteraction;
  private JTextField inputTimerDuration;
  private JTextField inputSpinnerCaption;
  private JLabel lblTimeDuration;
  private JLabel lblCaption;

  public ModalWindowDemo() {
    createSimplePanel();
    createBusySpinnerModal();
    createCloseActionPanel();
    createSpinnerModalInteractionPanel();

    modalWindow = new DefaultModalWindow();

    initComponents();
    initActions();
  }

  private void initComponents(){
    getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
        FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC,
        FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC,
        FormFactory.RELATED_GAP_COLSPEC,
        ColumnSpec.decode("50px"),
        FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC,
        FormFactory.RELATED_GAP_COLSPEC,
        ColumnSpec.decode("150px"),},
      new RowSpec[] {
        FormFactory.RELATED_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC,
        FormFactory.RELATED_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC,
        FormFactory.RELATED_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC,
        FormFactory.RELATED_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC,
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("300px:grow"),}));
    
    btnSimpleModal = new JButton("Show Simple Modal");
    getContentPane().add(btnSimpleModal, "2, 2");

    btnCloseActionModal = new JButton("Show Close Action Modal");
    getContentPane().add(btnCloseActionModal, "2, 4");

    btnBusySpinnerModal = new JButton("Show Timer BusySpinnerPanel Modal");
    getContentPane().add(btnBusySpinnerModal, "2, 6");

    lblTimeDuration = new JLabel("Time Duration (ms):");
    getContentPane().add(lblTimeDuration, "4, 6, right, default");

    inputTimerDuration = new JTextField();
    inputTimerDuration.setText("1000");
    getContentPane().add(inputTimerDuration, "6, 6, fill, default");
    inputTimerDuration.setColumns(10);

    lblCaption = new JLabel("Caption:");
    getContentPane().add(lblCaption, "8, 6, right, default");

    inputSpinnerCaption = new JTextField();
    inputSpinnerCaption.setText("Loading stuffs...");
    getContentPane().add(inputSpinnerCaption, "10, 6, fill, default");
    inputSpinnerCaption.setColumns(10);

    btnModalSpinnerInteraction = new JButton("Show Modal-Spinner Interaction");
    getContentPane().add(btnModalSpinnerInteraction, "2, 8");
    


    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 600);
    setVisible(true);
  }

  private void initActions() {
    btnSimpleModal.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionShowSimplePanel();
      }
    });
    btnCloseActionModal.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionShowCloseActionModal();
      }
    });
    btnBusySpinnerModal.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionShowSpinner(inputSpinnerCaption.getText(), Integer.parseInt(inputTimerDuration.getText()));
      }
    });
    btnModalSpinnerInteraction.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionShowSpinnerModalInteraction();
      }
    });
  }

  private void actionShowSimplePanel() {
    modalWindow.setContent(simplePanel);
    modalWindow.setStretchContent(true);
    modalWindow.setBackgroundClickActionEnabled(true);
    modalWindow.setBackgroundClickActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        modalWindow.hideModal();
      }
    });
    setGlassPane((DefaultModalWindow) modalWindow);
    modalWindow.showModal();
  }

  private void actionShowCloseActionModal() {
    modalWindow.setContent(closeActionPanel);
    modalWindow.setBackgroundClickActionEnabled(false);
    setGlassPane((DefaultModalWindow) modalWindow);
    modalWindow.showModal();
  }

  private void actionShowSpinner(String message, int duration) {
    spinner.showBusySpinner(message);

    final Timer timer = new Timer(duration, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        spinner.hideBusySpinner();
        spinnerModalWindow.hideModal();
      }
    });
    timer.setRepeats(false);
    timer.start();

    setGlassPane((DefaultModalWindow) spinnerModalWindow);
    spinnerModalWindow.showModal();
  }

  private void actionShowSpinnerModalInteraction() {
    modalWindow.setContent(spinnerModalInterctionPanel);
    modalWindow.setBackgroundClickActionEnabled(false);
    setGlassPane((DefaultModalWindow) modalWindow);
    modalWindow.showModal();
  }

  private void createSimplePanel() {
    simplePanel = new JPanel();
    simplePanel.setLayout(new BorderLayout());
    simplePanel.setBackground(new Color(30, 170, 60));
    JLabel lbl = new JLabel("Simple Panel - click outside of this panel to close it.");
    lbl.setHorizontalAlignment(JLabel.CENTER);
    simplePanel.add(lbl, BorderLayout.CENTER);
  }

  private void createCloseActionPanel() {   
    closeActionPanel = new JPanel();
    closeActionPanel.setLayout(new FormLayout(new ColumnSpec[] {
        FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC,},
      new RowSpec[] {
        FormFactory.RELATED_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC,}));
    closeActionPanel.setBackground(new Color(60, 170, 30));
    JButton btn = new JButton("Close modal");
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        modalWindow.hideModal();
      }
    });
    closeActionPanel.add(btn, "2 ,2");
  }

  private void createBusySpinnerModal() {
    spinner = new BusySpinner();
    spinnerModalWindow = new DefaultModalWindow();
    spinnerModalWindow.setContent(spinner);
    spinnerModalWindow.setStretchContent(false);
    spinnerModalWindow.setBackgroundClickActionEnabled(false);
  }

  private void createSpinnerModalInteractionPanel() {
    spinnerModalInterctionPanel = new JPanel();
    spinnerModalInterctionPanel.setLayout(new FormLayout(new ColumnSpec[] {
        FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC,},
      new RowSpec[] {
        FormFactory.RELATED_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC,
        FormFactory.RELATED_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC,}));
    spinnerModalInterctionPanel.setBackground(new Color(60, 170, 30));
    JButton btnShowSpinner = new JButton("Show Spinner");
    btnShowSpinner.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        runSpinnerModalInteraction();
      }
    });
    spinnerModalInterctionPanel.add(btnShowSpinner, "2, 2");
    JButton btnClose = new JButton("Close");
    btnClose.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        modalWindow.hideModal();
      }
    });
    spinnerModalInterctionPanel.add(btnClose, "2, 4");
  }
  
  private void runSpinnerModalInteraction() {
    final Timer timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Showing modal modal window again");
        spinner.hideBusySpinner();
        spinnerModalWindow.hideModal();
        modalWindow.setContent(spinnerModalInterctionPanel);
        mainWindowInstance.setGlassPane((DefaultModalWindow) modalWindow);
        modalWindow.showModal();
      }
    });
    timer.setRepeats(false);
    timer.start();

    setGlassPane((DefaultModalWindow) spinnerModalWindow);
    spinnerModalWindow.showModal();
    spinner.showBusySpinner("Displaying spinner for 1 second...");
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        new ModalWindowDemo();
      }
    });
  }
}
