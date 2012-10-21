package crosscutting;

import java.util.Scanner;

import logic.*;
import model.*;
import ui.*;
import gui.*;
import ui.ConsolePresenter;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MainFrame m = new MainFrame();
		Presenter presenter = new ConsolePresenter(System.out);
		Board board = new Board();
		Player xPlayer = new ConsolePlayer(scanner, System.out);
		Player oPlayer = new ConsolePlayer(scanner, System.out);
		Referee referee = new PrimeReferee();
		
		Game game = new Game(board, xPlayer, oPlayer, referee, presenter);
		game.play();
		
		scanner.close();
	}
}
