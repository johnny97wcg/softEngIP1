package entity;

import java.util.ArrayList;

public class Puzzle {

	ArrayList<Piece> pieces;
	int selectedPiece; //index of selected piece in the arraylist
	
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
		selectedPiece = -1;
	}
	
	public void selectPiece(int row, int col) {
		for (int i=0; i< pieces.size();i++) {
			Piece p = pieces.get(i);
			if (p.getRow()==row && p.getColumn()==col) {
				p.selected = true;
				selectedPiece = i;
				break;
			}
			else if(p.getRow()==row-1 && p.getColumn()==col && p.getHeight()==2) {
				p.selected = true;
				selectedPiece = i;
				break;
			}
			else if(p.getRow()==row && p.getColumn()==col-1 && p.getWidth()==2) {
				p.selected = true;
				selectedPiece = i;
				break;
			}
			else if(p.getRow()==row-1 && p.getColumn()==col-1 && p.isKeyPiece()) {
				p.selected = true;
				selectedPiece = i;
				break;
			}
		}
	}
	
	public void unselectAll() {
		for (Piece p: pieces) {
			p.selected = false;
		}	
		selectedPiece = -1;
	}
	
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
	public boolean hasSelectedPiece() {
		if (selectedPiece == -1) {
			return false;
		}
		else return true;
	}
	
	public boolean tryMove(int dx, int dy) {
		Piece p = pieces.get(selectedPiece);
		int r = p.getRow();
		int c = p.getColumn();
		int w = p.getWidth();
		int h = p.getHeight();
//		System.out.println("r:"+r+" c:"+c+" w:"+w+" h:"+h);
		if (r+dy < 0 || c+dx < 0 || r+dy+h-1>4 || c+dx+w-1>3) {
			System.out.println("off the board");
			return false;
			}//off the board
		if (dx == -1) {// move left
			if (isEmpty(r,c+dx) && isEmpty(r+h-1, c+dx)) {
				p.setColumn(c+dx); //update piece location
				pieces.set(selectedPiece, p); //update puzzle with new piece
				return true; 
			}
			else return false;
		}
		if (dx == 1) {// move  right
			if (isEmpty(r,c+dx+w-1) && isEmpty(r+h-1, c+dx+w-1)) {
				p.setColumn(c+dx); //update piece location
				pieces.set(selectedPiece, p); //update puzzle with new piece
				return true; 
			}
			else return false;
		}
		if (dy == -1){ // move up 
			if (isEmpty(r+dy,c) && isEmpty(r+dy, c+w-1)) {
				p.setRow(r+dy); //update piece location
				pieces.set(selectedPiece, p); //update puzzle with new piece
				return true; 
			}
			else return false;
		}
		else { // move down
			if (isEmpty(r+dy+h-1,c) && isEmpty(r+dy+h-1, c+w-1)) {
				p.setRow(r+dy); //update piece location
				pieces.set(selectedPiece, p); //update puzzle with new piece
				return true; 
			}
			else return false;
		}
		
	}
	
	boolean isEmpty(int row, int col) {
		for (Piece p: pieces) {
			if (p.getRow()==row && p.getColumn()==col) {
				return false;
			}
			else if(p.getRow()==row-1 && p.getColumn()==col && p.getHeight()==2) {
				return false;
			}
			else if(p.getRow()==row && p.getColumn()==col-1 && p.getWidth()==2) {
				return false;
			}
			else if(p.getRow()==row-1 && p.getColumn()==col-1 && p.isKeyPiece()) {
				return false;
			}
		}
		return true;
	}
	
	public void resetPieces() {
		pieces.clear();
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
		selectedPiece = -1;
	}
	
	public boolean win() {
		Piece p = pieces.get(selectedPiece);
		int r = p.getRow();
		int c = p.getColumn();
		return (r==3 && c==1 && p.isKeyPiece());
	}

}
