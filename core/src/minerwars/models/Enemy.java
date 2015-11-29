package minerwars.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Sane on 11/29/2015.
 */
public class Enemy {

    private Texture enemyImage;
    private int positionX;
    private int positionY;

    public Enemy(int positionX, int positionY) {
        this.enemyImage = new Texture(Gdx.files.internal("Enemy/chicken.png"));
        this.setPositionX(positionX);
        this.setPositionY(positionY);
    }

    public Sprite initEnemy(){
        Sprite enemy = new Sprite(this.enemyImage);
        enemy.setX(this.getPositionX());
        enemy.setY(this.getPositionY());
        return enemy;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}
