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

    public GameWorld(int xSquares, int ySquares){
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
}
