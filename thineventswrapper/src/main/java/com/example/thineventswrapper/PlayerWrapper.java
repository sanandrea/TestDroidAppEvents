package com.example.thineventswrapper;

import android.view.ViewGroup;

import com.example.awesomelibrary.andi.SimplePlayer;
import com.example.awesomelibrary.andi.models.HasSettings;
import com.example.awesomelibrary.andi.models.PlayerSettings;
import com.example.thineventswrapper.wrapper.events.EventDispatcherWrapper;
import com.example.thineventswrapper.wrapper.events.HasEventDispatcherWrapper;

/**
 * Created by andi on 13/07/17.
 */

public class PlayerWrapper implements HasEventDispatcherWrapper, HasSettings {
    private SimplePlayer player;
    private EventDispatcherWrapper eventDispatcher;

    public PlayerWrapper(ViewGroup playerView){
        player = new SimplePlayer(playerView);
        eventDispatcher = new EventDispatcherMapper(player);
    }

    @Override
    public PlayerSettings asSettings() {
        return player.asSettings();
    }

    @Override
    public EventDispatcherWrapper asEventDispatcherWrapper() {
        return eventDispatcher;
    }
}
