package entity;



public class Piece {

	int width;
	int height;
	int row; //where top-left is to be found
	int column;
	boolean selected;
	
	public Piece(int width, int height, int column, int row){
		this.width = width;
		this.height = height;
		this.row = row;
		this.column = column;
	}
	
	public boolean isKeyPiece() {
		return width==2 && height==2;
		}
	
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public int getRow() {
		return this.row;
	}
	public int getColumn() {
		return this.column;
	}

}
