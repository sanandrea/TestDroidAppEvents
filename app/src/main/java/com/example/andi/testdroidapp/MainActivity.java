package com.example.andi.testdroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.awesomelibrary.andi.Events.PlayerEvent;
import com.example.awesomelibrary.andi.Events.PlayerEventListener;
import com.example.awesomelibrary.andi.Events.impl.MediaLoadEvent;
import com.example.awesomelibrary.andi.SimplePlayer;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.test_label);
        SimplePlayer player = new SimplePlayer((ViewGroup) findViewById(android.R.id.content));
        player.asEventDispatcher().addEventListener(MediaLoadEvent.getAssociatedType(), new PlayerEventListener<MediaLoadEvent>() {
            @Override
            public void onPlayerEvent(MediaLoadEvent param) {
                tv.setText("Event: "+param);
            }
        });
    }
}
