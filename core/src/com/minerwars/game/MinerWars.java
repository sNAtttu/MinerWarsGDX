package com.minerwars.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MinerWars extends ApplicationAdapter {

	private Texture playerImage;
	private Texture enemyImage;
	private Texture backgroundImage;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Sprite player;
	
	@Override
	public void create () {
		playerImage = new Texture(Gdx.files.internal("Player/dwarfRight.png"));
		enemyImage = new Texture(Gdx.files.internal("Enemy/chicken.png"));
		backgroundImage = new Texture(Gdx.files.internal("Background/background.png"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		batch = new SpriteBatch();
		player = new Sprite(playerImage);
		player.scale((float) -0.2);
		initPlayer(player);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player.draw(batch);
		batch.end();
		checkMovement();
	}


	public void initPlayer(Sprite player){
		player.setX(100);
		player.setY(20);
	}

	public void checkMovement(){
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			player.setX(player.getX()+ 20);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			player.setX(player.getX()- 20);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			player.setY(player.getY() + 20);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			player.setY(player.getY() - 20);
		}
	}

}
