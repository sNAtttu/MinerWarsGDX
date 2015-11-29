package com.minerwars.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;

public class MinerWars extends ApplicationAdapter {

	private Texture playerImage;
	private Texture enemyImage;
	private Texture backgroundImage;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Rectangle player;
	private Rectangle enemy;
	
	@Override
	public void create () {
		playerImage = new Texture(Gdx.files.internal("Player/dwarfRight.png"));
		enemyImage = new Texture(Gdx.files.internal("Enemy/chicken.png"));
		backgroundImage = new Texture(Gdx.files.internal("Background/background.png"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,480);
		batch = new SpriteBatch();
		player = new Rectangle();
		enemy = new Rectangle();
		initPlayer(player);
		initEnemy(enemy);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(playerImage, player.x, player.y);
		batch.draw(enemyImage, enemy.x, enemy.y);
		batch.end();
	}

	public void initPlayer(Rectangle character){
		character.x = 100;
		character.y = 20;
		character.width = 64;
		character.height = 64;
	}

	public void initEnemy(Rectangle character){
		character.x = 700;
		character.y = 20;
		character.width = 64;
		character.height = 64;
	}

}
