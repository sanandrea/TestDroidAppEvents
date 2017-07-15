package com.example.awesomelibrary.ap;

import android.view.ViewGroup;

import com.example.awesomelibrary.ap.events.EventDispatcher;
import com.example.awesomelibrary.ap.events.HasEventDispatcher;
import com.example.awesomelibrary.ap.events.impl.EventDispatcherImpl;
import com.example.awesomelibrary.ap.models.DRMProtection;
import com.example.awesomelibrary.ap.models.HasSettings;
import com.example.awesomelibrary.ap.models.PlayerSettings;
import com.google.gson.Gson;

/**
 * Created by andi on 10/06/17.
 */

public class SimplePlayer implements HasEventDispatcher, HasSettings {
    private ViewGroup mPlayerView;
    private EventDispatcherImpl eventDispatcher;
    public SimplePlayer(ViewGroup playerView){
        mPlayerView = playerView;
        this.eventDispatcher = new EventDispatcherImpl();

        Gson gson = new Gson();
    }

    @Override
    public EventDispatcher asEventDispatcher() {
        return eventDispatcher;
    }

    @Override
    public PlayerSettings asSettings() {
        return new PlayerSettings(1, DRMProtection.PlayReady);
    }
}
