package ca.willenborg.games.flappybird.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import ca.willenborg.games.flappybird.AssetStore;

public class Bird {
	private static final int MOVEMENT = 100;
	private static final int GRAVITY = -15;
	
	private Vector3 position;
	private Vector3 velocity;
	private TextureRegion bird;
	private Rectangle birdBounds;
	
	public Bird( int x, int y ) {
		position = new Vector3(x, y, 0);
		velocity = new Vector3(0, 0, 0);
		bird = AssetStore.INSTANCE.getRegion( "bird1_wings_level" );
		initBounds( x, y );
	}
	
	private void initBounds( int x, int y ) {
		birdBounds = new Rectangle( (float) x, (float) y, 
				(float) getTextureRegion().getRegionWidth(),
				(float) getTextureRegion().getRegionHeight());
	}
	
	public void update( float deltaTime ) {
		velocity.add( 0, GRAVITY, 0);
		velocity.scl( deltaTime );
		calculatePosition( deltaTime );
		velocity.scl( 1 / deltaTime );
	}
	
	private void calculatePosition( float deltaTime ) {
		if( position.y < 0 ) {
			position.y = 0;
		} else {
			position.add( MOVEMENT * deltaTime , velocity.y, velocity.z );
		}
		birdBounds.setPosition( new Vector2( position.x, position.y ) );
	}
	
	public void jump() {
		velocity.y = 250;
	}
	
	public Vector3 getPosition() {
		return position;
	}
	
	public TextureRegion getTextureRegion() {
		return bird;
	}
	
	public Rectangle getBounds() {
		return birdBounds;
	}
}
