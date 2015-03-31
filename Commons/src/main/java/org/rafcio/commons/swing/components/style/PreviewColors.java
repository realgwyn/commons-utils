/*
 * Copyright (c) 2015 iTAC Software AG, Germany. All Rights Reserved.
 * 
 * This software is protected by copyright. Under no circumstances may any part of this file in any form be copied,
 * printed, edited or otherwise distributed, be stored in a retrieval system, or be translated into another language
 * without the written permission of iTAC Software AG.
 */
package org.rafcio.commons.swing.components.style;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author rafal.kojta
 */
public class PreviewColors extends JPanel{
  public PreviewColors() {
    setBackground(Color.WHITE);
    setLayout(new FormLayout(new ColumnSpec[] {
        FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC,
        FormFactory.RELATED_GAP_COLSPEC,
        ColumnSpec.decode("default:grow"),
        FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC,
        FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC,
        FormFactory.RELATED_GAP_COLSPEC,
        ColumnSpec.decode("default:grow"),
        FormFactory.RELATED_GAP_COLSPEC,
        FormFactory.DEFAULT_COLSPEC,},
      new RowSpec[] {
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),
        FormFactory.RELATED_GAP_ROWSPEC,
        RowSpec.decode("fill:default:grow"),}));
    
    JLabel lblColorblue = new JLabel("Color.blue");
    lblColorblue.setForeground(DefaultColors.blue);
    add(lblColorblue, "2, 2");
    
    JPanel panelBlue = new JPanel();
    panelBlue.setBackground(DefaultColors.blue);
    add(panelBlue, "4, 2, fill, fill");
    
    JButton btnBlue = new JButton("Blue");
    btnBlue.setForeground(DefaultColors.blue);
    add(btnBlue, "6, 2");
    
    JLabel lblColorred = new JLabel("Color.red");
    lblColorred.setForeground(DefaultColors.red);
    add(lblColorred, "8, 2");
    
    JPanel panelRed = new JPanel();
    panelRed.setBackground(DefaultColors.red);
    add(panelRed, "10, 2, fill, fill");
    
    JButton btnRed = new JButton("Red");
    btnRed.setForeground(DefaultColors.red);
    add(btnRed, "12, 2");
    
    JLabel lblColorbluedark = new JLabel("Color.blueDark");
    lblColorbluedark.setForeground(DefaultColors.blueDark);
    add(lblColorbluedark, "2, 4");
    
    JPanel panelBlueDark = new JPanel();
    panelBlueDark.setBackground(DefaultColors.blueDark);
    add(panelBlueDark, "4, 4, fill, fill");
    
    JButton btnBlueDark = new JButton("Blue Dark");
    btnBlueDark.setForeground(DefaultColors.blueDark);
    add(btnBlueDark, "6, 4");
    
    JLabel lblColorreddark = new JLabel("Color.redDark");
    lblColorreddark.setForeground(DefaultColors.redDark);
    add(lblColorreddark, "8, 4");
    
    JPanel panelRedDark = new JPanel();
    panelRedDark.setBackground(DefaultColors.redDark);
    add(panelRedDark, "10, 4, fill, fill");
    
    JButton btnRedDark = new JButton("Red Dark");
    btnRedDark.setForeground(DefaultColors.redDark);
    add(btnRedDark, "12, 4");
    
    JLabel lblColorgreen = new JLabel("Color.green");
    lblColorgreen.setForeground(DefaultColors.green);
    add(lblColorgreen, "2, 6");
    
    JPanel panelGreen = new JPanel();
    panelGreen.setBackground(DefaultColors.green);
    add(panelGreen, "4, 6, fill, fill");
    
    JButton btnGreen = new JButton("Green");
    btnGreen.setForeground(DefaultColors.green);
    add(btnGreen, "6, 6");
    
    JLabel lblColorreddarker = new JLabel("Color.redDarker");
    lblColorreddarker.setForeground(DefaultColors.redDarker);
    add(lblColorreddarker, "8, 6");
    
    JPanel panelRedDarker = new JPanel();
    panelRedDarker.setBackground(DefaultColors.redDarker);
    add(panelRedDarker, "10, 6, fill, fill");
    
    JButton btnRedDarker = new JButton("Red Darker");
    btnRedDarker.setForeground(DefaultColors.redDarker);
    add(btnRedDarker, "12, 6");
    
    JLabel lblColorgreendark = new JLabel("Color.greenDark");
    lblColorgreendark.setForeground(DefaultColors.greenDark);
    add(lblColorgreendark, "2, 8");
    
    JPanel panelGreenDark = new JPanel();
    panelGreenDark.setBackground(DefaultColors.greenDark);
    add(panelGreenDark, "4, 8, fill, fill");
    
