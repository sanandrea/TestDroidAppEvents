package com.example.andi.testdroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.awesomelibrary.ap.events.PlayerEventListener;
import com.example.awesomelibrary.ap.events.impl.MediaLoadEvent;
import com.example.awesomelibrary.ap.SimplePlayer;

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
            public void onPlayerEvent(final MediaLoadEvent param) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("Event: "+param.getValue());
                    }
                });
            }
        });
    }
}
