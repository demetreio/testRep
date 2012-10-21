package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameInitPanel extends JPanel{
	
	private MainFrame f;
	private JLabel welcomeLabel;
	private JLabel playerTypesLabel; // Player VS Player or Player VS Computer
	private JLabel boardSizeLabel; // set board size
	private JLabel ticOrToe; // first player wants to be 'X' or 'O';
	private JTextField boardSize;
	private JComboBox tic;
	private JComboBox playerVs;
	private JButton newGame;
	private JPanel boardP;
	private JPanel playerP;
	private JPanel ticP;
	private JPanel empty;
	private static final int TEXT_FIELD_SIZE = 20;
	private static final String [] players = {"Player", "Computer"};
	private static final String [] tics = {"Tic", "Toe"};
	private int columns = 0;
	private int rows = 0;
	private String chosenTic = "";
	private String player = "";
	
	
	public GameInitPanel(MainFrame f){
		this.f = f;
		setupPanel();
		initPanels();
		initLabels();
		initBoxes();
		setLabels();
		setPanels();
		listeners();
	}
	
	private class myActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == tic){
				JComboBox bs = (JComboBox)e.getSource();
				chosenTic = (String)bs.getSelectedItem();
			}else if(e.getSource() == playerVs){
				JComboBox bs = (JComboBox)e.getSource();
				player = (String)bs.getSelectedItem();
			}else if(e.getSource() == boardSize){
				JTextField jt = (JTextField)e.getSource();
				String size = jt.getText();
				StringTokenizer tk = new StringTokenizer(size);
				columns = Integer.parseInt(tk.nextToken());
				rows = Integer.parseInt(tk.nextToken());		
			}else if(e.getSource() == newGame){
				System.out.println("columns: " + columns + ", rows: " + rows);
				f.setupGameplayPanel(getColumns(), getRows(), chosenTic, player);
			}
		}
	}
	
	private void listeners(){
		myActionListener action = new myActionListener();
		tic.addActionListener(action);
		playerVs.addActionListener(action);
		boardSize.addActionListener(action);
		newGame.addActionListener(action);
	}
	
	private void setLabels() {
		// TODO Auto-generated method stub
		boardP.add(boardSizeLabel);
		boardP.add(boardSize);
		
		playerP.add(playerTypesLabel);
		playerP.add(playerVs);
		
		ticP.add(ticOrToe);
		ticP.add(tic);
	}
	
	private void setPanels(){
		empty = new JPanel();
		this.add(empty);
		this.add(welcomeLabel);
		for(int i=0; i< 3; i++){
			empty = new JPanel();
			this.add(empty);
		}
		this.add(boardP);
		this.add(playerP);
		this.add(ticP);
		this.add(newGame);
	}

	private void initLabels() {
		// TODO Auto-generated method stub
		welcomeLabel = new JLabel("Welcome to Tic-Tac-Toe");
		welcomeLabel.setFont(new Font("Sylfaen", 1, 30));
		playerTypesLabel = new JLabel ("Choose Player Vs : ");
		boardSizeLabel = new JLabel ("Choose the size of the Board input(Columns Rows): ");
		ticOrToe = new JLabel("First Player Choose X or O: ");
		
		boardSize = new JTextField(TEXT_FIELD_SIZE);
		boardSize.setSize(50, 50);
		
	}
	
	private void initPanels(){
		boardP = new JPanel();
		boardP.setLayout(new FlowLayout());
		
		ticP = new JPanel();
		ticP.setLayout(new FlowLayout());
		
		playerP = new JPanel();
		playerP.setLayout(new FlowLayout());
	}
	
	private void initBoxes(){
		tic = new JComboBox(tics);
		tic.setSelectedIndex(0);
		
		playerVs = new JComboBox(players);
		playerVs.setSelectedIndex(0);
		
		newGame = new JButton("New Game");
		
	}

	private void setupPanel(){
		this.setLayout(new BoxLayout(this,  BoxLayout.PAGE_AXIS));
	}
	
	public int getColumns() {
		return Integer.parseInt(boardSize.getText());
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return Integer.parseInt(boardSize.getText());
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getChosenTic() {
		return chosenTic;
	}

	public void setChosenTic(String chosenTic) {
		this.chosenTic = chosenTic;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
	

}
