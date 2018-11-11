import java.awt.EventQueue;

import boundary.SlidingPuzzleApp;
import entity.Puzzle;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlidingPuzzleApp frame = new SlidingPuzzleApp(new Puzzle());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

