package controller;

import javax.swing.JOptionPane;

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
				if(puzzle.win()) {
					int c = JOptionPane.showConfirmDialog (app, "congrads, you've won the game! Exit now?");

					if (c == JOptionPane.OK_OPTION) {
						app.setVisible(false);
						app.dispose();
				}
				}
				if(puzzle.tryMove(0,-1)) {
					app.setMove(app.getMove()+1);
					app.label.setText(String.valueOf(app.getMove()));
					view.repaint();
				}
				break;
			case 'd':
				if(puzzle.tryMove(0,1)) {
					app.setMove(app.getMove()+1);
					app.label.setText(String.valueOf(app.getMove()));
					view.repaint();
				}
				break;
			case 'l':
				if(puzzle.tryMove(-1,0)) {
					app.setMove(app.getMove()+1);
					app.label.setText(String.valueOf(app.getMove()));
					view.repaint();
				}
				break;
			case 'r':
				if(puzzle.tryMove(1,0)) {
					app.setMove(app.getMove()+1);
					app.label.setText(String.valueOf(app.getMove()));
					view.repaint();
				}
				break;
			}
		}
	}
}