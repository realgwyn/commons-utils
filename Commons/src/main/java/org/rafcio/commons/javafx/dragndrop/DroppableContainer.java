package org.rafcio.commons.javafx.dragndrop;


import java.awt.Color;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class DroppableContainer extends GridPane {

	enum DropState {
		DEFAULT, ROLLOVER, DISABLED
	}

	DragContext context;
	DraggableComponent slot;
	boolean isEnabled = true;
	DropState currentState = DropState.DEFAULT;
	FlowPane dropSpace;

	String defaultColor = "#35CEEB";
	String focusedColor = "derive(" + defaultColor + ", 10%)";
	String disabledColor = "derive(" + defaultColor + ", -10%)";

	public DroppableContainer() {
		setStyle("-fx-background-color: black");
		setPadding(new Insets(10, 10, 10, 10));

		dropSpace = new FlowPane();
		dropSpace.setAlignment(Pos.CENTER);
		dropSpace.setStyle("-fx-background-color: " + defaultColor);
		dropSpace.setPrefHeight(80);
		dropSpace.setPrefWidth(80);
		add(dropSpace, 1, 1);

		initActions();
	}

	public DraggableComponent getDraggableComponent() {
		return slot;
	}

	public void insertDraggableComponent(DraggableComponent c) {
		slot = c;
		dropSpace.getChildren().add(c);
	}

	public void removeDraggableComponent(DraggableComponent c) {
		dropSpace.getChildren().remove(c);
		slot = null;
	}

	public boolean hasFreeSlot() {
		return (slot == null && getDropState() != DropState.DISABLED);
	}

	public void setDropState(DropState state) {
		switch (state) {
		case DEFAULT:
			dropSpace.setStyle("-fx-background-color: " + defaultColor);
			break;
		case ROLLOVER:
			dropSpace.setStyle("-fx-background-color: " + focusedColor);
			break;
		case DISABLED:
			dropSpace.setStyle("-fx-background-color: " + disabledColor);
			break;
		}
		currentState = state;
	}

	public DropState getDropState() {
		return currentState;
	}

	public void setBackgroundColor(Color color) {
		defaultColor = GraphicsUtils.colorToHex(color);
		dropSpace.setStyle("-fx-background-color: " + defaultColor);
	}

	private void initActions() {
		final DroppableContainer container = this;
		context = DragContext.getContext();

		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("entered");
				if (context.isDragged && hasFreeSlot()) {
					setDropState(DropState.ROLLOVER);
					context.targetContainer = container;
				}
			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("exited");
				if (getDropState() != DropState.DISABLED) {
					setDropState(DropState.DEFAULT);
					// deregister droppable component
					if (context.isDragged) {
						context.targetContainer = null;
					}
				}
			}
		});
	}
}
