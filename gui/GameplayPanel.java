package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameplayPanel extends JPanel{
	
	private GamePlayGrid grid;
	private int cols;
	private int rows;
	private String player;
	private String choosenTic;
	
	public GameplayPanel(int cols, int rows, String choosenTic, String player){
		
		System.out.println(choosenTic + ", " + player);
		this.choosenTic = choosenTic;
		this.player = player;
		this.cols = cols;
		this.rows = rows;
		//setLayout(new BorderLayout());
		initGrid();
	}
	
	private void initGrid(){
		grid = new GamePlayGrid(cols, rows, (choosenTic.equals("Tic") ? false : true));
		add(grid);
		//add(new JLabel("test"), BorderLayout.WEST);
	}
	
	/*
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(800, 600);
		f.setVisible(true);
		f.add(new GameplayPanel(5,5));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	 */
}
