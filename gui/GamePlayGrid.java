package gui;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class GamePlayGrid extends Canvas{
	
	private final int HEIGHT = 600; // final height of canvas
	private final int WIDTH = 800; // final with of canvas
	private int colCount; // number of columns of grid
	private int rowCount; // number of rows of grid
	private boolean[][] used; // used positions of grid
	
	private boolean xTurn; // true if it's the x-s turn
	
	public GamePlayGrid(int col, int row, boolean xTurn){
		addMouseListener();
		setSize(WIDTH, HEIGHT);
		colCount = col;
		rowCount = row;
		used = new boolean[row][col];
		enFalse();
		this.xTurn = xTurn;
	}
	
	private void enFalse(){
		for (int i = 0; i < used.length; i ++){
			for (int j = 0; j < used[0].length; j ++){
				used[i][j] = false;
			}
		}
	}
	
	private void addMouseListener(){
		this.addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent e) { 
				System.out.println(e.getX() + " " + e.getY());
				int w = WIDTH/colCount;
				int h = HEIGHT/rowCount;
				int x = e.getX();
				int y = e.getY();
				Graphics mygrid = e.getComponent().getGraphics();
	      	    if (!used[y/h][x/w]){
	      	    	if (xTurn){
		      	    	int[] coordinates = getProperCoordinates(x, y, w, h);
		      	    	paintX(mygrid, coordinates);
		      	    	xTurn = false;
	      	    	}
	      	    	else{
	      	    		int[] coordinates = getProperCoordinates(x, y, w, h);
	      	    		paintCircle(mygrid, coordinates, w);
	      	    		xTurn = true;
	      	    	}
	      	    }
	      		//repaint();
	         } 
	    }); 
	}
	
	private int[] getProperCoordinates(int x, int y, int w, int h){
		int[] ret = new int[4];
		ret[0] = x - x%w;
		ret[2] = ret[0] + w;
		ret[1] = y - y%h;
		ret[3] = ret[1] + h;
		used[y/h][x/w] = true;
		return ret;
	}
	
	private void paintCircle(Graphics g, int[]c, int r){
		int h = (r*2)/3;
		int w = (r*2)/3;
		g.drawOval( (c[0]) + w/4, (c[1]) + h/12, w, h );
	}
	
	private void paintX(Graphics g, int[] c){
		 g.drawLine(c[0], c[1], c[2], c[3]);
         g.drawLine(c[0], c[3], c[2], c[1]);  
	}
	
	// draws grid initially
	@Override 
	public void paint(Graphics mygrid) { 
	    int heightOfRow = HEIGHT / (rowCount); 
	    for (int i = 0; i < rowCount; i++){
	    	mygrid.drawLine(0, i * heightOfRow , WIDTH, i * heightOfRow );
	    }
	    int widthdOfRow = WIDTH / (colCount); 
	    for (int i = 0; i < colCount; i++) {
	    	mygrid.drawLine(i*widthdOfRow , 0, i*widthdOfRow , HEIGHT);
	    }
	}

}
