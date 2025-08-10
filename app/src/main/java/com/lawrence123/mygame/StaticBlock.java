package com.lawrence123.mygame;

import java.util.Random;

public class StaticBlock {

    public int pX, pY;

    Random random = new Random();

    public StaticBlock(int pX){

        this.pX = pX;
        this.pY = random.nextInt(4);

    }

    public int getX(){
        return pX;
    }

    public int getY(){
        return pY;
    }

    public void setX(int pX){
        this.pX = pX;
    }

    public void setY(int pY){
        this.pY = pY;
    }
}
