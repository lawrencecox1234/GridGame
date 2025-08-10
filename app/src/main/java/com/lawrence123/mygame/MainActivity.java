package com.lawrence123.mygame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    static MediaPlayer mediaPlayer;
    ImageButton ibStartGame;
    private final static int MAX_VOLUME = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int soundVolume = 70;
        MainActivity.mediaPlayer = MediaPlayer.create(this, R.raw.bg_music);
        final float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));
        mediaPlayer.setVolume(volume, volume);
        if (MainActivity.mediaPlayer != null){
            MainActivity.mediaPlayer.setLooping(true);
            MainActivity.mediaPlayer.start();
        }
        MainVariables.initialization(this.getApplicationContext());
        ibStartGame = findViewById(R.id.ibStartGame);
        ibStartGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed(){
        if (MainActivity.mediaPlayer != null){
            MainActivity.mediaPlayer.stop();
            MainActivity.mediaPlayer.release();
            MainActivity.mediaPlayer = null;
        }
        super.onBackPressed();
    }
}