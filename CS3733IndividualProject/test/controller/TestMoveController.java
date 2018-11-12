package controller;

import boundary.SlidingPuzzleApp;
import entity.Piece;
import entity.Puzzle;
import junit.framework.TestCase;

public class TestMoveController extends TestCase{
	SlidingPuzzleApp app;
	Puzzle puzzle;
	
	protected void setUp() {
		puzzle = new Puzzle();
		app = new SlidingPuzzleApp(puzzle);
		app.setVisible(true);
	}
	
	protected void tearDown() {
		app.setVisible(false);
	}
	
	public void testMoveController() {
		MoveController mc = new MoveController(app, puzzle);
		puzzle.selectPiece(2, 0);
		mc.move('d');
		assertTrue(puzzle.isEmpty(2,0));
		mc.move('u');
		assertFalse(puzzle.isEmpty(2, 0));
		puzzle.selectPiece(4, 3);
		mc.move('l');
		assertTrue(puzzle.isEmpty(4, 3));
		mc.move('r');
		assertFalse(puzzle.isEmpty(4, 3));

	}
}
