package controller;

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
		this.puzzle = new Puzzle();
		this.app = new SlidingPuzzleApp();
		
	}
}
