package com.lawrence123.mygame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;

public class BitmapAssets {

    Bitmap arrowUp;
    Bitmap arrowRight;
    Bitmap arrowDown;
    Bitmap arrowLeft;
    Bitmap redX;

    Bitmap background;
    Bitmap box;
    Bitmap iceBox;
    Bitmap tapToStart;

    public BitmapAssets (Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = Bitmap.createScaledBitmap(background, MainVariables.SCREEN_WIDTH, MainVariables.SCREEN_HEIGHT, false);

        arrowUp = BitmapFactory.decodeResource(res, R.drawable.arrowup);
        arrowRight = BitmapFactory.decodeResource(res, R.drawable.arrowright);
        arrowDown = BitmapFactory.decodeResource(res, R.drawable.arrowdown);
        arrowLeft = BitmapFactory.decodeResource(res, R.drawable.arrowleft);
        redX = BitmapFactory.decodeResource(res, R.drawable.redx);

        box = BitmapFactory.decodeResource(res, R.drawable.box);
        iceBox = BitmapFactory.decodeResource(res, R.drawable.icebox);
        tapToStart = BitmapFactory.decodeResource(res, R.drawable.tap_to_start);
    }

    public Rect getFrameToDraw(){
        return new Rect(0, 0, getBackgroundWidth(), getBackgroundHeight());
    }

    public RectF getWhereToDraw(){
        return new RectF(0, 0, MainVariables.SCREEN_WIDTH, MainVariables.SCREEN_HEIGHT);
    }

    public Bitmap getArrowUp(){
        return arrowUp;
    }
    public int getArrowUpWidth(){
        return arrowUp.getWidth();
    }
    public int getArrowUpHeight(){
        return arrowUp.getHeight();
    }

    public Bitmap getArrowRight(){
        return arrowRight;
    }
    public int getArrowRightWidth(){
        return arrowRight.getWidth();
    }
    public int getArrowRightHeight(){
        return arrowRight.getHeight();
    }

    public Bitmap getArrowDown(){
        return arrowDown;
    }
    public int getArrowDownWidth(){
        return arrowDown.getWidth();
    }
    public int getArrowDownHeight(){ return arrowDown.getHeight(); }

    public Bitmap getArrowLeft(){
        return arrowLeft;
    }
    public int getArrowLeftWidth(){
        return arrowLeft.getWidth();
    }
    public int getArrowLeftHeight(){ return arrowLeft.getHeight(); }

    public Bitmap getRedX(){
        return redX;
    }
    public int getRedXWidth(){
        return redX.getWidth();
    }
    public int getRedXHeight(){ return redX.getHeight(); }

    public Bitmap getBackground(){
        return background;
    }
    public int getBackgroundWidth(){
        return background.getWidth();
    }
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap getBox(){
        return box;
    }
    public int getBoxWidth(){
        return box.getWidth();
    }
    public int getBoxHeight(){
        return box.getHeight();
    }

    public Bitmap getIceBox(){
        return iceBox;
    }
    public int getIceBoxWidth(){ return iceBox.getWidth(); }
    public int getIceBoxHeight(){ return iceBox.getHeight(); }

    public Bitmap getTapToStart(){ return tapToStart; }
    public int getTapToStartWidth(){ return tapToStart.getWidth(); }
    public int getTapToStartHeight(){ return tapToStart.getHeight(); }

}
