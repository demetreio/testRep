package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is main Frame class on which initial game Panels are added
 * First game initialization panel is added, then the gameplay panel
 * */
public class MainFrame extends JFrame{

	private final int WIDTH = 900; // width of the main window
	private final int HEIGHT = 700; // height of the main window
	private final String TITLE = "Tic Tac Toe"; // title of the application
	private JPanel mainPanel; // main panel on which all components are drawn
	private GameInitPanel gInitPanel; // jPanel for game initialization
	private GameplayPanel gPlayPanel;  // jPanel for GamePlay 
	private GameStatusPanel gStatPanel; // jPanel for game stats
	private boolean playMode; // is false if game is in init mode, ture - if the game is in Play mode
	
	public MainFrame(){
		playMode = false;
		initFrame();
		setupMainPanel();
		setupPanels();
		setupInitMode();
	}
	
	private void initFrame(){
		setVisible(true);
		setSize(WIDTH,HEIGHT);
		setTitle(TITLE);
		setLayout(new BorderLayout());
		setResizable(false);
	}
	
	private void setupMainPanel(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
	}
	
	public void setupInitMode(){
		setupPanels();
		setInitMode();
		cleanMainPanel();
		mainPanel.add(gInitPanel, BorderLayout.CENTER);
		mainPanel.add(gStatPanel, BorderLayout.SOUTH);
	}
	
	public void setupGameplayPanel(int columns, int rows, String chosenTic, String player){
		setupPanels();
		setPlayMode();
		cleanMainPanel();
		gPlayPanel = new GameplayPanel(columns, rows, chosenTic, player);
		gStatPanel = new GameStatusPanel(this, columns, rows, chosenTic, player);
		mainPanel.add(gPlayPanel, BorderLayout.CENTER);
		mainPanel.add(gStatPanel, BorderLayout.SOUTH);
	}
	
	private void setupPanels(){
		gInitPanel = new GameInitPanel(this);
		gStatPanel = new GameStatusPanel(this);
	}
	
	public void cleanMainPanel(){
		mainPanel.removeAll();
	}
	
	private void setPlayMode(){
		playMode = true;
	}
	
	private void setInitMode(){
		playMode = false;
	}

}
