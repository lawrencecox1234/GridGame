package com.lawrence123.mygame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    GameView gameView;
    FrameLayout frameLayout;
    RelativeLayout relativeLayout;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainVariables.gameActivityContext = this;

        gameView = new GameView(this);
        frameLayout = new FrameLayout(this);
        relativeLayout = new RelativeLayout(this);

        Button buttonExit = new Button(this);
        buttonExit.setText("Exit");
        buttonExit.setId(123456);

        Button buttonShoot = new Button(this);
        buttonShoot.setText("Shoot");
        buttonShoot.setId(789);

        buttonExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainVariables.exitButton = true;
            }
        });

        buttonShoot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(GameActivity.this, "Shoot clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        RelativeLayout.LayoutParams bExit = new RelativeLayout.LayoutParams(400,200);
        RelativeLayout.LayoutParams bShoot = new RelativeLayout.LayoutParams(400,400);
        //LinearLayout.LayoutParams bExit = new LinearLayout.LayoutParams(10, 100);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        relativeLayout.setLayoutParams(params);
        relativeLayout.addView(buttonExit);
        relativeLayout.addView(buttonShoot);

        bExit.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        bExit.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        buttonExit.setLayoutParams(bExit);

        bShoot.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        bShoot.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        buttonShoot.setLayoutParams(bShoot);

        frameLayout.addView(gameView);
        frameLayout.addView(relativeLayout);

        setContentView(frameLayout);

        //relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        //        ViewGroup.LayoutParams.MATCH_PARENT));

        //relativeLayout.addView(gameView);
        //setContentView(relativeLayout);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (MainActivity.mediaPlayer != null){
            MainActivity.mediaPlayer.stop();
            MainActivity.mediaPlayer.release();
            MainActivity.mediaPlayer = null;
        }
    }
}
