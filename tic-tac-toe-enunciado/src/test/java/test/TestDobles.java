package test;



import org.mockito.ArgumentCaptor;
import org.mockito.hamcrest.MockitoHamcrest;

import es.codeurjc.ais.tictactoe.Connection;
import es.codeurjc.ais.tictactoe.Player;
import es.codeurjc.ais.tictactoe.TicTacToeGame;
import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;


public class TestDobles {

	@Test
	public void winAndres() {
		TicTacToeGame game = new TicTacToeGame();
		Connection c1= mock(Connection.class);
		Connection c2= mock(Connection.class);
		
		
		game.addConnection(c1);
		game.addConnection(c2);
		
		Player Andres = new Player(1,"X","Andrés");
		Player Antonio = new Player(2,"O","Antonio");

		game.addPlayer(Andres);
		reset(c1);
		reset(c2);
		game.addPlayer(Antonio);
		
		verify(c1).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(Andres,Antonio)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(Andres,Antonio)));
		
		game.mark(0);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		reset(c1);
		reset(c2);
		
		game.mark(1);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		reset(c1);
		reset(c2);
		
		game.mark(3);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		reset(c1);
		reset(c2);
		
		game.mark(4);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		reset(c1);
		reset(c2);
		
		game.mark(6);

			
		ArgumentCaptor<WinnerValue> argument = ArgumentCaptor.forClass(WinnerValue.class);
		verify(c1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
		
		assertEquals(Andres.getId(),argument.getValue().player.getId());
	}
	
	@Test
	public void winAntonio() {
		TicTacToeGame game = new TicTacToeGame();
		Connection c1= mock(Connection.class);
		Connection c2= mock(Connection.class);
		
		
		game.addConnection(c1);
		game.addConnection(c2);
		
		Player Andres = new Player(1,"X","Jugador 1");
		Player Antonio = new Player(2,"O","Jugador 2");

		
		game.addPlayer(Andres);
		reset(c1);
		reset(c2);
		game.addPlayer(Antonio);
		
		verify(c1).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(Andres,Antonio)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(Andres,Antonio)));
		
		game.mark(2);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		reset(c1);
		reset(c2);
		game.mark(0);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		reset(c1);
		reset(c2);
		game.mark(5);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		reset(c1);
		reset(c2);
		game.mark(4);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		reset(c1);
		reset(c2);
		
		game.mark(6);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		reset(c1);
		reset(c2);
		
		game.mark(8);
			
		ArgumentCaptor<WinnerValue> argument = ArgumentCaptor.forClass(WinnerValue.class);
		verify(c1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
		
		assertEquals(Antonio.getId(),argument.getValue().player.getId());
	}
	
	
	
	@Test
	public void Empate() {
		TicTacToeGame game = new TicTacToeGame();
		Connection c1= mock(Connection.class);
		Connection c2= mock(Connection.class);
		
		
		game.addConnection(c1);
		game.addConnection(c2);
		
		Player Andres = new Player(1,"X","Jugador 1");
		Player Antonio = new Player(2,"O","Jugador 2");

		
		game.addPlayer(Andres);
		reset(c1);
		reset(c2);
		game.addPlayer(Antonio);
		
		verify(c1).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(Andres,Antonio)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(Andres,Antonio)));
		
		game.mark(0);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		reset(c1);
		reset(c2);
		
		game.mark(1);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		reset(c1);
		reset(c2);
		
		game.mark(2);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		reset(c1);
		reset(c2);
		
		game.mark(3);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		reset(c1);
		reset(c2);
		
		game.mark(4);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		reset(c1);
		reset(c2);
		
		game.mark(6);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		reset(c1);
		reset(c2);
		
		game.mark(5);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
		reset(c1);
		reset(c2);
		
		game.mark(8);
		verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
		reset(c1);
		reset(c2);
		
		game.mark(7);
				
		ArgumentCaptor<WinnerValue> argument = ArgumentCaptor.forClass(WinnerValue.class);
		verify(c1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
		assertEquals(null,argument.getValue());
	}
	
	
	
	
	@Test
	public void Draw() {
			TicTacToeGame game = new TicTacToeGame();
			Connection c1= mock(Connection.class);
			Connection c2= mock(Connection.class);
			
			
			game.addConnection(c1);
			game.addConnection(c2);
			
			Player Andres = new Player(1,"X","Jugador 1");
			Player Antonio = new Player(2,"O","Jugador 2");

			
			game.addPlayer(Andres);
			reset(c1);
			reset(c2);
			game.addPlayer(Antonio);
			
			verify(c1).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(Andres,Antonio)));
			verify(c2).sendEvent(eq(EventType.JOIN_GAME),MockitoHamcrest.argThat(hasItems(Andres,Antonio)));
			
			game.mark(4);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
			reset(c1);
			reset(c2);
			game.mark(0);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
			reset(c1);
			reset(c2);
			game.mark(6);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
			reset(c1);
			reset(c2);
			game.mark(2);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
			reset(c1);
			reset(c2);
			game.mark(1);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
			reset(c1);
			reset(c2);
			game.mark(7);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
			reset(c1);
			reset(c2);
			game.mark(3);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Antonio));
			reset(c1);
			reset(c2);
			game.mark(5);
			verify(c1).sendEvent(eq(EventType.SET_TURN),eq(Andres));
			verify(c2).sendEvent(eq(EventType.SET_TURN),eq(Andres));
			reset(c1);
			reset(c2);
			game.mark(8);
			
			verify(c1).sendEvent(eq(EventType.GAME_OVER),eq(null));
			verify(c2).sendEvent(eq(EventType.GAME_OVER),eq(null));
			
			
		
	}
	
}

