package edu.westga.cs6910.mancala.model.strategies;

/**
 * This class implements a pit selection strategy for the
 * ComputerPlayer where the AI randomly selects a non-empty
 * pit.
 * 
 * @author En Yang Pang
 * @version 06/25/2019
 */
public class RandomStrategy implements SelectStrategy {

	@Override
	public int selectPit(int[] gameBoard) {
		int pitChoice = 4;
		do {
			pitChoice = (int) (Math.random() * 3) + 4;
		} while (gameBoard[pitChoice] == 0);
		return pitChoice;
	}

}
