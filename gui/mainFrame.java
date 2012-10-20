package gui;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import crosscutting.*;

/**
 * This is main Frame class on which initial game Panels are added
 * First game initialization panel is added, then the gameplay panel
 * */
public class mainFrame extends JFrame{

	private static final int WIDTH = 800; // width of the main window
	private static final int HEIGHT = 600; // height of the main window
	private static final String TITLE = "Tic Tac Toe"; // title of the application
	
	private static mainFrame m; // main frame containing all panels
	private static Main mainGame; // main game process
	
	private static JPanel mainPanel; // main panel on which all components are drawn
	private static GameInitPanel gInitPanel; // jPanel for game initialization
	private static GameplayPanel gPlayPanel;  // jPanel for GamePlay 
	private static GameStatusPanel gStatPanel; // jPanel for game stats
	
	private static boolean playMode; // is false if game is in init mode, ture - if the game is in Play mode
	
	public static void main(String[] args) {
		m = new mainFrame();
		m.setVisible(true);
		m.setSize(WIDTH,HEIGHT);
		m.setTitle("BorderTest");
		m.setLayout(new BorderLayout());
		
		setupMainPanel();
		setupPanels();
		setupInitMode();
	}
	
	private static void setupMainPanel(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		m.add(mainPanel, BorderLayout.CENTER);
	}
	
	private static void setupInitMode(){
		playMode = false;
		cleanMainPane();
		mainPanel.add(gInitPanel, BorderLayout.CENTER);
		mainPanel.add(gStatPanel, BorderLayout.SOUTH);
		mainGame = new Main();
	}
	
	private static void setupGameplayPanel(){
		playMode = true;
		cleanMainPane();
		mainPanel.add(gPlayPanel, BorderLayout.CENTER);
		mainPanel.add(gStatPanel, BorderLayout.SOUTH);
		String[] args = null; //TODO: set args values;
		mainGame.main(args);
	}
	
	private static void setupPanels(){
		gInitPanel = new GameInitPanel();
		gPlayPanel = new GameplayPanel();
		gStatPanel = new GameStatusPanel();
	}
	
	private static void cleanMainPane(){
		mainPanel.removeAll();
	}

}
