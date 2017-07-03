package com.example.awesomelibrary.andi.models;

/**
 * Created by andi on 02/07/17.
 */

public class PlayerSettings {

    private int version;
    private DRMProtection protection;

    public PlayerSettings(int version, DRMProtection protection){
        this.version = version;
        this.protection = protection;
    }

    public int getVersion() {
        return version;
    }
    public DRMProtection getProtection() {
        return protection;
    }
}
