package minerwars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import minerwars.engine.GameWorld;
import minerwars.engine.WorldRenderer;
import minerwars.utils.InputHandler;

/**
 * Created by Sane on 11/29/2015.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private WorldRenderer renderer;
    private float runTime;

    public GameScreen(){
        Gdx.app.log("GameScreen", "Attached");
        world = new GameWorld(800,600);
        renderer = new WorldRenderer(world);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
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
