package minerwars.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Sane on 11/30/2015.
 */
public class Animator {

    private static int IDLE_FRAME_COLS = 8;
    private static int IDLE_FRAME_ROWS = 8;
    private Animation runningAnimation;
    private Animation idleAnimation;
    private Texture runningSheet;
    private Texture idleSheet;


    public Animator() {
        idleSheet = new Texture(Gdx.files.internal("Animations/playerIdle.png"));
        runningSheet = new Texture(Gdx.files.internal("Animations/playerRunning.png"));
        idleAnimation = SplitSheetToAnimation(idleSheet);
        runningAnimation = SplitSheetToAnimation(runningSheet);
    }

    public Animation getIdleAnimation() {
        return idleAnimation;
    }

    public Animation getRunningAnimation(){return runningAnimation;}

    private Animation SplitSheetToAnimation(Texture animationSheet){

        TextureRegion[][] tmp = TextureRegion.split(animationSheet,
                animationSheet.getWidth()/IDLE_FRAME_COLS,
                animationSheet.getHeight()/IDLE_FRAME_ROWS
        );
        TextureRegion[] frames = new TextureRegion[IDLE_FRAME_ROWS*IDLE_FRAME_COLS];
        int index = 0;
        for (int i = 0; i < IDLE_FRAME_ROWS; i++) {
            for (int j = 0; j < IDLE_FRAME_COLS; j++) {
                frames[index++] = tmp[i][j];
            }
        }
        Animation animation = new Animation(0.025f, frames);
        return animation;
    }
}
