
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.codeurjc.ais.tictactoe.Board;

class BoardTest {

	Board tablero;

	@BeforeEach
	public void setUp() {
		tablero = new Board();
		tablero.enableAll();
	}
	
	@Test
	public void empate() {
		tablero.getCell(0).value = "X";
		tablero.getCell(1).value = "O";
		tablero.getCell(2).value = "X";
		tablero.getCell(3).value = "O";
		tablero.getCell(4).value = "X";
		tablero.getCell(5).value = "X";
		tablero.getCell(6).value = "O";
		tablero.getCell(7).value = "X";
		tablero.getCell(8).value = "O";
		

		int[] o = tablero.getCellsIfWinner("O");
		int[] x = tablero.getCellsIfWinner("X");

		assertEquals(null, x);
		assertEquals(null, o);
		
	}
	
	@Test
	public void victoriaX() {
		tablero.getCell(0).value = "X";
		tablero.getCell(2).value = "O";
		tablero.getCell(3).value = "X";
		tablero.getCell(5).value = "O";
		tablero.getCell(6).value = "X";
		int[] w = { 0, 3, 6 };
		int[] o = tablero.getCellsIfWinner("O");
		int[] x = tablero.getCellsIfWinner("X");
		assertEquals(o, null);
		for (int i = 0; i < 3; i++) {
			assertEquals(w[i], x[i]);
		}
	}
	@Test
	public void victoriaO() {
		tablero.getCell(0).value = "O";
		tablero.getCell(3).value = "X";
		tablero.getCell(1).value = "O";
		tablero.getCell(4).value = "X";
		tablero.getCell(2).value = "O";

		int[] w = { 0, 1, 2 };
		int[] o = tablero.getCellsIfWinner("O");
		int[] x = tablero.getCellsIfWinner("X");

		for (int i = 0; i < 3; i++) {
			assertEquals(w[i], o[i]);
		}
	}


	@Test
	public void draw() {
		boolean f = tablero.checkDraw();

		tablero.getCell(0).value = "X";
		tablero.getCell(1).value = "O";
		tablero.getCell(2).value = "X";
		tablero.getCell(3).value = "O";
		tablero.getCell(4).value = "X";
		tablero.getCell(5).value = "O";
		tablero.getCell(6).value = "O";
		tablero.getCell(7).value = "X";
		tablero.getCell(8).value = "O";

		boolean t = tablero.checkDraw();
		assertEquals(t, true);
	}

}
