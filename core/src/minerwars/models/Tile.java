package minerwars.models;

import minerwars.utils.Constants;

public class Tile {

    private int tileX;
    private int tileY;
    private int coorX;
    private int coorY;

    public Tile(int tileX, int tileY){
        this.tileX = tileX;
        this.tileY = tileY;
        coorX = tileX * Constants.TILEWIDTH;
        coorY = tileY * Constants.TILEHEIGHT;
    }
    public int getTileY() {
        return tileY;
    }
    public int getTileX() {
        return tileX;
    }
    public int getCoorX() {
        return coorX;
    }
    public int getCoorY() {
        return coorY;
    }
}
