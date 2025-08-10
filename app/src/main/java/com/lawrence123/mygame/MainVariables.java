package com.lawrence123.mygame;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class MainVariables {

    static BitmapAssets bitmapAssets;
    static GameEngineMain gameEngine;
    static GameEngineBlocks gameEngineBlocks;
    static PlayerPosition playerPosition;

    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int VELOCITY_OBSTACLES;
    static Context gameActivityContext;

    static boolean exitButton;

    static boolean playerMoveRight;
    static boolean playerMoveLeft;
    static boolean playerMoveUp;
    static boolean playerMoveDown;
    static boolean playerTap;

    static boolean reachedEnd;

    static int playerShiftHorizontal;
    static int playerShiftVertical;

    public static void initialization(Context context){
        getScreenSize(context);
        MainVariables.gameActivityContext = context;
        bitmapAssets = new BitmapAssets(context.getResources());
        setGameConstants();
        gameEngine = new GameEngineMain();
        playerPosition = new PlayerPosition();
        gameEngineBlocks = new GameEngineBlocks();
    }

    public static void getScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        MainVariables.SCREEN_WIDTH = width;
        MainVariables.SCREEN_HEIGHT = height;
    }

    public static void setGameConstants(){
        MainVariables.VELOCITY_OBSTACLES = 6;
        MainVariables.exitButton = false;
        MainVariables.playerMoveRight = false;
        MainVariables.playerMoveLeft = false;
        MainVariables.playerMoveUp = false;
        MainVariables.playerMoveDown = false;
        MainVariables.playerTap = false;
        MainVariables.reachedEnd = false;
        MainVariables.playerShiftHorizontal = MainVariables.SCREEN_WIDTH/6;
        MainVariables.playerShiftVertical = MainVariables.SCREEN_HEIGHT/4;
    }

    // Return BitmapAsset instance
    public static BitmapAssets getBitmapAsset(){
        return bitmapAssets;
    }

    // Return GameEngine instance
    public static GameEngineMain getGameEngine(){
        return gameEngine;
    }

    public static GameEngineBlocks getGameEngineBlocks(){
        return gameEngineBlocks;
    }
}
