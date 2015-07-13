package ca.willenborg.games.flappybird.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ca.willenborg.games.flappybird.AssetStore;

public class PlayState extends State {
	
	private TextureRegion bird;

	protected PlayState(GameStateManager gsm) {
		super(gsm);
		assignTextures();
	}
	
	private void assignTextures() {
		bird = AssetStore.INSTANCE.getRegion( "bird1_wings_level" );
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float deltaTime) {
		handleInput();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw( bird,
				bird.getRegionWidth() / -2,
				bird.getRegionHeight() / -2 );
		sb.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
