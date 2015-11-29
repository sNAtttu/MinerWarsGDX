package com.minerwars.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.minerwars.game.MinerWars;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(1920, 1080);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new MinerWars();
        }
}