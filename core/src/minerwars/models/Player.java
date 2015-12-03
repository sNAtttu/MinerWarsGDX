package minerwars.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapProperties;

import minerwars.engine.GameWorld;
import minerwars.utils.Enumerables;

/**
 * Created by Sane on 11/29/2015.
 */
public class Player {

    public Enumerables.PlayerState playerState;
    private Texture playerImage;
    private String name;
    private Sprite playerSprite;
    private int positionX;
    private int positionY;

    public Player(String name,MapProperties prop) {
        int mapWidth = prop.get("width", Integer.class);
        int mapHeight = prop.get("height", Integer.class);
        int tilePixelWidth = prop.get("tilewidth", Integer.class);
        int tilePixelHeight = prop.get("tileheight", Integer.class);
        int mapPixelWidth = mapWidth * tilePixelWidth;
        int mapPixelHeight = mapHeight * tilePixelHeight;
        this.name = name;
        this.playerImage = new Texture(Gdx.files.internal("Player/playerStill.png"));
        this.playerSprite = new Sprite(this.playerImage);
        this.setPositionX(mapPixelWidth / 2);
        this.setPositionY(mapPixelHeight / 2);
        this.playerSprite.setX(mapPixelWidth / 2);
        this.playerSprite.setY(mapPixelHeight / 2);
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
    public Enumerables.PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(Enumerables.PlayerState playerState) {
        this.playerState = playerState;
    }

    public Sprite getPlayerSprite() {
        return playerSprite;
    }

    public void setPlayerSprite(Sprite playerSprite) {
        this.playerSprite = playerSprite;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
