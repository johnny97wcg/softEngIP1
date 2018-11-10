package boundary;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Piece;
import entity.Puzzle;

/** 
 * Knows how to visually present the puzzle. 
 */
public class PuzzleView extends JPanel {

	Puzzle puzzle;
	ArrayList<Piece> pieces;
	int offset = 5;
	
	public PuzzleView(Puzzle puzzle) {
		this.puzzle = puzzle;
		this.pieces = puzzle.getPieces();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Piece piece: pieces) { 
			if (piece.isKeyPiece()) {
				g.setColor(Color.red);
			}
			else 
				g.setColor(Color.green);
			g.fillRect(offset+piece.getColumn()*100, offset+piece.getRow()*100, piece.getWidth()*100-2*offset, piece.getHeight()*100-2*offset);

		}
	}
	
}
