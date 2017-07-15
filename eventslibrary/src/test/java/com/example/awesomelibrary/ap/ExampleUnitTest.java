package com.example.awesomelibrary.ap;

import com.example.awesomelibrary.ap.events.PlayerEventListener;
import com.example.awesomelibrary.ap.events.impl.EventDispatcherImpl;
import com.example.awesomelibrary.ap.events.impl.MediaLoadEvent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private CountDownLatch lock = new CountDownLatch(1);
    int data;
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void events_areFired() throws Exception{
        EventDispatcherImpl eventDispatcher = new EventDispatcherImpl();
        eventDispatcher.addEventListener(MediaLoadEvent.getAssociatedType(), new PlayerEventListener<MediaLoadEvent>() {
            @Override
            public void onPlayerEvent(MediaLoadEvent param) {
                System.out.println("event arrived");
                data = param.getValue();
            }
        });
        lock.await(4000, TimeUnit.MILLISECONDS);
        assertNotEquals(data,0);
    }
}