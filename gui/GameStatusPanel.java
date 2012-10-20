package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStatusPanel extends JPanel{
	private JLabel currentStatus; // main label for game status
	private JButton newGameButton; // new game button
	private JButton gameRestartButton; // game restart button (when game is in progress)
	private String statusValue; // status label value
	
	public GameStatusPanel(){
		initPanel();
		initLabel();
		initNewGameButton();
		initGameRestartButton();
	}
	
	private void initPanel(){
		setLayout(new FlowLayout());
	}
	
	private void initLabel(){
		currentStatus = new JLabel();
		setCurrentLabel("Set up new Game");
	}
	
	private void initNewGameButton(){
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
		                //Execute when button is pressed
		                System.out.println("You clicked the button");
		        }
	        }
		);
		
	}
	
	private void initGameRestartButton(){
		
	}
	
	public void setCurrentLabel(String l){
		statusValue = l;
		currentStatus.setText(l);
	}

}
