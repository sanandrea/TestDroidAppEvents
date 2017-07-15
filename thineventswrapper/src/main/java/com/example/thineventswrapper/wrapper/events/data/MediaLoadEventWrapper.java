package com.example.thineventswrapper.wrapper.events.data;

import com.example.awesomelibrary.ap.events.impl.MediaLoadEvent;

/**
 * Created by andi on 13/07/17.
 */

public class MediaLoadEventWrapper {
    private MediaLoadEvent event;
    public MediaLoadEventWrapper(MediaLoadEvent ev){
        this.event = ev;
    }
    public int getValue(){return event.getValue();}
}
