package controller;

import boundary.PuzzleView;
import boundary.SlidingPuzzleApp;
import entity.Puzzle;

public class ResetController {
	SlidingPuzzleApp app;
	Puzzle puzzle;
	
	public ResetController(SlidingPuzzleApp app, Puzzle p) {
		this.app = app;
		this.puzzle = p;
	}
	
	public void reset() {
		puzzle = new Puzzle();
		app = new SlidingPuzzleApp(puzzle);
		PuzzleView view = app.getPuzzleView();
		view.repaint();
	}
}
