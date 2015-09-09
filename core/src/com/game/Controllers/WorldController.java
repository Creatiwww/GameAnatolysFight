package com.game.Controllers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.ScreensAndStages.Screens.MyScreen;

public class WorldController  {

    private ActorsController actorsController;
    private AIController aiController;
    private ScreenController screenController;
    private Batch batch;
    private Turn turn;

    public WorldController () {
        batch = new SpriteBatch();
        turn = new Turn();
        actorsController = new ActorsController(this);
        actorsController.spawnInitialSetOfPlayableActors();
        actorsController.spawnInitialSetOfAIActors();
        aiController = new AIController(this);
        screenController= new ScreenController(this);
    }

    public Batch getBatch(){
        return batch;
    }

    public ActorsController getActorsController(){
        return actorsController;
    }

    public MyScreen getScreen(){
        return screenController.getScreen();
    }

    public Turn getTurn(){
        return this.turn;
    }

    public class Turn {
        public int turnIndex; // 0 - nobody; 1 - player; 2 - AI

        Turn(){
            turnIndex=0;
        }

        public void startAITurn(){
            setAITurn();
            aiController.startAITurn();
        }
        public void endAITurn(){
            setNobodyTurn();
        }
        public void startPlayerTurn(){
            setPlayerTurn();
        }
        public void endPlayerTurn(){
            setNobodyTurn();
        }

        public boolean isAITurn(){
            if (turnIndex==2)return true;
            else return false;
        }
        public boolean isPlayerTurn(){
            if (turnIndex==1)return true;
            else return false;
        }
        public boolean isNobodyTurn(){
            if (turnIndex==0)return true;
            else return false;
        }

        private void setAITurn(){
            turnIndex=2;
        }
        private void setPlayerTurn(){
            turnIndex=1;
        }
        private void setNobodyTurn(){
            turnIndex=0;
        }

    }
}


