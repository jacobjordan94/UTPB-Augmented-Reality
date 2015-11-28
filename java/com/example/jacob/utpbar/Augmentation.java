package com.example.jacob.utpbar;

/**
 * Created by jacob on 9/8/2015.
 */
public class Augmentation {

    private String extra;
    public boolean hasExtra;

    public Augmentation(String extra) {
        this.extra = extra;
        this.extra = "augmentations/" + extra + "/index.html";
        hasExtra = true;

    }

    public Augmentation(String extra, boolean b){
        this.extra = extra;
        this.extra = "augmentations/" + extra;
    }

    public boolean isHasExtra() {
        return hasExtra;
    }

    public String getExtra() {
        return extra;
    }


}
