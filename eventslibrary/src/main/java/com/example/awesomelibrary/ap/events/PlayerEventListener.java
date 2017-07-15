package com.example.awesomelibrary.ap.events;

/**
 * Created by andi on 10/06/17.
 */

public interface PlayerEventListener<E extends PlayerEvent> {
    public void onPlayerEvent(E param);
}
