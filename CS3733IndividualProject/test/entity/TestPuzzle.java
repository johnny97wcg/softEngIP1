package entity;

import junit.framework.TestCase;

public class TestPuzzle extends TestCase {

	public void testSelectPiece() {
		Puzzle puzzle = new Puzzle();
		puzzle.selectPiece(0, 0);
		Piece firstPiece = puzzle.getPieces().get(0);
		assertTrue(firstPiece.isSelected());
		assertTrue(puzzle.hasSelectedPiece());
		puzzle.unselectAll();
		assertFalse(firstPiece.isSelected());
		assertFalse(puzzle.hasSelectedPiece());
	}
	
	public void testMove() {
		Puzzle puzzle = new Puzzle();
		puzzle.selectPiece(4,3);
		assertFalse(puzzle.isEmpty(4, 3));
		assertFalse(puzzle.tryMove(1,0));
		assertTrue(puzzle.tryMove(-1,0));
		assertFalse(puzzle.isEmpty(4, 1));
		assertTrue(puzzle.isEmpty(4, 3));
		assertTrue(puzzle.tryMove(1,0));
		puzzle.selectPiece(3,0);
		assertFalse(puzzle.isEmpty(3, 0));
		assertTrue(puzzle.tryMove(0, 1));
		assertTrue(puzzle.tryMove(0,-1));
		puzzle.resetPieces();
		puzzle.selectPiece(2, 3);
		assertFalse(puzzle.isEmpty(2, 3));
		Piece p = puzzle.pieces.get(puzzle.selectedPiece);
		p.setRow(3);
		p.setColumn(1);
		assertTrue(puzzle.win());
	}
	
}
