package ca.willenborg.games.flappybird.sprites;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ca.willenborg.games.flappybird.AssetStore;

public class Tube {
	private static final int GAP_HEIGHT = 70;
	
	private final TextureRegion textureRegion;
	private Vector2 topTubePosition;
	private Vector2 bottomTubePosition;
	private Random random;
	
	public Tube( float x, int viewportHeight ) {
		textureRegion = AssetStore.INSTANCE.getRegion( "green_pipe" );
		random = new Random();
		generateTubePositions(x, viewportHeight);	
	}
	
	private void generateTubePositions( float x, int viewportHeight ) {
		int tubeHeight = textureRegion.getRegionHeight();
		topTubePosition = new Vector2( x,
				randomBetween( viewportHeight - tubeHeight, 
						tubeHeight + GAP_HEIGHT ) );
		bottomTubePosition = new Vector2( x,
				topTubePosition.y - tubeHeight - GAP_HEIGHT );
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
	
	public TextureRegion getTextureRegion() {
		return textureRegion;
	}
}
