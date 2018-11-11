package entity;

import junit.framework.TestCase;

public class TestPiece extends TestCase{

	public void testKeyPiece() {
		Piece p = new Piece(2,2,0,0);
		assertTrue(p.isKeyPiece());
	}
}
