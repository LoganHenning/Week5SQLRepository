package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ChessDao;
import entity.Chess;


public class Menu {
	
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display current chess pieces",
			"Display a specific chess piece",
			"Create a chess piece",
			"Delete a chess piece");
	
	private ChessDao chessDao = new ChessDao();
	
	public void start() {

		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
			
			if (selection.equals("1")) {
				displayPieces();
			}else if (selection.equals("2")) {
				displayPiece();
			}else if (selection.equals("3")) {
				createPiece();
			}else if (selection.equals("4")) {
				deletePiece();
			}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		}while (!selection.equals("-1"));
}
	
	private void printMenu() {
		System.out.println("Select an Option:\n---------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayPieces() throws SQLException {
		List<Chess> pieces = chessDao.getAllPieces();
		for (Chess piece : pieces) {
			System.out.println(piece.getId() + ": " + piece.getName());
			
		}
	}
	
	private void displayPiece() throws SQLException {
		System.out.print("Enter Piece id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Chess piece = chessDao.getPieceById(id);
		System.out.println(piece.getId() + ": " + piece.getName());
		
	}


	private void createPiece() throws SQLException {
		System.out.println("Enter new piece:");
		String name = scanner.nextLine();
		String quantity = scanner.nextLine();
		Double price = scanner.nextDouble();
		chessDao.createNewPiece(name, quantity, price);
	}
	

	
	public void deletePiece() throws SQLException {
		System.out.println("Enter team id to delete");
		int id = Integer.parseInt(scanner.nextLine());
		chessDao.deletePiece(id);
		
	}
	
}
