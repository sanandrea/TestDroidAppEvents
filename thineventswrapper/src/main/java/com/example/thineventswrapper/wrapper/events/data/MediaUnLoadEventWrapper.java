package com.example.thineventswrapper.wrapper.events.data;

import com.example.awesomelibrary.ap.events.impl.MediaUnloadEvent;

/**
 * Created by andi on 13/07/17.
 */

public class MediaUnLoadEventWrapper {
    private MediaUnloadEvent event;
    public MediaUnLoadEventWrapper(MediaUnloadEvent ev){
        this.event = ev;
    }
    public float getValue(){
        return event.getValue();
    }
}
