package edu.westga.cs6910.mancala.view;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Defines a GUI for the Mancala game.
 * This class was started by CS6910
 * 
 * @author En Yang Pang
 * @version 06/10/2019
 * 
 */
public class MancalaPane extends BorderPane {
	private Game theGame;
	private GridPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	
	/**
	 * Creates a pane object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param 	theGame		the domain model object representing the Mancala game
	 * 
	 * @requires theGame != null
	 * @ensures	 the pane is displayed properly
	 */
	public MancalaPane(Game theGame) {
		this.theGame = theGame;
		
		this.pnContent = new GridPane();
		
		this.addFirstPlayerChooserPane(theGame);		
		this.addComputerPlayerPane(theGame);
		this.pnComputerPlayer.setDisable(true);
		this.addHumanPlayerPane(theGame);
		this.pnHumanPlayer.setDisable(true);
		this.addStatusPane(theGame);
		
		this.setCenter(this.pnContent);
	}

	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");	
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.add(topBox, 0, 0);
	}
	
	private void addComputerPlayerPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(theGame);
		topBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.add(topBox, 0, 1);
	}
	
	private void addHumanPlayerPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");
		this.pnHumanPlayer = new HumanPane(theGame);
		topBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.add(topBox, 0, 2);
	}
	
	private void addStatusPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(theGame);
		topBox.getChildren().add(this.pnGameInfo);
		this.pnContent.add(topBox, 0, 3);
	}
	
	/*
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;
			
			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
		}
		
		private void buildPane() {
			this.setHgap(20);
			
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");	
			this.radHumanPlayer.setOnAction(new HumanFirstListener());

			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());
			
			ToggleGroup firstPlayer = new ToggleGroup();
			this.radHumanPlayer.setToggleGroup(firstPlayer);
			this.radComputerPlayer.setToggleGroup(firstPlayer);
			
			this.add(this.radHumanPlayer, 1, 0);
			this.add(this.radComputerPlayer, 2, 0);

		}
		
		/* 
		 * Defines the listener for computer player first button.
		 */		
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/** 
			 * Enables the ComputerPlayerPanel and starts a new game. 
			 * Event handler for a click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				MancalaPane.this.pnComputerPlayer.setDisable(false);
				MancalaPane.this.pnChooseFirstPlayer.setDisable(true);
				MancalaPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		
		/* 
		 * Defines the listener for human player first button.
		 */	
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/* 
			 * Sets up user interface and starts a new game. 
			 * Event handler for a click in the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				MancalaPane.this.pnChooseFirstPlayer.setDisable(true);
				MancalaPane.this.pnHumanPlayer.setDisable(false);
				MancalaPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
			}
		}
	}
}
