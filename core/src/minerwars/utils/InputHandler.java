package minerwars.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import minerwars.engine.GameWorld;
import minerwars.models.Player;

/**
 * Created by Sane on 11/29/2015.
 */
public class InputHandler implements InputProcessor {

    private Player playerClass;
    private GameWorld myWorld;
    private OrthographicCamera cam;

    public InputHandler(Player playerClass, OrthographicCamera camera, GameWorld world)
    {
        this.playerClass = playerClass;
        this.myWorld = world;
        this.cam = camera;
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

    public static void checkInput(Player playerClass, OrthographicCamera camera, GameWorld myWorld){

        Sprite player = playerClass.getPlayerSprite();

        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            playerClass.setPlayerState(Enumerables.PlayerState.RUNNING);
            player.setX(player.getX() + Constants.PLAYERSPEED);
            CheckBoundaries(player, camera, myWorld);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            playerClass.setPlayerState(Enumerables.PlayerState.RUNNING);
            player.setX(player.getX() - Constants.PLAYERSPEED);
            CheckBoundaries(player, camera, myWorld);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            playerClass.setPlayerState(Enumerables.PlayerState.RUNNING);
            player.setY(player.getY() + Constants.PLAYERSPEED);
            CheckBoundaries(player, camera, myWorld);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            playerClass.setPlayerState(Enumerables.PlayerState.RUNNING);
            player.setY(player.getY() - Constants.PLAYERSPEED);
            CheckBoundaries(player, camera, myWorld);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
    }
    private static void CheckBoundaries(Sprite player, OrthographicCamera camera, GameWorld myWorld){

        int mapLeft = 0;
        int mapRight = myWorld.getWorldWidth();
        int mapBottom = 0;
        int mapTop = myWorld.getWorldHeight();

        float cameraHalfWidth = camera.viewportWidth * 0.5f;
        float cameraHalfHeight = camera.viewportHeight * 0.5f;

        float cameraLeft = camera.position.x - cameraHalfWidth;
        float cameraRight = camera.position.x + cameraHalfWidth;
        float cameraBottom = camera.position.y - cameraHalfHeight;
        float cameraTop = camera.position.y + cameraHalfHeight;

        camera.position.x = player.getX();
        camera.position.y = player.getY();

        if(myWorld.getWorldWidth() < camera.viewportWidth)
        {
            camera.position.x = mapRight / 2;
        }
        else if(cameraLeft <= mapLeft)
        {
            camera.position.x = mapLeft + cameraHalfWidth;
        }
        else if(cameraRight >= mapRight)
        {
            camera.position.x = mapRight - cameraHalfWidth;
        }

// Vertical axis
        if(myWorld.getWorldHeight() < camera.viewportHeight)
        {
            camera.position.y = mapTop / 2;
        }
        else if(cameraBottom <= mapBottom)
        {
            camera.position.y = mapBottom + cameraHalfHeight;
        }
        else if(cameraTop >= mapTop)
        {
            camera.position.y = mapTop - cameraHalfHeight;
        }
        camera.update();
    }
}
