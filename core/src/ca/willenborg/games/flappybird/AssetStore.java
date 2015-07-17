package ca.willenborg.games.flappybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public enum AssetStore
{
    INSTANCE;

	private final TextureAtlas flappyBirdAtlas;

    AssetStore() {
    	flappyBirdAtlas = new TextureAtlas( Gdx.files.internal( "flappybird.atlas" ) );
    }
    
    public TextureRegion getRegion( String region ) {
    	return flappyBirdAtlas.findRegion( region );
    }

    public static AssetStore getInstance() {
        return INSTANCE;
    }
}
