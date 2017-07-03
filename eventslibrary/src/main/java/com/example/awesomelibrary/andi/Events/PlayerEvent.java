package com.example.awesomelibrary.andi.events;

/**
 * Created by andi on 10/06/17.
 */

public abstract class PlayerEvent<H> {
    public abstract void dispatch(H paramH);

    public abstract PlayerEvent.Type<H> getType();


    public static class Type<H>
    {
        private final String eType;
        public Type(String eType){
            this.eType = eType;
        }
        public String toString(){
            return eType;
        }
    }

}
