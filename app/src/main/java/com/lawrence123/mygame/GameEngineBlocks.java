package com.lawrence123.mygame;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GameEngineBlocks {

    StaticBlock staticBlock1;
    StaticBlock staticBlock2;
    StaticBlock staticBlock3;
    StaticBlock staticBlock4;

    ArrayList<StaticBlock> staticBlocks = new ArrayList<StaticBlock>();

    int[] blockPixelX = new int[5];
    int[] blockPixelY = new int[5];

    Set<Integer> allXPositions;
    Set<Integer> allYPositions;

    Set<Integer> notValidX = new HashSet<>(Arrays.asList(1,2,3,4));
    Set<Integer> notValidY = new HashSet<>(Arrays.asList(0,1,2,3));
    Set<Integer> notValidY2 = new HashSet<>(Arrays.asList(3,2,1,0));

    boolean randomPositionsDone;

    public GameEngineBlocks (){

        staticBlock1 = new StaticBlock(1);
        staticBlock2 = new StaticBlock(2);
        staticBlock3 = new StaticBlock(3);
        staticBlock4 = new StaticBlock(4);

        staticBlocks.add(staticBlock1);
        staticBlocks.add(staticBlock2);
        staticBlocks.add(staticBlock3);
        staticBlocks.add(staticBlock4);

        for (int i = 0; i < 5; i++){
            blockPixelX[i] = MainVariables.playerShiftHorizontal*i;
        }

        for (int i = 0; i < 4; i++){
            blockPixelY[i] = MainVariables.playerShiftVertical*i;
        }

    }

    public int getStaticBlockPositionX(int i){

        return staticBlocks.get(i).getX();

    }

    public int getStaticBlockPositionY(int i){

        return staticBlocks.get(i).getY();

    }

    public void generateRandomPositions(){

        allXPositions = new HashSet<Integer>();
        allYPositions = new HashSet<Integer>();

        for (int i = 0; i < 4; i++){

            int blockX = i + 1;

            Random randomY = new Random();
            int blockY = randomY.nextInt(4);

            allXPositions.add(blockX);
            allYPositions.add(blockY);

            staticBlocks.get(i).setX(blockX);
            staticBlocks.get(i).setY(blockY);
        }

        // Checking if the blocks aren't diagonal from top left to bottom right or bottom left to top right
        // We don't want these positions as player will be unable to pass them

        if ( (allXPositions.equals(notValidX) && allYPositions.equals(notValidY)) ||
                (allXPositions.equals(notValidX) && allYPositions.equals(notValidY2))) {
            randomPositionsDone = false;
        } else {
            randomPositionsDone = true;
        }

    }

    public void drawBlock(Canvas canvas) {

        if (MainVariables.getGameEngine().gameState == 1) {

            if (MainVariables.reachedEnd == true) {

                randomPositionsDone = false;

                while (!randomPositionsDone) {
                    generateRandomPositions();
                }

                MainVariables.reachedEnd = false;
            }

            for (int i = 0; i < 4; i++) {
                int newX = blockPixelX[getStaticBlockPositionX(i)];
                int newY = blockPixelY[getStaticBlockPositionY(i)];

                canvas.drawBitmap(MainVariables.getBitmapAsset().getIceBox(), newX + 100, newY + 50, null);
            }

        }

    }

}
