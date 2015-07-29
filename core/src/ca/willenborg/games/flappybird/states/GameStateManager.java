package ca.willenborg.games.flappybird.states;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStateManager {

	private Stack<State> states;
	
	public GameStateManager() {
		this.states = new Stack<State>();
	}
	
	public void pop() {
		this.states.pop().dispose();
	}
	
	public void push( State state ) {
		this.states.push( state );
	}
	
	public void set( State state ) {
		this.states.pop().dispose();
		this.states.push( state );
	}
	
	public void update( float deltaTime ) {
		this.states.peek().update( deltaTime );
	}
	
	public void render( SpriteBatch sb ) {
		this.states.peek().render( sb );
	}
	
	
}
