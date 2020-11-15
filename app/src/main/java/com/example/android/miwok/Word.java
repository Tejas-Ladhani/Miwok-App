package com.example.android.miwok;

public class Word {
    private String translateEng;
    private String translateMiwok;
    private static final int HAS_NO_IMAGE = -1;
    private int resourceId = HAS_NO_IMAGE;

    // consider it as a address os house , we dont the actual  house to be stored in out app.
    //we will access the images with their ids which are of int type.
    private int AudioRId;
    // -1 , because its out the range of the values that any id can have .

    //For phrases
    Word(String translateEng, String translateMiwok) {
        this.translateEng = translateEng;
        this.translateMiwok = translateMiwok;
    }

    //for other three activities.


    Word(String translateEng, String translateMiwok, int AudioRId) {
        this.translateEng = translateEng;
        this.translateMiwok = translateMiwok;
        this.AudioRId = AudioRId;
    }

    Word(String translateEng, String translateMiwok, int resourceId, int AudioRId) {
        this.translateEng = translateEng;
        this.translateMiwok = translateMiwok;
        this.resourceId = resourceId;
        this.AudioRId = AudioRId;
    }


    public String getEngTanslation() {
        return translateEng;
    }

    public String getTranslateMiwok() {
        return translateMiwok;
    }

    public int getResourceId() {
        return resourceId;
    }

    public int getAudioRId() {
        return AudioRId;
    }

    public boolean hasImage() {
        return resourceId != HAS_NO_IMAGE;
    }
}
