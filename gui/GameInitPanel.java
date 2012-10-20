package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameInitPanel extends JPanel{
	
	private JLabel welcomeLabel;
	private JLabel playerTypesLabel; // Player VS Player or Player VS Computer
	private JLabel boardSizeLabel; // set board size
	private JLabel ticOrToe; // first player wants to be 'X' or 'O';
	
	private 
	
	public GameInitPanel(){
		this.setLayout(new BorderLayout());
		
		initLabels();
		setLabels();
		
		initSelects();
		setSelects();
	}
	
	

}
