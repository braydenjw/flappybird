package ca.willenborg.games.flappybird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import ca.willenborg.games.flappybird.AssetStore;
import ca.willenborg.games.flappybird.sprites.Bird;
import ca.willenborg.games.flappybird.sprites.Tube;

public class PlayState extends State {
	private static final int TUBE_SPACING = 70;
	private static final int TUBE_COUNT = 2;
	
	private Bird bird;	
	private Array<Tube> tubes;
	private TextureRegion background;

	protected PlayState(GameStateManager gsm) {
		super(gsm);
		bird = new Bird( 50, 100 );
		tubes = new Array<Tube>();
		background = AssetStore.INSTANCE.getRegion( "background_day" );
		
		for( int i = 1; i <= TUBE_COUNT; i++ ) {
			tubes.add( new Tube( i * ( TUBE_SPACING + Tube.TEXTURE_REGION.getRegionWidth() ), 
					(int) camera.viewportHeight ) );
		}
	}

	@Override
	public void handleInput() {
		if( Gdx.input.justTouched() ) {
			bird.jump();
		}
	}

	@Override
	public void update( float deltaTime ) {
		handleInput();
		bird.update( deltaTime );
		detectCollisions();
		camera.position.x = bird.getPosition().x + 40;
		relocateTubes();		
		camera.update();
	}
	
	private void detectCollisions() {
		for( int i = 0; i < tubes.size; i++ ) {
			if ( bird.getBounds().overlaps( tubes.get( i ).getTopTubeBounds() ) ||
					bird.getBounds().overlaps( tubes.get( i ).getBottomTubeBounds() ) ) {
				gameStateManager.set( new PlayState( gameStateManager ) );
			}
		}
	}
	
	private void relocateTubes() {
		for( Tube tube : tubes) {
			if( camera.position.x - ( camera.viewportWidth / 2 ) 
					> tube.getTopTubePosition().x + Tube.TEXTURE_REGION.getRegionWidth() ) {
				relocateTube( tube );
			}
		}
	}
	
	private void relocateTube( Tube tube ) {
		tube.generateTubePositions( tube.getTopTubePosition().x + 
				( TUBE_COUNT * ( Tube.TEXTURE_REGION.getRegionWidth() + TUBE_SPACING ) ), 
				(int) camera.viewportHeight);
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		drawBackground( sb );
		drawBird( sb );
		drawTubes( sb );
		sb.end();
	}
	
	private void drawBackground( SpriteBatch sb ) {
		sb.draw( background, camera.position.x - ( camera.viewportWidth / 2 ), 0);
	}

	private void drawBird(SpriteBatch sb) {
		sb.draw( bird.getTextureRegion(),
				bird.getPosition().x,
				bird.getPosition().y );
	}
	
	private void drawTubes( SpriteBatch sb ) {
		for ( Tube tube : tubes) {
			sb.draw( Tube.TEXTURE_REGION, 
					tube.getBottomTubePosition().x,
					tube.getBottomTubePosition().y );
			Tube.TEXTURE_REGION.flip( false, true );
			sb.draw( Tube.TEXTURE_REGION, 
					tube.getTopTubePosition().x,
					tube.getTopTubePosition().y );
			Tube.TEXTURE_REGION.flip( false, true );
		}
	}

	@Override
	public void dispose() {
		for ( Tube tube : tubes ) {
			tube.dispose();
		}

	}

}
