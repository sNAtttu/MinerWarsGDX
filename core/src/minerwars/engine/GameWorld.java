package minerwars.engine;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import minerwars.utils.Enumerables;

public class GameWorld {

    private Enumerables.GameState currentState;
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    private MapProperties mapProperties;
    private int mapWidth;
    private int mapHeight;
    private int tilePixelWidth;
    private int tilePixelHeight;
    private int worldWidth;
    private int worldHeight;

    public GameWorld(){
        this.mapWidth = mapProperties.get("width", Integer.class);
        this.mapHeight = mapProperties.get("height", Integer.class);
        this.tilePixelWidth = mapProperties.get("tilewidth", Integer.class);
        this.tilePixelHeight = mapProperties.get("tileheight", Integer.class);
        this.worldWidth = mapWidth * tilePixelWidth;
        this.worldHeight = mapHeight * tilePixelHeight;
        currentState = Enumerables.GameState.RUNNING;
        this.tiledMap = new TmxMapLoader().load("TMX/MinerWarsBaseMap.tmx");
        this.tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        mapProperties = tiledMap.getProperties();
    }
    public MapProperties getMapProperties() {
        return mapProperties;
    }
    public TiledMapRenderer getTiledMapRenderer() {
        return tiledMapRenderer;
    }
    public int getWorldHeight() {
        return worldHeight;
    }

    public void setWorldHeight(int worldHeight) {
        this.worldHeight = worldHeight;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public void setWorldWidth(int worldWidth) {
        this.worldWidth = worldWidth;
    }

    public int getTilePixelHeight() {
        return tilePixelHeight;
    }

    public void setTilePixelHeight(int tilePixelHeight) {
        this.tilePixelHeight = tilePixelHeight;
    }

    public int getTilePixelWidth() {
        return tilePixelWidth;
    }

    public void setTilePixelWidth(int tilePixelWidth) {
        this.tilePixelWidth = tilePixelWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }
}
