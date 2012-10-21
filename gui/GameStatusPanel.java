package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.CellWrapped;
import logic.GameStatus;
import logic.MoveListener;
import logic.PlayerColor;
import logic.ReadOnlyBoard;

public class GameStatusPanel extends JPanel{
	private JLabel currentStatus; // main label for game status
	private JButton newGameButton; // new game button
	private JButton gameRestartButton; // game restart button (when game is in progress)
	private String statusValue; // status label value
	private JPanel buttons;
	private MainFrame f;
	
	public GameStatusPanel(MainFrame f){
		this.f = f;
		initLabel();
		initPanel();
		initButtons();
	}
	
	private void initPanel(){
		this.setLayout(new FlowLayout());
		buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		this.add(currentStatus);
		this.add(buttons);
	}
	
	private void initLabel(){
		currentStatus = new JLabel();
		setCurrentLabel("Set up new Game");
	}
	
	private void initButtons(){
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e){
		              f.setupInitMode();
		        }
	        }
		);
		gameRestartButton = new JButton("Restart");
		gameRestartButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Restart");
			}
			
		});
		buttons.add(newGameButton);
		buttons.add(gameRestartButton);
	}
	
	public void setCurrentLabel(String l){
		statusValue = l;
		currentStatus.setText(l);
	}
	
	private void updateStatus(String st){
		currentStatus.setText(st);
	}
	
	public void show(GameStatus gameStatus){
		showGameResult(gameStatus);
	}
	
	private void showGameResult (GameStatus gameStatus) {
		switch (gameStatus) {
		case XISWINNER:
			updateStatus("X is the winner!");
			break;

		case OISWINNER:
			updateStatus("O is the winner!");
			break;

		case DRAW:
			updateStatus("It is a draw!");
			break;
		}
	}
	
public void makeMove(ReadOnlyBoard board, PlayerColor playerColor, MoveListener moveListener, int x, int y) {
		printWhoIsOnTurn(playerColor);
		CellWrapped nextMove = nextMoveUntilLegal(board, x, y);
		moveListener.makeMove(nextMove);
}

	private void printWhoIsOnTurn(PlayerColor playerColor) {
		switch (playerColor) {
		case X:
			updateStatus("Player X is on turn");
			break;
		case O:
			updateStatus("Player O is on turn");
			break;
		}
	}

	private CellWrapped nextMoveUntilLegal(ReadOnlyBoard board, int x , int y) {
		while (true) {
			try {
				CellWrapped moveCandidate = new CellWrapped(x, y);
				Boolean isEmpty = board.isEmpty(moveCandidate);
				if (isEmpty) {
					return moveCandidate;
				} else {
					updateStatus("Cell is not empty");
				}
			} catch (IllegalArgumentException e) {
				updateStatus(e.getMessage());
			}
		}
	}

}
