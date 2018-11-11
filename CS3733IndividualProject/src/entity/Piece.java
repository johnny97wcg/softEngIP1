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
		this.selected = false;
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
	public void setRow(int r) {
		this.row = r;
	}
	public void setColumn(int c) {
		this.column = c;
	}
	
	
	public boolean isSelected() {
		return this.selected;
	}

}