    JButton btnGreenDark = new JButton("Green Dark");
    btnGreenDark.setForeground(DefaultColors.greenDark);
    add(btnGreenDark, "6, 8");
    
    JLabel lblColorgraydark = new JLabel("Color.grayDark");
    lblColorgraydark.setForeground(DefaultColors.grayDark);
    add(lblColorgraydark, "8, 8");
    
    JPanel panelGrayDark = new JPanel();
    panelGrayDark.setBackground(DefaultColors.grayDark);
    add(panelGrayDark, "10, 8, fill, fill");
    
    JButton btnGrayDark = new JButton("Gray Dark");
    btnGrayDark.setForeground(DefaultColors.grayDark);
    add(btnGrayDark, "12, 8");
    
    JLabel lblColorgreendarker = new JLabel("Color.greenDarker");
    lblColorgreendarker.setForeground(DefaultColors.greenDarker);
    add(lblColorgreendarker, "2, 10");
    
    JPanel panelGreenDarker = new JPanel();
    panelGreenDarker.setBackground(DefaultColors.greenDarker);
    add(panelGreenDarker, "4, 10, fill, fill");
    
    JButton btnGreenDarker = new JButton("Green Darker");
    btnGreenDarker.setForeground(DefaultColors.greenDarker);
    add(btnGreenDarker, "6, 10");
    
    JLabel lblColorgraydarker = new JLabel("Color.grayDarker");
    lblColorgraydarker.setForeground(DefaultColors.grayDarker);
    add(lblColorgraydarker, "8, 10");
    
    JPanel panelGrayDarker = new JPanel();
    panelGrayDarker.setBackground(DefaultColors.grayDarker);
    add(panelGrayDarker, "10, 10, fill, fill");
    
    JButton btnGrayDarker = new JButton("Gray Darker");
    btnGrayDarker.setForeground(DefaultColors.grayDarker);
    add(btnGrayDarker, "12, 10");
    
    JLabel lblColorlightblue = new JLabel("Color.lightblue");
    lblColorlightblue.setForeground(DefaultColors.lightblue);
    add(lblColorlightblue, "2, 12");
    
    JPanel panelLightblue = new JPanel();
    panelLightblue.setBackground(DefaultColors.lightblue);
    add(panelLightblue, "4, 12, fill, fill");
    
    JButton btnLightBlue = new JButton("Light Blue");
    btnLightBlue.setForeground(DefaultColors.lightblue);
    add(btnLightBlue, "6, 12");
    
    JLabel lblColorgray = new JLabel("Color.gray");
    lblColorgray.setForeground(DefaultColors.gray);
    add(lblColorgray, "8, 12");
    
    JPanel panelGray = new JPanel();
    panelGray.setBackground(DefaultColors.gray);
    add(panelGray, "10, 12, fill, fill");
    
    JButton btnGray = new JButton("Gray");
    btnGray.setForeground(DefaultColors.gray);
    add(btnGray, "12, 12");
    
    JLabel lblColorlightbluedarker = new JLabel("Color.lightblueDarker");
    lblColorlightbluedarker.setForeground(DefaultColors.lightblueDarker);
    add(lblColorlightbluedarker, "2, 14");
    
    JPanel panelLightblueDarker = new JPanel();
    panelLightblueDarker.setBackground(DefaultColors.lightblueDarker);
    add(panelLightblueDarker, "4, 14, fill, fill");
    
    JButton btnLightBlueDarker = new JButton("Light Blue Darker");
    btnLightBlueDarker.setForeground(DefaultColors.lightblueDarker);
    add(btnLightBlueDarker, "6, 14");
    
    JLabel lblColorgraylight = new JLabel("Color.grayLight");
    lblColorgraylight.setForeground(DefaultColors.grayLight);
    add(lblColorgraylight, "8, 14");
    
    JPanel panelGrayLight = new JPanel();
    panelGrayLight.setBackground(DefaultColors.grayLight);
    add(panelGrayLight, "10, 14, fill, fill");
    
    JButton btnGrayLight = new JButton("Gray Light");
    btnGrayLight.setForeground(DefaultColors.grayLight);
    add(btnGrayLight, "12, 14");
    
    JLabel lblColororange = new JLabel("Color.orange");
    lblColororange.setForeground(DefaultColors.orange);
    add(lblColororange, "2, 16");
    
    JPanel panelOrange = new JPanel();
    panelOrange.setBackground(DefaultColors.orange);
    add(panelOrange, "4, 16, fill, fill");
    
    JButton btnOrange = new JButton("Orange");
    btnOrange.setForeground(DefaultColors.orange);
    add(btnOrange, "6, 16");
    
