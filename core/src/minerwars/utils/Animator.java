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
    private Animation idleAnimation;
    private Texture idleSheet;
    private TextureRegion[] idleFrames;


    public Animator(){
        idleSheet = new Texture(Gdx.files.internal("Animations/playerIdle.png"));
        TextureRegion[][] tmp = TextureRegion.split(idleSheet,
                idleSheet.getWidth()/IDLE_FRAME_COLS,
                idleSheet.getHeight()/IDLE_FRAME_ROWS
                );
        idleFrames = new TextureRegion[IDLE_FRAME_ROWS*IDLE_FRAME_COLS];
        int index = 0;
        for (int i = 0; i < IDLE_FRAME_ROWS; i++) {
            for (int j = 0; j < IDLE_FRAME_COLS; j++) {
                idleFrames[index++] = tmp[i][j];
            }
        }
        idleAnimation = new Animation(0.025f, idleFrames);
    }

    public Animation getIdleAnimation() {
        return idleAnimation;
    }

}
