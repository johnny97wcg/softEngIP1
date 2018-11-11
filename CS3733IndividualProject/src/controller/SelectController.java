package controller;

import boundary.PuzzleView;
import boundary.SlidingPuzzleApp;
import entity.Puzzle;

public class SelectController {
	SlidingPuzzleApp app;
	Puzzle puzzle;
	
	public SelectController(SlidingPuzzleApp app, Puzzle p) {
		this.app = app;
		this.puzzle = p;
	}
	
	public void select(int x, int y) {
		PuzzleView view = app.getPuzzleView();
		int r = view.getRow(y);
		int c = view.getColumn(x);
		
		puzzle.unselectAll();// clear selection
		if (r < 0 || c < 0) {}// nothing selected
		else {
			puzzle.selectPiece(r,c);
		}
		view.repaint();
	}
		
}
