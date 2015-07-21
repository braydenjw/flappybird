package ca.willenborg.games.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import ca.willenborg.games.flappybird.AssetStore;

public class Bird {
	private static final int MOVEMENT = 100;
	private static final int GRAVITY = -15;
	
	private Vector3 position;
	private Vector3 velocity;
	private TextureRegion bird;
	
	public Bird( int x, int y ) {
		position = new Vector3(x, y, 0);
		velocity = new Vector3(0, 0, 0);
		bird = AssetStore.INSTANCE.getRegion( "bird1_wings_level" );
	}
	
	public void update( float deltaTime ) {
		velocity.add( 0, GRAVITY, 0);
		velocity.scl( deltaTime );
		if( position.y < 0 ) {
			position.y = 0;
		} else {
			position.add( MOVEMENT * deltaTime , velocity.y, velocity.z );
		}
		velocity.scl( 1 / deltaTime );
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
}
