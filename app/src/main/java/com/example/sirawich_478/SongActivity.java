package com.example.sirawich_478;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SongActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        MediaPlayer mPlayer = MediaPlayer.create(SongActivity.this,
                R.raw.oertheflood);
        mPlayer.start();
    }
}
