package ca.willenborg.games.flappybird.sprites;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ca.willenborg.games.flappybird.AssetStore;

public class Tube {
	public static final TextureRegion TEXTURE_REGION = 
			AssetStore.INSTANCE.getRegion( "green_pipe" );
	
	private static final int GAP_HEIGHT = 70;
	
	private Vector2 topTubePosition, bottomTubePosition;
	private Rectangle topTubeBounds, bottomTubeBounds;
	private Random random;
	
	public Tube( float x, int viewportHeight ) {
		random = new Random();
		initBounds();
		generateTubePositions(x, viewportHeight);	
	}
	
	private void initBounds() {
		topTubeBounds = new Rectangle( 0, 0, 
				(float) TEXTURE_REGION.getRegionWidth(),
				(float) TEXTURE_REGION.getRegionHeight() );
		bottomTubeBounds = new Rectangle( topTubeBounds );
	}
	
	public void generateTubePositions( float x, int viewportHeight ) {
		topTubePosition = new Vector2( x,
				randomBetween( viewportHeight - TEXTURE_REGION.getRegionHeight(), 
						TEXTURE_REGION.getRegionHeight() + GAP_HEIGHT ) );
		bottomTubePosition = new Vector2( x,
				topTubePosition.y - TEXTURE_REGION.getRegionHeight() - GAP_HEIGHT );
		
		topTubeBounds.setPosition( topTubePosition );
		bottomTubeBounds.setPosition( bottomTubePosition );
	}
	
	private int randomBetween( int minInclusive, int maxInclusive ) {
		return random.nextInt( maxInclusive - minInclusive ) + minInclusive;
	}
	
	public Vector2 getTopTubePosition() {
		return topTubePosition;
	}
	
	public Vector2 getBottomTubePosition() {
		return bottomTubePosition;
	}
	
	public Rectangle getTopTubeBounds() {
		return topTubeBounds;
	}
	
	public Rectangle getBottomTubeBounds() {
		return bottomTubeBounds;
	}
	
	public void dispose() {
		
	}
}
