package ca.willenborg.games.flappybird.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ca.willenborg.games.flappybird.AssetStore;
import ca.willenborg.games.flappybird.sprites.Bird;
import ca.willenborg.games.flappybird.sprites.Tube;

public class PlayState extends State {
	
	private Bird bird;
	private Tube tube;

	protected PlayState(GameStateManager gsm) {
		super(gsm);
		bird = new Bird( 50, 100 );
		tube = new Tube( 100, (int) camera.viewportHeight );
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float deltaTime) {
		handleInput();
		bird.update( deltaTime );
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		drawBird( sb );
		drawTubes( sb );
		sb.end();
	}

	private void drawBird(SpriteBatch sb) {
		sb.draw( bird.getTextureRegion(),
				bird.getPosition().x,
				bird.getPosition().y );
	}
	
	private void drawTubes( SpriteBatch sb ) {
		TextureRegion tubeRegion = tube.getTextureRegion();
		sb.draw( tubeRegion, 
				tube.getBottomTubePosition().x,
				tube.getBottomTubePosition().y );
		tubeRegion.flip( false, true );
		sb.draw( tubeRegion, 
				tube.getTopTubePosition().x,
				tube.getTopTubePosition().y );
		tubeRegion.flip( false, true );
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
