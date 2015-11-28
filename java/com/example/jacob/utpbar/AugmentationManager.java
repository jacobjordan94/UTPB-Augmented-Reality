package com.example.jacob.utpbar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by jacob on 9/8/2015.
 */
public class AugmentationManager {

    private Augmentation currentAug;
    private String[] augmentationLocations;
    private Augmentation[] augmentations;

    public AugmentationManager(String augmentationsLocation) {

        grabAugmentations(augmentationsLocation);

    }


    private void grabAugmentations(String augmentationLocations) {

    //    BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open(augmentationLocations)));

    }

}
