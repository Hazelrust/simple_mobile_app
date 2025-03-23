package com.example.sirawich_478;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class SongActivity extends Activity {
    MediaPlayer songPlayer;
    ListView songListView;
    ArrayList<String> songList;
    ArrayAdapter songAdapter;
    int resId, songNo;
    ImageButton song_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        songListView = findViewById(R.id.contact_listview);
        ImageButton song_back = (ImageButton) findViewById(R.id.song_back_button);
        ImageButton play = (ImageButton) findViewById(R.id.playButton);
        ImageButton stop = (ImageButton) findViewById(R.id.stopButton);
        songList = new ArrayList<String>();
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            songList.add(fields[i].getName());
        }

        songAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, songList);

        songListView.setAdapter(songAdapter);
        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (songPlayer != null) {
                    songPlayer.release();
                }
                songNo = i;
                Log.d("my_tag","songNo="+songNo);
                resId = getResources().getIdentifier(songList.get(i), "raw", getPackageName());
                songPlayer = MediaPlayer.create(SongActivity.this, resId);
                songPlayer.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (songPlayer != null) {
                    songPlayer.release();
                }

            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (songPlayer != null) {
                    songPlayer.release();
                }
                songPlayer = MediaPlayer.create(SongActivity.this, resId);
                songPlayer.start();
            }
        });
        song_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SongActivity.this, MainActivity.class);
                // set the new task and clear flags
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });



    }

}

