package minerwars.engine;

import minerwars.models.Player;
import minerwars.utils.Animator;
import minerwars.utils.Enumerables;
import minerwars.utils.InputHandler;
import minerwars.utils.MyCamera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Sane on 11/29/2015.
 */
public class WorldRenderer {

    private GameWorld myWorld;
    private Animator animator;
    private Animation idleAnimation;
    private MyCamera cam;
    private SpriteBatch batch;
    private Player playerClass;
    private TextureRegion playerIdleCurrentFrame;
    private float stateTime;

    public WorldRenderer(GameWorld world){
        animator = new Animator();
        idleAnimation = animator.getIdleAnimation();
        myWorld = world;
        playerClass = new Player("Santoro", myWorld);
        cam = new MyCamera(playerClass, myWorld);
        cam.setToOrtho(false, 800, 600);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        Gdx.input.setInputProcessor(new InputHandler(playerClass, cam, myWorld));
        cam.position.x = playerClass.getPlayerSprite().getX();
        cam.position.y = playerClass.getPlayerSprite().getY();
        stateTime = 0f;
    }

    public void render(){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        playerIdleCurrentFrame = idleAnimation.getKeyFrame(stateTime, true);
        myWorld.getTiledMapRenderer().setView(cam);
        myWorld.getTiledMapRenderer().render();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();

        if(playerClass.getPlayerState() == Enumerables.PlayerState.RUNNING){
            batch.draw(playerIdleCurrentFrame,
                    playerClass.getPlayerSprite().getX(),
                    playerClass.getPlayerSprite().getY(),
                    playerClass.getPlayerSprite().getWidth(),
                    playerClass.getPlayerSprite().getHeight());
        }
        else{
            batch.draw(playerIdleCurrentFrame,
                    playerClass.getPlayerSprite().getX(),
                    playerClass.getPlayerSprite().getY(),
                    playerClass.getPlayerSprite().getWidth(),
                    playerClass.getPlayerSprite().getHeight());
        }
        batch.end();
        InputHandler.checkInput(playerClass, cam);

    }
}
