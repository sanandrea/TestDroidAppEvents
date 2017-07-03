package com.example.awesomelibrary.andi.events;

/**
 * Created by andi on 10/06/17.
 */

public interface PlayerEventListener<E extends PlayerEvent> {
    public void onPlayerEvent(E param);
}