    JLabel lblColorgraylighter = new JLabel("Color.grayLighter");
    lblColorgraylighter.setBackground(Color.BLACK);
    lblColorgraylighter.setOpaque(true);
    lblColorgraylighter.setForeground(DefaultColors.grayLighter);
    add(lblColorgraylighter, "8, 16");
    
    JPanel panelGrayLighter = new JPanel();
    panelGrayLighter.setBackground(DefaultColors.grayLighter);
    add(panelGrayLighter, "10, 16, fill, fill");
    
    JButton btnGrayLighter = new JButton("Gray Lighter");
    btnGrayLighter.setForeground(DefaultColors.grayLighter);
    add(btnGrayLighter, "12, 16");
    
    JLabel lblColororangedark = new JLabel("Color.orangeDark");
    lblColororangedark.setForeground(DefaultColors.orangeDark);
    add(lblColororangedark, "2, 18");
    
    JPanel panelOrangeDark = new JPanel();
    panelOrangeDark.setBackground(DefaultColors.orangeDark);
    add(panelOrangeDark, "4, 18, fill, fill");
    
    JButton btnOrangeDark = new JButton("Orange Dark");
    btnOrangeDark.setForeground(DefaultColors.orangeDark);
    add(btnOrangeDark, "6, 18");
    
    JLabel lblColorpalegreen = new JLabel("Color.paleGreen");
    lblColorpalegreen.setBackground(Color.BLACK);
    lblColorpalegreen.setOpaque(true);
    lblColorpalegreen.setForeground(DefaultColors.paleGreen);
    add(lblColorpalegreen, "8, 18");
    
    JPanel panelPaleGreen = new JPanel();
    panelPaleGreen.setBackground(DefaultColors.paleGreen);
    add(panelPaleGreen, "10, 18, fill, fill");
    
    JButton btnPaleGreen = new JButton("Pale Green");
    btnPaleGreen.setForeground(DefaultColors.paleGreen);
    add(btnPaleGreen, "12, 18");
    
    JLabel lblColororangedarker = new JLabel("Color.orangeDarker");
    lblColororangedarker.setForeground(DefaultColors.orangeDarker);
    add(lblColororangedarker, "2, 20");
    
    JPanel panelOrangeDarker = new JPanel();
    panelOrangeDarker.setBackground(DefaultColors.orangeDarker);
    add(panelOrangeDarker, "4, 20, fill, fill");
    
    JButton btnOrangeDarker = new JButton("Orange Darker");
    btnOrangeDarker.setForeground(DefaultColors.orangeDarker);
    add(btnOrangeDarker, "6, 20");
    
    JLabel lblColorpaleblue = new JLabel("Color.paleBlue");
    lblColorpaleblue.setBackground(Color.BLACK);
    lblColorpaleblue.setOpaque(true);
    lblColorpaleblue.setForeground(DefaultColors.paleBlue);
    add(lblColorpaleblue, "8, 20");
    
    JPanel panelPaleBlue = new JPanel();
    panelPaleBlue.setBackground(DefaultColors.paleBlue);
    add(panelPaleBlue, "10, 20, fill, fill");
    
    JButton btnPaleBlue = new JButton("Pale Blue");
    btnPaleBlue.setForeground(DefaultColors.paleBlue);
    add(btnPaleBlue, "12, 20");
    
    JLabel lblColorpaleorange = new JLabel("Color.paleOrange");
    lblColorpaleorange.setBackground(Color.BLACK);
    lblColorpaleorange.setOpaque(true);
    lblColorpaleorange.setForeground(DefaultColors.paleOrange);
    add(lblColorpaleorange, "8, 22");
    
    JPanel panelPaleOrange = new JPanel();
    panelPaleOrange.setBackground(DefaultColors.paleOrange);
    add(panelPaleOrange, "10, 22, fill, fill");
    
    JButton btnPaleOrange = new JButton("Pale Orange");
    btnPaleOrange.setForeground(DefaultColors.paleOrange);
    add(btnPaleOrange, "12, 22");
    
    JLabel lblColorpalered = new JLabel("Color.paleRed");
    lblColorpalered.setBackground(Color.BLACK);
    lblColorpalered.setOpaque(true);
    lblColorpalered.setForeground(DefaultColors.paleRed);
    add(lblColorpalered, "8, 24");
    
    JPanel panelPaleRed = new JPanel();
    panelPaleRed.setBackground(DefaultColors.paleRed);
    add(panelPaleRed, "10, 24, fill, fill");
    
    JButton btnPaleRed = new JButton("Pale Red");
    btnPaleRed.setForeground(DefaultColors.paleRed);
    add(btnPaleRed, "12, 24");
  }
  
  public static void main(String [] args){
    SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(new Dimension(600,800));
        PreviewColors panel = new PreviewColors();
        frame.setContentPane(panel);
      }
    });

  }

}
