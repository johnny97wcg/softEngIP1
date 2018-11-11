package boundary;

import entity.Puzzle;
import junit.framework.TestCase;

public class TestPuzzleView extends TestCase {
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
	
	public void testMapping() {
		// wait 1 second for GUI to appear...
		try { Thread.sleep(1000); } catch (Exception e) { }
		PuzzleView view = app.getPuzzleView();
		
		// invalid
		assertTrue(view.getRow(0) < 0);  
		assertTrue(view.getRow(999) < 0); 
		assertTrue(view.getColumn(0) < 0); 
		assertTrue(view.getColumn(999) < 0); 
		
		// valid
		assertEquals(0, view.getRow(50));
		assertEquals(1, view.getRow(150));
		assertEquals(2, view.getRow(250));
		assertEquals(3, view.getRow(350));
		assertEquals(4, view.getRow(450));
		assertEquals(0, view.getColumn(50));
		assertEquals(1, view.getColumn(150));
		assertEquals(2, view.getColumn(250));
		assertEquals(3, view.getColumn(350));

		
	}
}
