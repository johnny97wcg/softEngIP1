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
		for(Piece p: pieces) { 
			if (p.isSelected()) {
				g.setColor(Color.yellow);
			}
			else if (p.isKeyPiece()) {
				g.setColor(Color.red);
			}
			else 
				g.setColor(Color.green);
			g.fillRect(offset+p.getColumn()*100, offset+p.getRow()*100, p.getWidth()*100-2*offset, p.getHeight()*100-2*offset);

		}
		g.setColor(Color.white);
		g.fillRect(105, 497, 190, 3);
	}
	
	public int getRow(int y) {
		int boxHeight = 500/5;
		if (y >= offset && y <= boxHeight - offset) { return 0; }
		if (y >= boxHeight + offset && y <= 2*boxHeight - offset) { return 1; }
		if (y >= 2*boxHeight + offset && y <= 3*boxHeight - offset) { return 2; }
		if (y >= 3*boxHeight + offset && y <= 4*boxHeight - offset) { return 3; }
		if (y >= 4*boxHeight + offset && y <= 5*boxHeight - offset) { return 4; }
		return -1;
	}

	public int getColumn(int x) {
		int boxWidth = 400/4;
		if (x >= offset && x <= boxWidth - offset) { return 0; }
		if (x >= boxWidth + offset && x <= 2*boxWidth - offset) { return 1; }
		if (x >= 2*boxWidth + offset && x <= 3*boxWidth - offset) { return 2; }
		if (x >= 3*boxWidth + offset && x <= 4*boxWidth - offset) { return 3; }
		return -1;
	}
	
}
