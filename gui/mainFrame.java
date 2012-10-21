package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is main Frame class on which initial game Panels are added
 * First game initialization panel is added, then the gameplay panel
 * */
public class MainFrame extends JFrame{

	private final int WIDTH = 800; // width of the main window
	private final int HEIGHT = 600; // height of the main window
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
	}
	
	private void setupMainPanel(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
	}
	
	private void setupInitMode(){
		setInitMode();
		cleanMainPane();
		mainPanel.add(gInitPanel, BorderLayout.CENTER);
		mainPanel.add(gStatPanel, BorderLayout.SOUTH);
	}
	
	private void setupGameplayPanel(){
		setPlayMode();
		cleanMainPane();
		mainPanel.add(gPlayPanel, BorderLayout.CENTER);
		mainPanel.add(gStatPanel, BorderLayout.SOUTH);
	}
	
	private void setupPanels(){
		gInitPanel = new GameInitPanel();
		gPlayPanel = new GameplayPanel();
		gStatPanel = new GameStatusPanel();
	}
	
	private void cleanMainPane(){
		mainPanel.removeAll();
	}
	
	private void setPlayMode(){
		playMode = true;
	}
	
	private void setInitMode(){
		playMode = false;
	}

}
