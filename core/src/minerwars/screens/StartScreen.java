package minerwars.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minerwars.game.MinerWars;

/**
 * Created by Sane on 12/6/2015.
 */
public class StartScreen implements Screen{


    final MinerWars game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont font;
    private Sound bgMusic;

    public StartScreen(final MinerWars game){
        this.game = game;
        this.font = new BitmapFont();
        this.batch = new SpriteBatch();
        this.bgMusic = Gdx.audio.newSound(Gdx.files.internal("Audio/StartScreenAudio.wav"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        Gdx.app.log("START SCREEN", "Created!");
        bgMusic.play();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.begin();
        font.draw(batch, "Welcome to Miner Wars!!", 100, 150);
        font.draw(batch,"Press any key to start playing!", 100, 100);
        batch.end();


        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new GameScreen());
            dispose();
        }
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
        batch.dispose();
        font.dispose();
        bgMusic.stop();
    }
}
