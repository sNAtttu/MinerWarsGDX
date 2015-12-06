package minerwars.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

import minerwars.engine.GameWorld;
import minerwars.models.Player;

/**
 * Created by Sane on 11/29/2015.
 */
public class InputHandler implements InputProcessor {

    private Player playerClass;
    private GameWorld myWorld;

    public InputHandler(Player playerClass, MyCamera camera, GameWorld world)
    {
        this.playerClass = playerClass;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        playerClass.setPlayerState(Enumerables.PlayerState.IDLE);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public static void checkInput(Player playerClass, MyCamera camera, GameWorld myWorld){

        Sprite player = playerClass.getPlayerSprite();

        camera.position.x = player.getX();
        camera.position.y = player.getY();

        camera.update();
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            playerClass.setPlayerState(Enumerables.PlayerState.RUNNING);
            player.setX(player.getX() + Constants.PLAYERSPEED);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            playerClass.setPlayerState(Enumerables.PlayerState.RUNNING);
            player.setX(player.getX() - Constants.PLAYERSPEED);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            playerClass.setPlayerState(Enumerables.PlayerState.RUNNING);
            player.setY(player.getY() + Constants.PLAYERSPEED);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            playerClass.setPlayerState(Enumerables.PlayerState.RUNNING);
            player.setY(player.getY() - Constants.PLAYERSPEED);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        camera.update();
    }

}
