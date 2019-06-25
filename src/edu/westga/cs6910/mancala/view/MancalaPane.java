package edu.westga.cs6910.mancala.view;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.Player;
import edu.westga.cs6910.mancala.model.strategies.NearStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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
	private VBox contentBox;
	private MenuBar theMenuBar;
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
		this.contentBox = new VBox();
		this.theMenuBar = new MenuBar();
		
		this.addFirstPlayerChooserPane(theGame);		
		this.addComputerPlayerPane(theGame);
		this.pnComputerPlayer.setDisable(true);
		this.addHumanPlayerPane(theGame);
		this.pnHumanPlayer.setDisable(true);
		this.addStatusPane(theGame);
		
		this.addMenuBar();
		this.contentBox.getChildren().add(this.pnContent);
		
		this.setCenter(this.contentBox);
	}

	private void addMenuBar() {
		this.addFileMenu();
		this.addSettingsMenu();
		this.contentBox.getChildren().add(this.theMenuBar);
	}
	
	private void addFileMenu() {
		Menu fileMenu = new Menu("_File");
		fileMenu.setMnemonicParsing(true);
		MenuItem exit = new MenuItem("E_xit");
		exit.setMnemonicParsing(true);
		exit.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		fileMenu.getItems().add(exit);
		this.theMenuBar.getMenus().add(fileMenu);
	}
	
	private void addSettingsMenu() {
		Menu settingsMenu = new Menu("_Settings");
		settingsMenu.setMnemonicParsing(true);
		Menu computerPlayerMenu = new Menu("Computer _Player");
		computerPlayerMenu.setMnemonicParsing(true);
		MenuItem near = new MenuItem("_Near");
		near.setMnemonicParsing(true);
		near.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				MancalaPane.this.theGame.getComputerPlayer().setStrategy(new NearStrategy());
			}
		});
		MenuItem far = new MenuItem("F_ar");
		far.setMnemonicParsing(true);
		MenuItem random = new MenuItem("_Random");
		random.setMnemonicParsing(true);
		computerPlayerMenu.getItems().addAll(near, far, random);
		settingsMenu.getItems().add(computerPlayerMenu);
		this.theMenuBar.getMenus().add(settingsMenu);
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
