package com.example.jacob.utpbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jacob on 9/8/2015.
 */


//fun fact: there used to be a qr code reader in this app.

//using this class for the about page now, too lazy to make new one.

public class QRCodeReader extends Fragment{

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.qr_code_reader, container, false);

        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1)
//            if (resultCode == Activity.RESULT_OK) {
//                String contents = data.getStringExtra("SCAN_RESULT");
//                String format = data.getStringExtra("SCAN_RESULT_FORMAT");
//                Tvfoast.makeText(getApplicationContext(), contents, Toast.LENGTH_SHORT).show();
//                // TODO: Do something here with it
//            }// if result_ok
//    }// onactivityresult

//    public void launchReader(View view) {
//
////        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
////        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
////        startActivityForResult(intent, 1);
//
//        Button b = (Button) view;
//        b.setText("clicked");
////        Toast t = Toast.makeText(getContext(), "Toast", Toast.LENGTH_SHORT);
////        t.show();
//
//    }

}
