package com.minerwars.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import minerwars.models.Enemy;
import minerwars.models.Player;
import minerwars.screens.GameScreen;
import minerwars.screens.StartScreen;
import minerwars.utils.AssetLoader;
import minerwars.utils.Constants;


public class MinerWars extends Game {

	@Override
	public void create () {
		Gdx.app.log("MinerWars", "Created!");
		AssetLoader.load();
		setScreen(new StartScreen(this));
	}

	@Override
	public void render(){
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
