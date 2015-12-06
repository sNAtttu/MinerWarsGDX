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
    public Enumerables.PlayerDirection playerDirection;
    private Texture playerImage;
    private String name;
    private Sprite playerSprite;
    private int positionX;
    private int positionY;
    private GameWorld world;

    public Player(String name, GameWorld world) {
        this.world = world;
        this.playerState = Enumerables.PlayerState.IDLE;
        this.playerDirection = Enumerables.PlayerDirection.RIGHT;
        this.name = name;
        this.playerImage = new Texture(Gdx.files.internal("Player/playerStill.png"));
        this.playerSprite = new Sprite(this.playerImage);
        this.setPositionX(world.getWorldWidth() / 2);
        this.setPositionY(world.getWorldHeight() / 2);
        this.playerSprite.setX(world.getWorldWidth() / 2);
        this.playerSprite.setY(world.getWorldHeight() / 2);
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
    public Enumerables.PlayerDirection getPlayerDirection() {
        return playerDirection;
    }

    public void setPlayerDirection(Enumerables.PlayerDirection playerDirection) {
        this.playerDirection = playerDirection;
    }

    public void Mine() {

    }
}
