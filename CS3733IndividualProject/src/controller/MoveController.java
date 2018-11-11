package controller;

import boundary.PuzzleView;
import boundary.SlidingPuzzleApp;
import entity.Puzzle;

public class MoveController {
	SlidingPuzzleApp app;
	Puzzle puzzle;
	
	public MoveController(SlidingPuzzleApp app, Puzzle p) {
		this.app = app;
		this.puzzle = p;
	}

	public void move(char dir) {
		PuzzleView view = app.getPuzzleView();
		
		if (puzzle.hasSelectedPiece()) { 
			switch (dir) {
			case 'u': 
				if(puzzle.tryMove(0,-1)) {
					view.repaint();
				}
				break;
			case 'd':
				if(puzzle.tryMove(0,1)) {
					view.repaint();
				}
				break;
			case 'l':
				if(puzzle.tryMove(-1,0)) {
					view.repaint();
				}
				break;
			case 'r':
				if(puzzle.tryMove(1,0)) {
					view.repaint();
				}
				break;
			}
		}
	}
}