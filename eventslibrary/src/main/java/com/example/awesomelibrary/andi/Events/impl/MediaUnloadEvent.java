package com.example.awesomelibrary.andi.Events.impl;

import com.example.awesomelibrary.andi.Events.PlayerEvent;
import com.example.awesomelibrary.andi.Events.PlayerEventListener;

/**
 * Created by andi on 10/06/17.
 */

public class MediaUnloadEvent extends PlayerEvent<PlayerEventListener<MediaUnloadEvent>> {
    private final float value;

    public MediaUnloadEvent(float value){
        this.value = value;
    }

    public float getValue(){
        return value;
    }

    static PlayerEvent.Type<PlayerEventListener<MediaUnloadEvent>> TYPE = new PlayerEvent.Type("UnloadEvent");
    public static PlayerEvent.Type<PlayerEventListener<MediaUnloadEvent>> getAssociatedType(){
        return TYPE;
    }
    public PlayerEvent.Type<PlayerEventListener<MediaUnloadEvent>> getType(){
        return TYPE;
    }
    public void dispatch(PlayerEventListener<MediaUnloadEvent> listener){
        listener.onPlayerEvent(this);
    }
}
