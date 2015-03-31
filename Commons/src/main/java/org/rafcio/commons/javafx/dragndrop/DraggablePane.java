package org.rafcio.commons.javafx.dragndrop;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class DraggablePane extends StackPane{
	
	Pane contentPane;
	Pane glassPane;

	public DraggablePane(Pane contentPane){
		this.contentPane = contentPane;
		this.glassPane = new Pane();
		this.glassPane.setMouseTransparent(true);//disable mouse event pickup when entering this area
		getChildren().addAll(this.contentPane, this.glassPane);
	}
	
	public Pane getGlassPane(){
		return glassPane;
	}
	
	public Pane getContentPane(){
		return contentPane;
	}
}
