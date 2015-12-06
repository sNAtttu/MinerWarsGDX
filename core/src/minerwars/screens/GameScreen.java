package minerwars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;

import minerwars.engine.GameWorld;
import minerwars.engine.WorldRenderer;
import minerwars.utils.InputHandler;

/**
 * Created by Sane on 11/29/2015.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private WorldRenderer renderer;
    private Sound backgroundMusic;

    public GameScreen(){
        Gdx.app.log("GameScreen", "Attached");
        backgroundMusic = Gdx.audio.newSound(Gdx.files.internal("Audio/GameBackground.wav"));
        backgroundMusic.play();
        world = new GameWorld();
        renderer = new WorldRenderer(world);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
