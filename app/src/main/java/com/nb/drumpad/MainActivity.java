package com.nb.drumpad;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String LOG_TAG = "DrumpadLog";
    String resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                playSound("kick");
                break;
            case R.id.btn2:
                playSound("snare");
                break;
            case R.id.btn3:
                playSound("tom1");
                break;
            case R.id.btn4:
                playSound("tom3");
                break;
            case R.id.btn5:
                playSound("crash");
                break;
            case R.id.btn6:
                playSound("bell");
                break;
            case R.id.btn7:
                playSound("hhclose");
                break;
            case R.id.btn8:
                playSound("hhopen");
                break;
        }
    }

    public void playSound(String resources) {
//        String resources = "kick";
//        new Thread() {
//            public void run() {
        try {
            MediaPlayer mp = new MediaPlayer();
            Uri uri = Uri.parse("android.resource://com.nb.drumpad/raw/" + resources);
            mp.setDataSource(getApplicationContext(), uri);
            mp.setLooping(false);
            mp.prepare();
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
            {
                public void onPrepared(MediaPlayer mp)
                {
                    mp.start();
                }
            });

            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                public void onCompletion(MediaPlayer mp)
                {
                    mp.release();
                }
            });
        }
        catch (IOException e){
            Log.e(LOG_TAG,"prepare() failed");
//            }.start();
        }
    }



//MediaPlayed mp = MediaPlayer.create(MainActivity.this, resources)'
//mp.start();

}
