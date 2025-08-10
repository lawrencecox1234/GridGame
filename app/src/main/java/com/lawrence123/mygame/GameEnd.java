package com.lawrence123.mygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameEnd extends AppCompatActivity {

    TextView gameScore, personalBestScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_end);

        int gamePoints = getIntent().getExtras().getInt("game_points");
        SharedPreferences preference1 = getSharedPreferences("Preference1", 0);

        int personalBest = preference1.getInt("personalBest",0);
        SharedPreferences.Editor editor = preference1.edit();

        if (gamePoints > personalBest){
            personalBest = gamePoints;
            editor.putInt("personalBest", personalBest);
            editor.commit();
        }

        gameScore = findViewById(R.id.gameScore);
        personalBestScore = findViewById(R.id.personalBestScore);

        gameScore.setText("" + gamePoints);
        personalBestScore.setText("" + personalBest);

    }

    public void restart_game(View view) {

        Intent intent = new Intent(GameEnd.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void exit_game(View view) {

        finish();

    }

}
