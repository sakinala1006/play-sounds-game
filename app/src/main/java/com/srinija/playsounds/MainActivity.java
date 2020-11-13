package com.srinija.playsounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    String[] audios = {"doyouspeakenglish", "goodevening","hello","howareyou","ilivein","mynameis","please","welcome"};
    MediaPlayer mediaPlayer;
    boolean counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = false;
    }

    public void clicked(View view)
    {
        if(counter == true)
        {
            mediaPlayer.stop();
            counter = false;
        }
        button = (Button) view;
        String audioName = audios[Integer.parseInt(button.getTag().toString())];

        int resid = getResources().getIdentifier(audioName,"raw","com.srinija.playsounds");

        mediaPlayer = MediaPlayer.create(this,resid);

        mediaPlayer.start();

        counter = true;

        Log.i("playing",Integer.toString(resid));
    }
}