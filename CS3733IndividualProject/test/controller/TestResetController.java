package controller;

import boundary.SlidingPuzzleApp;
import entity.Puzzle;
import junit.framework.TestCase;

public class TestResetController extends TestCase{
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
	
	public void testResetController() {
		ResetController rc = new ResetController(app,puzzle);
		puzzle.selectPiece(3, 0);
		puzzle.tryMove(0, 1);
		assertFalse(puzzle.isEmpty(4, 0));
		rc.reset();
		assertTrue(puzzle.isEmpty(4, 0));
	}
	
}
