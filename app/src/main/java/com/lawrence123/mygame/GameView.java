package com.lawrence123.mygame;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;

    private float x1, x2, y1, y2;
    static final int MIN_DISTANCE = 10;

    public GameView(Context context) {
        super(context);
        initView();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (!gameThread.isRunning()) {
            gameThread = new GameThread(holder);
            gameThread.start();
        } else {
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (gameThread.isRunning()) {
            gameThread.setIsRunning(false);
            boolean retry = true;
            while (retry) {
                try {
                    gameThread.join();
                    retry = false;
                } catch (InterruptedException e) {
                }
            }
        }
    }

    void initView() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();

                float deltaX = x2 - x1;
                float deltaY = y2 - y1;

                if ((Math.abs(deltaX) > MIN_DISTANCE) && (Math.abs(deltaX) > Math.abs(deltaY))) {
                    // Left to Right swipe action
                    if (x2 > x1) {
                        MainVariables.playerMoveLeft = false;
                        MainVariables.playerMoveDown = false;
                        MainVariables.playerMoveUp = false;
                        MainVariables.playerMoveRight = true;
                    }

                    // Right to left swipe action
                    else {
                        MainVariables.playerMoveRight = false;
                        MainVariables.playerMoveDown = false;
                        MainVariables.playerMoveUp = false;
                        MainVariables.playerMoveLeft = true;
                    }

                }

                else if ((Math.abs(deltaY) > MIN_DISTANCE) && (Math.abs(deltaY) > Math.abs(deltaX))) {
                    // Up to down swipe action
                    if (y2 > y1) {
                        MainVariables.playerMoveRight = false;
                        MainVariables.playerMoveLeft = false;
                        MainVariables.playerMoveUp = false;
                        MainVariables.playerMoveDown = true;
                    }

                    // Down to up swipe action
                    else {
                        MainVariables.playerMoveRight = false;
                        MainVariables.playerMoveLeft = false;
                        MainVariables.playerMoveDown = false;
                        MainVariables.playerMoveUp = true;
                    }

                }

                else {
                    // consider as something else - a screen tap for example
                    if(MainVariables.getGameEngine().gameState == 0){
                        MainVariables.getGameEngine().gameState = 1;
                    } else if (MainVariables.getGameEngine().gameState == 1){
                        MainVariables.playerTap = true;
                    }

                }
                break;
        }
        return true;
    }
}