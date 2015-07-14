package ca.willenborg.games.flappybird.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ca.willenborg.games.flappybird.AssetStore;
import ca.willenborg.games.flappybird.sprites.Bird;

public class PlayState extends State {
	
	private Bird bird;

	protected PlayState(GameStateManager gsm) {
		super(gsm);
		bird = new Bird( 50, 100 );
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
		sb.draw( bird.getTextureRegion(),
				bird.getPosition().x,
				bird.getPosition().y );
		sb.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
