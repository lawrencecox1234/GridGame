package com.lawrence123.mygame;

import java.util.Random;

public class Obstacles {
    public int cX, cY;
    public String type;
    public int velocity;
    public int width;
    public int height;
    Random random;
    public Obstacles(String type) {
        this.type = type;

        this.width = MainVariables.getBitmapAsset().getBoxWidth();
        this.height = MainVariables.getBitmapAsset().getBoxHeight();

        if (this.type == "One"){
            cX = MainVariables.playerShiftHorizontal+100;
            cY = 0;
        } else if (this.type == "Two"){
            cX = (MainVariables.playerShiftHorizontal*2)+100;
            cY = 200;
        } else if (this.type == "Three"){
            cX = (MainVariables.playerShiftHorizontal*3)+100;
            cY = 400;
        } else if (this.type == "Four"){
            cX = (MainVariables.playerShiftHorizontal*4)+100;
            cY = 600;
        } else {
            cX = (MainVariables.playerShiftHorizontal*5)+100;
            cY = 300;
        }

        random = new Random();
        this.velocity = MainVariables.VELOCITY_OBSTACLES + random.nextInt(5);

    }

    public void reset(){
        cY = -100;
        this.velocity = MainVariables.VELOCITY_OBSTACLES + random.nextInt(5);
    }
}