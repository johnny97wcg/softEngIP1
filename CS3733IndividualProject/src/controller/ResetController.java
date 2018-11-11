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
		puzzle.resetPieces();
		app.setMove(0);
		app.label.setText(String.valueOf(app.getMove()));
		PuzzleView view = app.getPuzzleView();
		view.repaint();
	}
}
