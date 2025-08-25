package com.lawrence123.mygame;

import java.util.HashMap;

public class PlayerPosition {

    int playerPositionX;
    int playerPositionY;

    public PlayerPosition(){
        playerPositionX = 0;
        playerPositionY = 0;
    }

    public void playerMoveRight(){
        playerPositionX += 1;
        if (playerPositionX > 5){
            playerPositionX = 5;
        }
    }

    public void playerMoveLeft(){
        playerPositionX -= 1;
        if (playerPositionX < 0){
            playerPositionX = 0;
        }
    }

    public void playerMoveUp(){
        playerPositionY -= 1;
        if (playerPositionY < 0){
            playerPositionY= 0;
        }
    }

    public void playerMoveDown(){
        playerPositionY += 1;
        if (playerPositionY > 3){
            playerPositionY= 3;
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
