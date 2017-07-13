package com.example.thineventswrapper.wrapper.events;

import com.example.thineventswrapper.wrapper.events.data.PlayerEventListenerWrapper;

/**
 * Created by andi on 13/07/17.
 */

public interface EventDispatcherWrapper {
    ListenerRegistrationWrapper addEventListener(PlayerEventListenerWrapper handler);
}
