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
		System.out.println("x: " + String.valueOf(x));
		System.out.println("y: " + String.valueOf(y));
		System.out.println("r: " + String.valueOf(r));
		System.out.println("c: " + String.valueOf(c));
		
		puzzle.unselectAll();// clear selection
		if (r < 0 || c < 0) {}// nothing selected
		else {
			puzzle.selectPiece(r,c);
		}
		view.repaint();
	}
		
}
