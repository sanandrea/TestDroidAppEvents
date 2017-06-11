package com.example.awesomelibrary.andi.Events.impl;

import com.example.awesomelibrary.andi.Events.EventDispatcher;
import com.example.awesomelibrary.andi.Events.ListenerRegistration;
import com.example.awesomelibrary.andi.Events.PlayerEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andi on 10/06/17.
 */

public class EventDispatcherImpl implements EventDispatcher {
    private final Map<PlayerEvent.Type<?>, List<?>> handlerMap = new HashMap();


    public EventDispatcherImpl(){
            Runnable r = new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                        MediaLoadEvent mle = new MediaLoadEvent(42);
                        fireEvent(mle);
                        Thread.sleep(2000);
                        MediaUnloadEvent mue = new MediaUnloadEvent(3);
                        fireEvent(mue);
                    }catch (InterruptedException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            };
            new Thread(r).start();
    }
    private <H> List<H> getHandlerList(PlayerEvent.Type<H> type){
        List<H> l = (List)handlerMap.get(type);
        if (l == null){
            l = new ArrayList<>();
            handlerMap.put(type, l);
        }
        return l;
    }
    private <H> void addEventToListType(PlayerEvent.Type<H> type, H handler){
        List<H> l = getHandlerList(type);
        l.add(handler);
    }

    private <H> boolean removeEventFromList(PlayerEvent.Type<H> type, H handler){
        List<H> l = getHandlerList(type);
        return l.remove(handler);
    }

    private <H> void fireEvent(PlayerEvent<H> event){
        System.out.println("Trying to fire an event");
        List<H> l = getHandlerList(event.getType());
        System.out.println(l.size());
        for(H h : l){
            try {
                System.out.println("firing an event for type" + event.getType());
                event.dispatch(h);
            }catch (Throwable e){
                System.out.println("Event firing failed: " + e.getMessage());
            }
        }
    }

    public <H> ListenerRegistration addEventListener(final PlayerEvent.Type<H> type, final H handler){
        addEventToListType(type,handler);
        return new ListenerRegistration(){
            @Override
            public void remove() {
                removeEventFromList(type,handler);
            }
        };
    }
}
