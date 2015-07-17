package ca.willenborg.games.flappybird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ca.willenborg.games.flappybird.AssetStore;
import ca.willenborg.games.flappybird.FlappyBird;

public class MenuState extends State {

	private TextureRegion backgroundDay;
	private TextureRegion backgroundNight;
	private TextureRegion playButton;
	
	public MenuState( GameStateManager gsm ) {
		super( gsm );
		assignTextues();
	}
	
	private void assignTextues() {
		backgroundDay = AssetStore.INSTANCE.getRegion( "background_day" );
		backgroundNight = AssetStore.INSTANCE.getRegion( "background_night" );
		playButton = AssetStore.INSTANCE.getRegion( "start_button" );		
	}
	
	@Override
	public void handleInput() {
		if( Gdx.input.justTouched() ) {
			gameStateManager.set( new PlayState( gameStateManager ) );
		}
	}

	@Override
	public void update(float deltaTime) {
		handleInput();		
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		sb.draw( backgroundDay, 0, 0);
		sb.draw( playButton, 
				(camera.viewportWidth / 2) - (playButton.getRegionWidth() / 2),
				(camera.viewportHeight / 2) - (playButton.getRegionHeight() / 2) );
		sb.end();
	}

	@Override
	public void dispose() {
	}

}
