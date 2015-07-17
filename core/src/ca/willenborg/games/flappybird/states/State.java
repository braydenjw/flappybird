package ca.willenborg.games.flappybird.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
	
	protected OrthographicCamera camera;
	protected Vector3 mousePos;
	protected GameStateManager gameStateManager;
	
	protected State( GameStateManager gsm ) {
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho( false, 144, 256);
		this.mousePos = new Vector3();
		this.gameStateManager = gsm;
	}
	
	public abstract void handleInput();
	public abstract void update( float deltaTime );
	public abstract void render( SpriteBatch sb );
	public abstract void dispose();
}
