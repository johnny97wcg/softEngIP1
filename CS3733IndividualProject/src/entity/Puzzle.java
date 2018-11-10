package entity;

import java.util.ArrayList;

public class Puzzle {

	ArrayList<Piece> pieces;
	
	public Puzzle() {
		pieces = new ArrayList<Piece>();
		pieces.add(new Piece(1,2,0,0));
		pieces.add(new Piece(1,1,1,0));
		pieces.add(new Piece(1,1,2,0));
		pieces.add(new Piece(1,1,3,0));
		pieces.add(new Piece(1,2,1,1));
		pieces.add(new Piece(2,2,2,1));
		pieces.add(new Piece(1,2,0,2));
		pieces.add(new Piece(2,1,1,3));
		pieces.add(new Piece(1,1,3,3));
		pieces.add(new Piece(2,1,2,4));
	}
	
	boolean hasSelected() {
		return true;
	}
	
	void selectPiece(int row, int col) {
		
	}
	
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
}
