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
	
	public void selectPiece(int row, int col) {
		for (Piece p: pieces) {
			if (p.getRow()==row && p.getColumn()==col) {
				p.selected = true;
				break;
			}
			else if(p.getRow()==row-1 && p.getColumn()==col && p.getHeight()==2) {
				p.selected = true;
				break;
			}
			else if(p.getRow()==row && p.getColumn()==col-1 && p.getWidth()==2) {
				p.selected = true;
				break;
			}
			else if(p.getRow()==row-1 && p.getColumn()==col-1 && p.isKeyPiece()) {
				p.selected = true;
				break;
			}
		}
	}
	
	public void unselectAll() {
		for (Piece p: pieces) {
			p.selected = false;
		}
	}
	
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
}
