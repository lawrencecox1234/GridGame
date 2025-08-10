package com.lawrence123.mygame;

public class Player {
    public int pX, pY, pXInitial, pYInitial, pFrame, velocity;

    public Player(){
        pXInitial = 75;
        pYInitial = 20;
        pX = 75;
        pY = 20;
        pFrame = 0;
        velocity = 0;
    }

    // Getter method for velocity
    public int getVelocity(){
        return velocity;
    }

    // Setter method for velocity
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }

    // Getter method for getting X-coordinate of the Player
    public int getX(){
        return pX;
    }

    // Getter method for getting the Y-coordinate of the Player
    public int getY(){
        return pY;
    }

    public int getXInital(){
        return pXInitial;
    }

    public int getYInital(){
        return pYInitial;
    }

    // Setter method for setting the X-coordinate
    public void setX(int pX){
        this.pX = pX;
    }

    // Setter method for setting the Y-coordinate
    public void setY(int pY){
        this.pY = pY;
    }
}
