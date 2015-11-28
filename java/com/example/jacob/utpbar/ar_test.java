package com.example.jacob.utpbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.hardware.SensorManager;
import android.location.LocationListener;
import android.widget.Toast;

import com.example.jacob.utpbar.R;
import com.wikitude.architect.ArchitectView.ArchitectUrlListener;
import com.wikitude.architect.ArchitectView.SensorAccuracyChangeListener;

import com.wikitude.architect.ArchitectView;

public class ar_test extends AbstractArchitectCamActivity {

    private long lastCalibrationToastShownTimeMillis = System.currentTimeMillis(); //this variable name is atrocious

    /**
     * path to the augmentation of this activity: Relative to the assests-root folder.
     */
    private static final String WORLD_PATH = "augmentations/yuanInfo/index.html";

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
    public ArchitectUrlListener getUrlListener() {
        return new ArchitectUrlListener() {
            @Override
            public boolean urlWasInvoked(String s) {
                return false;
            }
        };
    }

    @Override
    public ILocationProvider getLocationProvider(final LocationListener locationListener) {
        return new LocationProvider(this, locationListener);
    }

    @Override
    public SensorAccuracyChangeListener getSensorAccuracyListener() {
        return new SensorAccuracyChangeListener() {
            @Override
            public void onCompassAccuracyChanged(int accuracy) {
                /* UNRELIABLE = 0, LOW = 1, MEDIUM = 2, HIGH = 3 */
                if ( accuracy < SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM && ar_test.this != null && !ar_test.this.isFinishing() && System.currentTimeMillis() - ar_test.this.lastCalibrationToastShownTimeMillis > 5 * 1000) {
                    Toast.makeText( ar_test.this, R.string.compass_accuracy_low, Toast.LENGTH_LONG ).show();
                    ar_test.this.lastCalibrationToastShownTimeMillis = System.currentTimeMillis();
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
        Toast.makeText(ar_test.this, WORLD_PATH, Toast.LENGTH_SHORT).show();
    }
}