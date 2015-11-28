package com.example.jacob.utpbar;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.net.URI;
//import com.google.zxing.*;

public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, FalconVision.OnFragmentInteractionListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private static final String TAG = "Jacob logging";
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        Log.i(TAG, "=====================================");
        Log.i(TAG, "OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart");
//        returnAugmentations();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {

        boolean isActivity = false;

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AugmentationFragment();
                break;
            case 1:
                fragment = new BuildingLocator();
//                isActivity = true;
                break;
            case 2:
                fragment = new FalconVision().newInstance();
                break;
            case 3:
                fragment = new QRCodeReader();
                break;
            default:
                Toast.makeText(getApplicationContext(), "This should not be reached", Toast.LENGTH_SHORT).show();
                break;
        }

        if(!isActivity) {
            // update the main content by replacing fragments
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, GeneralAugmentation.class);
            intent.putExtra("WORLD_PATH", "augmentations/hardPOI/index.html");
//            intent.putExtra("WORLD_PATH", "augmentations/links/index.html");
            startActivity(intent);
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    private void returnAugmentations() {
//        AssetManager mngr = getAssets();
//        String[] folders = null;
//
//        try {
//            folders = mngr.list("augmentations");
//        } catch (IOException ioex) {
//            Log.i(TAG, "IOEXCEPTION");
//        }
//
//       for(String folder : folders){
//           Log.i(TAG, "folder: " + folder);
//       }
//
//      //  mngr.close();
//    }

    public void launchReader(View view) {

//        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
//        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
//        startActivityForResult(intent, 0);

    }

    public void launchAug1(View view) {
        Augmentation augmentation = new Augmentation("logo"); //wont be used in app, test augmentation
        launchAugmentation(view, augmentation);
    }

    public void launchAug2(View view) {
        Augmentation augmentation = new Augmentation("links");
        launchAugmentation(view, augmentation);
    }

    public void launchFalconVisionSmall(View view) {
        Augmentation augmentation = new Augmentation("falconvisionSM");
        launchAugmentation(view, augmentation);
    }

    public void launchFalconVisionMedium(View view) {
        Augmentation augmentation = new Augmentation("falconvisionMED");
        launchAugmentation(view, augmentation);
    }

    public void launchFalconVisionLarge(View view) {
        Augmentation augmentation = new Augmentation("falconvisionLG");
        launchAugmentation(view, augmentation);
    }

    public void launchBuildingLocator(View view) {
        Augmentation augmentation = new Augmentation("building");
        launchAugmentation(view, augmentation);
    }

    public void launchAugmentation(View view, Augmentation augmentation){

        Intent intent = new Intent(this, GeneralAugmentation.class);
        intent.putExtra("WORLD_PATH", augmentation.getExtra());
        startActivity(intent);

    }

    public void test(View view) {
        Intent intent = new Intent(this, ar_test.class);
//        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(


                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

    }

}
