package minerwars.engine;

import minerwars.models.Tile;
import minerwars.utils.Gamestate;

public class GameWorld {
    private Gamestate currentState;
    private Tile[][] map;

    public GameWorld(int xSquares, int ySquares){
        currentState = Gamestate.RUNNING;
        map = new Tile[xSquares][ySquares];
        for (int j = 0; j<map[0].length; j++){
            for (int i = 0; i<map.length; i++){
                map[i][j] = new Tile(i, j);
            }
        }
    }

    public void updateRunning(float delta){
        if (delta > .15f) {
            delta = .15f;
        }
    }

    public void update(float delta)
    {
        switch (currentState){
            case READY:
                break;
            case RUNNING:
                updateRunning(delta);
                break;
        }
    }

    public Tile[][] getMap(){
        return map;
    }

}
