package gui;

import javax.swing.JFrame;

/**
 * This is main Frame class on which initial game Panels are added
 * First game initialization panel is added, then the gameplay panel
 * */
public class mainFrame extends JFrame{

	private static final int WIDTH = 800; // width of the main window
	private static final int HEIGHT = 600; // height of the main window
	private static final String TITLE = "Tic Tac Toe"; // title of the application
	
	private GameInitPanel iPanel; // jPanel for game initialization
	private GameplayPanel gamePlayPanel; // jPanel for Gameplay 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mainFrame m = new mainFrame();
		m.setVisible(true);
		m.setSize(WIDTH,HEIGHT);
		m.setTitle("BorderTest");
	}
	
	private void setInitPanel(){
		
	}

}
