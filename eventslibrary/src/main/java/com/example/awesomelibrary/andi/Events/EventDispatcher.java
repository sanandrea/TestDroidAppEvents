package com.example.awesomelibrary.andi.events;

/**
 * Created by andi on 10/06/17.
 */
public interface EventDispatcher {

    <H> ListenerRegistration addEventListener(PlayerEvent.Type<H> type, H handler);
}
