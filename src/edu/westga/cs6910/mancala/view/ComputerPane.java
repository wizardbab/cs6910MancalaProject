package edu.westga.cs6910.mancala.view;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Defines the pane that lets the user tell the computer player to
 * take its turn and that displays the setup of this player's side
 * of the board
 * 
 * @author En Yang Pang
 * @version 06/10/2019
 */
public class ComputerPane extends GridPane implements InvalidationListener {

	private Button btnTakeTurn;
	
	private ComputerPlayer theComputer;
	private Game theGame;
	
	/**
	 * Creates a new ComputerPane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public ComputerPane(Game theGame) {
		this.theGame = theGame;
		
		this.theGame.addListener(this);
		this.theComputer = this.theGame.getComputerPlayer();
		
		this.buildPane();
	}
	
	private void buildPane() {
		HBox topBox = new HBox();
		topBox.getChildren().add(new Label("Computer"));
		this.add(topBox, 0, 0);
		
		this.setHgap(50);
		
		int column = this.theGame.getBoardSize() - 1;
		this.add(new PitPane(column, true, this.theGame), 0, 1);
		for (column = this.theGame.getBoardSize() - 1; column > this.theGame.getBoardSize() / 2; column--) {
			this.add(new PitPane(column - 1, false, this.theGame), this.theGame.getBoardSize() - column, 1);
		}
		this.createUserInteractionArea();
	}
	
	private void createUserInteractionArea() {
		GridPane interactionPane = new GridPane();
		interactionPane.getStyleClass().add("pane-border");
		interactionPane.getStyleClass().add("bg-highlight-style");
		
		this.btnTakeTurn = new Button("Take Turn");
		this.btnTakeTurn.setOnAction(new TakeTurnListener());
		interactionPane.add(this.btnTakeTurn, 0, 0);
		
		this.add(interactionPane, 4, 1);
	}

	@Override
	public void invalidated(Observable arg0) {
		if (this.theGame.getIsGameOver()) {
			this.setDisable(true);
			return;
		}
		
		boolean myTurn = this.theGame.getCurrentPlayer() == this.theComputer;
		this.setDisable(!myTurn);
	}

	/* 
	 * Defines the listener for takeTurnButton.
	 */
	private class TakeTurnListener implements EventHandler<ActionEvent> {

		/* 
		 * Tells the Game to have its current player (i.e., the computer player)
		 * take its turn.	
		 * 
		 * @see javafx.event.EventHandler#handle(T-extends-javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent arg0) {
			if (!ComputerPane.this.theGame.getIsGameOver()) {
				ComputerPane.this.theGame.play(-1);
			}
			if (ComputerPane.this.theGame.getComputerPlayer().getIsMyTurn() && !ComputerPane.this.theGame.getIsGameOver()) {
				Alert goAgainAlert = new Alert(Alert.AlertType.INFORMATION);
				goAgainAlert.setTitle("Move Again");
				goAgainAlert.setContentText("Your last stone was in the store. You may go again.");
				goAgainAlert.showAndWait();
			}
			
		}
	}
}