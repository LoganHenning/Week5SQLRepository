package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Chess;

public class ChessDao {
	
	
	private Connection connection;
	private final String GET_ALL_PIECES_QUERY = "SELECT * FROM chess_pieces";
	private final String GET_PIECE_BY_ID_QUERY = "SELECT * FROM chess_pieces WHERE id = ?";
	private final String CREATE_NEW_PIECE_QUERY = "INSERT INTO chess_pieces (name, quantity, price) VALUES (?,?,?)";
	private final String DELETE_PIECE_QUERY = "DELETE FROM chess_pieces WHERE id = ?";
	
	public ChessDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Chess> getAllPieces() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_ALL_PIECES_QUERY).executeQuery();
		List<Chess> pieces = new ArrayList<Chess>();
		
		while(rs.next()) {
			pieces.add(generatePiece(rs));
		}
		
		return pieces;
	}
	
	public Chess getPieceById (int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PIECE_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			return generatePiece(rs);
		}
		
		return new Chess(0, "", "", 0.0);
		}
	
	public void createNewPiece(String name, String quantity, double price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PIECE_QUERY);
		ps.setString(1, name);
		ps.setString(2, quantity);
		ps.setDouble(3, price);
		ps.executeUpdate();
		
	
	}
	
	public void deletePiece(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PIECE_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Chess generatePiece(ResultSet rs) throws SQLException{
		
		return new Chess(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getDouble(4)
				);
	}

}
