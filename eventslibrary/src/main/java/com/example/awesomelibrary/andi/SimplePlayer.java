package com.example.awesomelibrary.andi;

import android.view.ViewGroup;

import com.example.awesomelibrary.andi.Events.EventDispatcher;
import com.example.awesomelibrary.andi.Events.HasEventDispatcher;
import com.example.awesomelibrary.andi.Events.impl.EventDispatcherImpl;

/**
 * Created by andi on 10/06/17.
 */

public class SimplePlayer implements HasEventDispatcher{
    private ViewGroup mPlayerView;
    private EventDispatcherImpl eventDispatcher;
    public SimplePlayer(ViewGroup playerView){
        mPlayerView = playerView;
        this.eventDispatcher = new EventDispatcherImpl();
    }

    @Override
    public EventDispatcher asEventDispatcher() {
        return eventDispatcher;
    }
}
