package org.rafcio.commons.javafx.dragndrop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DragAndDropFXDemo extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane contentPane = initContentPane();
			DraggablePane draggablePane = new DraggablePane(contentPane);
			Scene scene = new Scene(draggablePane,400,400);
			scene.getStylesheets().add(DragAndDropFXDemo.class.getResource("style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			DroppableContainer slot1 = createDroppableContainer();
			contentPane.add(slot1, 1, 1);
			DroppableContainer slot2 = createDroppableContainer();
			contentPane.add(slot2, 2, 1);
			DroppableContainer slot3 = createDroppableContainer();
			contentPane.add(slot3, 3, 1);
			DroppableContainer slot4 = createDroppableContainer();
			contentPane.add(slot4, 1, 2);
			DroppableContainer slot5 = createDroppableContainer();
			contentPane.add(slot5, 2, 2);
			DroppableContainer slot6 = createDroppableContainer();
			contentPane.add(slot6, 3, 2);
			DroppableContainer slot7 = createDroppableContainer();
			contentPane.add(slot7, 1, 3);
			DroppableContainer slot8 = createDroppableContainer();
			contentPane.add(slot8, 2, 3);
			DroppableContainer slot9 = createDroppableContainer();
			contentPane.add(slot9, 3, 3);
			
			initDraggableFXComponents(slot4,slot5,slot6);
			initDraggablePanel(slot1);
			initDraggableWidget(slot2);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private DroppableContainer createDroppableContainer(){
		DroppableContainer slot = new DroppableContainer();
		slot.setPrefHeight(150);
		slot.setPrefWidth(150);
		slot.setId("slot");
		return slot;
	}
	
	private void initDraggableFXComponents(DroppableContainer slot1, DroppableContainer slot2, DroppableContainer slot3){
		Label lblSimpleLabel = new Label("Simple Label");
		lblSimpleLabel.setStyle("-fx-border-color: red;");
		DraggableComponent c1 = new DraggableComponent(lblSimpleLabel);
		slot1.insertDraggableComponent(c1);
		
		Button btnSimpleButton = new Button("Simple Button");
		DraggableComponent c2 = new DraggableComponent(btnSimpleButton);
		slot2.insertDraggableComponent(c2);
	}
	
	private void initDraggablePanel(DroppableContainer slot){
		
	}
	
	private void initDraggableWidget(DroppableContainer slot){
		
	}
	
	private GridPane initContentPane(){
		GridPane contentPane = new GridPane();
		contentPane.setHgap(10);
		contentPane.setVgap(10);
		contentPane.setPadding(new Insets(10, 10, 10, 10));
		return contentPane;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}