package com.example.awesomelibrary.ap.events.impl;

import com.example.awesomelibrary.ap.events.PlayerEvent;
import com.example.awesomelibrary.ap.events.PlayerEventListener;

/**
 * Created by andi on 10/06/17.
 */

public class MediaLoadEvent extends PlayerEvent<PlayerEventListener<MediaLoadEvent>> {
    private final int value;

    public MediaLoadEvent(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    static PlayerEvent.Type<PlayerEventListener<MediaLoadEvent>> TYPE = new PlayerEvent.Type("LoadEvent");

    public static PlayerEvent.Type<PlayerEventListener<MediaLoadEvent>> getAssociatedType(){
        return TYPE;
    }
    public PlayerEvent.Type<PlayerEventListener<MediaLoadEvent>> getType(){
        return TYPE;
    }
    public void dispatch(PlayerEventListener<MediaLoadEvent> listener){
        listener.onPlayerEvent(this);
    }
}
