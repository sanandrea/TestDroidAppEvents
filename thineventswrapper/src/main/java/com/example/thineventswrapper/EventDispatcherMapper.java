package com.example.thineventswrapper;

import java.util.HashSet;

import com.example.awesomelibrary.andi.SimplePlayer;
import com.example.awesomelibrary.andi.events.ListenerRegistration;
import com.example.awesomelibrary.andi.events.PlayerEventListener;
import com.example.awesomelibrary.andi.events.impl.MediaLoadEvent;
import com.example.awesomelibrary.andi.events.impl.MediaUnloadEvent;
import com.example.thineventswrapper.wrapper.events.EventDispatcherWrapper;
import com.example.thineventswrapper.wrapper.events.ListenerRegistrationWrapper;
import com.example.thineventswrapper.wrapper.events.data.MediaLoadEventWrapper;
import com.example.thineventswrapper.wrapper.events.data.MediaUnLoadEventWrapper;
import com.example.thineventswrapper.wrapper.events.data.PlayerEventListenerWrapper;

import java.util.Set;

/**
 * Created by andi on 13/07/17.
 */

class EventDispatcherMapper implements EventDispatcherWrapper {
    private SimplePlayer player;
    private Set<ListenerRegistration> eventMap;


    EventDispatcherMapper(SimplePlayer player){
        this.player = player;
        eventMap = new HashSet<>();
    }

    @Override
    public ListenerRegistrationWrapper addEventListener(final PlayerEventListenerWrapper handler) {
        eventMap.add(this.player.asEventDispatcher().addEventListener(MediaLoadEvent.getAssociatedType(), new PlayerEventListener<MediaLoadEvent>() {
            @Override
            public void onPlayerEvent(MediaLoadEvent ev) {
                handler.onPlayerEvent(new MediaLoadEventWrapper(ev.getValue()));
            }
        }));

        eventMap.add(this.player.asEventDispatcher().addEventListener(MediaUnloadEvent.getAssociatedType(), new PlayerEventListener<MediaUnloadEvent>() {
            @Override
            public void onPlayerEvent(MediaUnloadEvent ev) {
                handler.onPlayerEvent(new MediaUnLoadEventWrapper(ev.getValue()));
            }
        }));

        return new ListenerRegistrationWrapper() {
            @Override
            public void remove() {
                for (ListenerRegistration l : eventMap){
                    l.remove();
                }
            }
        };
    }
}
