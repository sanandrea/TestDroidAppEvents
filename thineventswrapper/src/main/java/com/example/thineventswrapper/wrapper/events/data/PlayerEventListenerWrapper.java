package com.example.thineventswrapper.wrapper.events.data;

/**
 * Created by andi on 13/07/17.
 */

public interface PlayerEventListenerWrapper {
    void onPlayerEvent(MediaLoadEventWrapper event);
    void onPlayerEvent(MediaUnLoadEventWrapper event);
}
