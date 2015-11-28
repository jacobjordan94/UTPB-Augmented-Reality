package com.example.jacob.utpbar;

import android.content.Intent;
import android.hardware.SensorManager;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

import com.wikitude.architect.ArchitectView;

/**
 * Created by jacob on 10/10/2015.
 */
public class GeneralAugmentation extends AbstractArchitectCamActivity{

    private long lastCalibrationToastShownTimeMillis = System.currentTimeMillis(); //this variable name is atrocious

    /**
     * path to the augmentation of this activity: Relative to the assests-root folder.
     */
    private static String WORLD_PATH;

    @Override
    public String getARchitectWorldPath() {
        return WORLD_PATH;
    }

    @Override
    public String getActivityTitle() {
        return getString(R.string.app_name);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_ar_test;
    }

    @Override
    public int getArchitectViewId() {
        return R.id.architectView;
    }

    @Override
    public String getWikitudeSDKLicenseKey() {
        return WikitudeSDKConstants.WIKITUDE_SDK_KEY;
    }

    //Since we're using a locally hosted augmentation this can always return false.
    @Override
    public ArchitectView.ArchitectUrlListener getUrlListener() {
        return new ArchitectView.ArchitectUrlListener() {
            @Override
            public boolean urlWasInvoked(String s) {
                return false;
            }
        };
    }

    @Override
    public ArchitectViewHolderInterface.ILocationProvider getLocationProvider(final LocationListener locationListener) {
        return new LocationProvider(this, locationListener);
    }

    @Override
    public ArchitectView.SensorAccuracyChangeListener getSensorAccuracyListener() {
        return new ArchitectView.SensorAccuracyChangeListener() {
            @Override
            public void onCompassAccuracyChanged(int accuracy) {
                /* UNRELIABLE = 0, LOW = 1, MEDIUM = 2, HIGH = 3 */
                if ( accuracy < SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM && GeneralAugmentation.this != null && !GeneralAugmentation.this.isFinishing() && System.currentTimeMillis() - GeneralAugmentation.this.lastCalibrationToastShownTimeMillis > 5 * 1000) {
                    Toast.makeText( GeneralAugmentation.this, R.string.compass_accuracy_low, Toast.LENGTH_LONG ).show();
                    GeneralAugmentation.this.lastCalibrationToastShownTimeMillis = System.currentTimeMillis();
                }
            }
        };
    }

    @Override
    public float getInitialCullingDistanceMeters() {
//        may need to be adjusted in case POIs are more than 50km away from user while loading or in JS code (compare 'Ar.Context.scene.cullingDistance')
        return ArchitectViewHolderInterface.CULLING_DISTANCE_DEFAULT_METERS;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        WORLD_PATH = intent.getStringExtra("WORLD_PATH");
//        Toast.makeText(GeneralAugmentation.this, WORLD_PATH, Toast.LENGTH_SHORT).show();


    }

}
