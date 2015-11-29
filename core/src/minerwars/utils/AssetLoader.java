package minerwars.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Sane on 11/29/2015.
 */
public class AssetLoader {
    public static TextureRegion bg, tile;
    public static Texture bgTexture, tileTexture;

    public static void load() {
        bgTexture = new Texture(Gdx.files.internal("Background/background.png"));
        bgTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        tileTexture = new Texture(Gdx.files.internal("Tilesets/grass.png"));

        bg = new TextureRegion(bgTexture, 0, 0, Constants.GAMEWIDTH, Constants.GAMEHEIGHT);
        bg.flip(false, true);
    }

    public static void dispose(){
        bgTexture.dispose();
        tileTexture.dispose();
    }
}