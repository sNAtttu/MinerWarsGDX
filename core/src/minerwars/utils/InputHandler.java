package minerwars.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Sane on 11/29/2015.
 */
public class InputHandler implements InputProcessor {

    public InputHandler()
    {
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
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

    public static void checkInput(Sprite player, OrthographicCamera camera){
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setX(player.getX()+ Constants.PLAYERSPEED);
            camera.position.x = player.getX();
            camera.position.y = player.getY();
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setX(player.getX() - Constants.PLAYERSPEED);
            camera.position.x = player.getX();
            camera.position.y = player.getY();
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.setY(player.getY() + Constants.PLAYERSPEED);
            camera.position.x = player.getX();
            camera.position.y = player.getY();
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.setY(player.getY() - Constants.PLAYERSPEED);
            camera.position.x = player.getX();
            camera.position.y = player.getY();
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
    }
}
