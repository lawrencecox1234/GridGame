package com.lawrence123.mygame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import java.util.ArrayList;
import java.util.Random;

public class GameEngineMain {

    Player player;
    Random random;
    int score;
    Paint scorePaint;
    static int gameState;

    Obstacles obstacle1;
    Obstacles obstacle2;
    Obstacles obstacle3;
    Obstacles obstacle4;

    Bitmap obs;
    int points;
    final int TEXT_SIZE = 80;
    boolean collision = false;

    private final static int MAX_VOLUME = 100;
    int soundVolume = 100;
    MediaPlayer hit;
    MediaPlayer move;
    boolean hitSound;

    public GameEngineMain() {
        player = new Player();
        // 0 = Not started
        // 1 = Playing
        // 2 = GameOver
        gameState = 0;
        random = new Random();
        score = 0;
        scorePaint = new Paint();
        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(TEXT_SIZE);
        scorePaint.setTextAlign(Paint.Align.LEFT);

        obstacle1 = new Obstacles("One");
        obstacle2 = new Obstacles("Two");
        obstacle3 = new Obstacles("Three");
        obstacle4 = new Obstacles("Four");

        points = 0;
        hitSound = false;
        hit = MediaPlayer.create(MainVariables.gameActivityContext, R.raw.hit);

        move = MediaPlayer.create(MainVariables.gameActivityContext, R.raw.jump);
        final float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));
        move.setVolume(volume, volume);
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {

        canvas.drawBitmap(MainVariables.getBitmapAsset().getBackground(), 0, 0, null);

    }

    public void updateAndDrawPlayer(Canvas canvas) {
        if (gameState == 1) {

            // The player has reached the end, do point increment and restart player position to the left
            if (MainVariables.exitButton == false && collision == false && MainVariables.playerPosition.playerPositionX >= 6) {

                points++;

                player.setX(75);
                player.setY(20);
                canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowRight(), player.getX(), player.getY(), null);

                MainVariables.playerPosition.setPlayerPositionX(1);
                MainVariables.playerPosition.setPlayerPositionY(1);

                MainVariables.reachedEnd = true;

            } else if (MainVariables.exitButton == false && MainVariables.playerMoveRight == true && collision == false) {

                canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowRight(), player.getX(), player.getY(), null);

                if (MainVariables.playerTap == true){

                    move.start();

                    // Ensure that the arrow doesn't move off the screen
                    if (player.getX() + MainVariables.playerShiftHorizontal <= MainVariables.SCREEN_WIDTH) {
                        player.setX(player.getX() + MainVariables.playerShiftHorizontal);
                        canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowRight(), player.getX(), player.getY(), null);
                    }
                    MainVariables.playerTap = false;

                    MainVariables.playerPosition.playerMoveRight();
                    //System.out.println("X: " + MainVariables.playerPosition.getPlayerPositionX());
                    //System.out.println("Y: " + MainVariables.playerPosition.getPlayerPositionY());

                }

            } else if (MainVariables.exitButton == false && MainVariables.playerMoveLeft == true && collision == false) {

                canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowLeft(), player.getX(), player.getY(), null);

                if (MainVariables.playerTap == true) {

                    move.start();

                    // Ensure that the arrow doesn't move off the screen
                    if (player.getX() - MainVariables.playerShiftHorizontal >= 0) {
                        player.setX(player.getX() - MainVariables.playerShiftHorizontal);
                        canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowLeft(), player.getX(), player.getY(), null);
                    }
                    MainVariables.playerTap = false;

                    MainVariables.playerPosition.playerMoveLeft();
                    //System.out.println("X: " + MainVariables.playerPosition.getPlayerPositionX());
                    //System.out.println("Y: " + MainVariables.playerPosition.getPlayerPositionY());

                }

            } else if (MainVariables.exitButton == false && MainVariables.playerMoveDown == true && collision == false) {

                canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowDown(), player.getX(), player.getY(), null);

                if (MainVariables.playerTap == true) {

                    move.start();

                    if (player.getY() + MainVariables.playerShiftVertical <= MainVariables.SCREEN_HEIGHT) {
                        player.setY(player.getY() + MainVariables.playerShiftVertical);
                        canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowDown(), player.getX(), player.getY(), null);
                    }
                    MainVariables.playerTap = false;

                    MainVariables.playerPosition.playerMoveDown();
                    //System.out.println("X: " + MainVariables.playerPosition.getPlayerPositionX());
                    //System.out.println("Y: " + MainVariables.playerPosition.getPlayerPositionY());

                }

            } else if (MainVariables.exitButton == false && MainVariables.playerMoveUp == true && collision == false) {

                canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowUp(), player.getX(), player.getY(), null);

                if (MainVariables.playerTap == true) {

                    move.start();

                    if (player.getY() - MainVariables.playerShiftVertical > 0) {
                        player.setY(player.getY() - MainVariables.playerShiftVertical);
                        canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowUp(), player.getX(), player.getY(), null);
                    }
                    MainVariables.playerTap = false;

                    MainVariables.playerPosition.playerMoveUp();
                    //System.out.println("X: " + MainVariables.playerPosition.getPlayerPositionX());
                    //System.out.println("Y: " + MainVariables.playerPosition.getPlayerPositionY());

                }

            } else if (MainVariables.exitButton == true || collision == true) {

                canvas.drawBitmap(MainVariables.getBitmapAsset().getRedX(), player.getX(), player.getY(), null);

                if (hitSound == false) {
                    hit.start();
                    hitSound = true;
                } else {
                    gameState = 2;
                    Context context = MainVariables.gameActivityContext;
                    Intent intent = new Intent(context, GameEnd.class);
                    intent.putExtra("game_points", points);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }

            } else {

                // This the case where the player doesn't swipe at all at the start of the game, here we'll default to right movement

                canvas.drawBitmap(MainVariables.getBitmapAsset().getArrowRight(), player.getX(), player.getY(), null);

                MainVariables.playerMoveRight = true;

            }

            canvas.drawText("Score: " + points, 0, TEXT_SIZE, scorePaint);

        }
    }

    public void updateAndDrawObstacles(Canvas canvas) {

        if (gameState == 1) {
            if (collision == false) {

                obstacle1.cY += obstacle1.velocity;
                obstacle2.cY += obstacle2.velocity;
                obstacle3.cY += obstacle3.velocity;
                obstacle4.cY += obstacle4.velocity;

                obs = MainVariables.getBitmapAsset().getBox();

                canvas.drawBitmap(obs, obstacle1.cX, obstacle1.cY, null);
                canvas.drawBitmap(obs, obstacle2.cX, obstacle2.cY, null);
                canvas.drawBitmap(obs, obstacle3.cX, obstacle3.cY, null);
                canvas.drawBitmap(obs, obstacle4.cX, obstacle4.cY, null);

                if (obstacle1.cY >= MainVariables.SCREEN_HEIGHT + 0) {
                    obstacle1.reset();
                }

                if (obstacle2.cY >= MainVariables.SCREEN_HEIGHT + 0) {
                    obstacle2.reset();
                }

                if (obstacle3.cY >= MainVariables.SCREEN_HEIGHT + 0) {
                    obstacle3.reset();
                }

                if (obstacle4.cY >= MainVariables.SCREEN_HEIGHT + 0) {
                    obstacle4.reset();
                }

            }
        }
    }

    public void collisionCheck(){

        if (((player.pX + MainVariables.getBitmapAsset().getArrowUpWidth() >= obstacle1.cX) && (player.pX <= obstacle1.cX + obstacle1.width))
                && ((player.pY + MainVariables.getBitmapAsset().getArrowUpHeight() >= obstacle1.cY) && (player.pY <= obstacle1.cY + obstacle1.height))) {

            collision = true;
        }

        if (((player.pX + MainVariables.getBitmapAsset().getArrowUpWidth() >= obstacle2.cX) && (player.pX <= obstacle2.cX + obstacle2.width))
                && ((player.pY + MainVariables.getBitmapAsset().getArrowUpHeight() >= obstacle2.cY) && (player.pY <= obstacle2.cY + obstacle2.height))) {

            collision = true;
        }

        if (((player.pX + MainVariables.getBitmapAsset().getArrowUpWidth() >= obstacle3.cX) && (player.pX <= obstacle3.cX + obstacle3.width))
                && ((player.pY + MainVariables.getBitmapAsset().getArrowUpHeight() >= obstacle3.cY) && (player.pY <= obstacle3.cY + obstacle3.height))) {

            collision = true;
        }

        if (((player.pX + MainVariables.getBitmapAsset().getArrowUpWidth() >= obstacle4.cX) && (player.pX <= obstacle4.cX + obstacle4.width))
                && ((player.pY + MainVariables.getBitmapAsset().getArrowUpHeight() >= obstacle4.cY) && (player.pY <= obstacle4.cY + obstacle4.height))) {

            collision = true;
        }

    }

    public void tapToStart(Canvas canvas){
        if(MainVariables.getGameEngine().gameState == 0){
            canvas.drawBitmap(MainVariables.getBitmapAsset().getTapToStart(), MainVariables.SCREEN_WIDTH/2 - MainVariables.getBitmapAsset().getTapToStartWidth()/2, MainVariables.SCREEN_HEIGHT/2 - MainVariables.getBitmapAsset().getTapToStartHeight()/2, null);
        }
    }
}
