package minerwars.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import minerwars.models.Player;
import minerwars.models.Enemy;
import minerwars.models.Tile;
import minerwars.utils.AssetLoader;
import minerwars.utils.Constants;
import minerwars.utils.InputHandler;

/**
 * Created by Sane on 11/29/2015.
 */
public class WorldRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private SpriteBatch batch;
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    private Tile[][] map;
    private Sprite player;
    private Sprite enemy;
    private Player playerClass;

    public WorldRenderer(GameWorld world){
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 800, 600);
        tiledMap = new TmxMapLoader().load("TMX/MinerWarsBaseMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        initGameObjects();
        Gdx.input.setInputProcessor(new InputHandler(cam, player));
        cam.position.x = player.getX();
        cam.position.y = player.getY();
        cam.update();
    }

    public void render(){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        player.draw(batch);
        batch.end();
        checkInput();
    }
    public void checkInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setX(player.getX()+ Constants.PLAYERSPEED);
            cam.position.x = player.getX();
            cam.position.y = player.getY();
            cam.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setX(player.getX() - Constants.PLAYERSPEED);
            cam.position.x = player.getX();
            cam.position.y = player.getY();
            cam.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.setY(player.getY() + Constants.PLAYERSPEED);
            cam.position.x = player.getX();
            cam.position.y = player.getY();
            cam.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.setY(player.getY() - Constants.PLAYERSPEED);
            cam.position.x = player.getX();
            cam.position.y = player.getY();
            cam.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
    }

    private void initGameObjects(){
        playerClass = new Player("Santoro", 100, 20);
        Enemy enemyClass = new Enemy(800,20);
        enemy = enemyClass.initEnemy();
        player = playerClass.initPlayer();
        map = myWorld.getMap();
    }

}
