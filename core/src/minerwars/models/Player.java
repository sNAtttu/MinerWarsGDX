package minerwars.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Sane on 11/29/2015.
 */
public class Player {

    private Texture playerImage;
    private String name;
    private int positionX;
    private int positionY;
    private int[][] location;

    public Player(String name, int positionX, int positionY) {
        this.name = name;
        this.playerImage = new Texture(Gdx.files.internal("Player/dwarfRight.png"));
        this.setPositionX(positionX);
        this.setPositionY(positionY);
    }

    public Sprite initPlayer(){
        Sprite player = new Sprite(this.playerImage);
        player.setX(this.getPositionX());
        player.setY(this.getPositionY());
        this.location = new int[this.getPositionX()][this.getPositionY()];
        return player;
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

    public int[][] getLocation() {
        return location;
    }

    public void setLocation(int positionX, int positionY) {
        this.location = new int[positionX][positionY];
    }

}
