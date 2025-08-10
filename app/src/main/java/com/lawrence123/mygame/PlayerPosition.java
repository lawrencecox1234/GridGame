package com.lawrence123.mygame;

import java.util.HashMap;

public class PlayerPosition {

    int playerPositionX;
    int playerPositionY;

    public PlayerPosition(){
        playerPositionX = 1;
        playerPositionY = 1;
    }

    public void playerMoveRight(){
        playerPositionX += 1;
        if (playerPositionX > 6){
            playerPositionX = 6;
        }
    }

    public void playerMoveLeft(){
        playerPositionX -= 1;
        if (playerPositionX < 1){
            playerPositionX = 1;
        }
    }

    public void playerMoveUp(){
        playerPositionY -= 1;
        if (playerPositionY < 1){
            playerPositionY= 1;
        }
    }

    public void playerMoveDown(){
        playerPositionY += 1;
        if (playerPositionY > 4){
            playerPositionY= 4;
        }
    }

    public int getPlayerPositionX(){
        return playerPositionX;
    }

    public int getPlayerPositionY(){
        return playerPositionY;
    }

    public void setPlayerPositionX(int pX){
        playerPositionX = pX;
    }

    public void setPlayerPositionY(int pY){
        playerPositionY = pY;
    }

}
