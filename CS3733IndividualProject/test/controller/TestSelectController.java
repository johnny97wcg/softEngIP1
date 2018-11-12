package controller;

import boundary.SlidingPuzzleApp;
import entity.Puzzle;
import junit.framework.TestCase;

public class TestSelectController extends TestCase{
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
	
	public void testSelectController() {
		SelectController sc = new SelectController(app, puzzle);
		sc.select(150, 50);
		assertTrue(puzzle.hasSelectedPiece());
		assertTrue(puzzle.getPieces().get(1).isSelected());
	}
}
