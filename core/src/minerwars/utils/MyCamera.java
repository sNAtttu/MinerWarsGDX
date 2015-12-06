package minerwars.utils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

import minerwars.engine.GameWorld;
import minerwars.models.Player;

/**
 * Created by Sane on 12/6/2015.
 */
public class MyCamera extends OrthographicCamera{

    private int left,right,top,bottom = 0;
    private Player playerClass;
    private Vector3 lastPosition;
    private GameWorld myWorld;

    public MyCamera(Player playerClass, GameWorld myWorld){
        this.top = this.bottom + myWorld.getWorldHeight();
        this.right = this.left + myWorld.getWorldWidth();
        this.playerClass = playerClass;
        this.myWorld = myWorld;
    }

    @Override
    public void update() {
        position.x = MathUtils.clamp(position.x, (viewportWidth/2),(myWorld.getWorldWidth()-(viewportWidth/2)));
        position.y = MathUtils.clamp(position.y, (viewportHeight/2),(myWorld.getWorldHeight()-(viewportHeight/2)));
        super.update();
    }

}
