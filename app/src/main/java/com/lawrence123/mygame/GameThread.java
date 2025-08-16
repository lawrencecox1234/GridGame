package com.lawrence123.mygame;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    SurfaceHolder surfaceHolder;
    boolean isRunning;
    long startTime, loopTime;
    long DELAY = 33;

    public GameThread(SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }

    @Override
    public void run() {
        // Looping until the boolean is false
        while(isRunning){
            startTime = SystemClock.uptimeMillis();
            // lock the canvas
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (surfaceHolder){
                    MainVariables.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    MainVariables.getGameEngineBlocks().drawBlock(canvas);
                    MainVariables.getGameEngine().updateAndDrawPlayer(canvas);
                    //MainVariables.getGameEngine().collisionOrExitButton(canvas);
                    MainVariables.getGameEngine().updateAndDrawObstacles(canvas);
                    MainVariables.getGameEngine().collisionCheck();
                    MainVariables.getGameEngine().tapToStart(canvas);
                    // unlock the canvas
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            // loop time
            loopTime = SystemClock.uptimeMillis() - startTime;
            // Pause here to make sure we update the right amount per second
            if(loopTime < DELAY){
                try{
                    Thread.sleep(DELAY - loopTime);
                }catch(InterruptedException e){
                    Log.e("Interrupted","Interrupted while sleeping");
                }
            }
        }
    }

    // Return whether the thread is running
    public boolean isRunning(){
        return isRunning;
    }

    // Sets the thread state, false = stopped, true = running
    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
