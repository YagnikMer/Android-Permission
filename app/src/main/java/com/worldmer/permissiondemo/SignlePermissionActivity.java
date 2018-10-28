package com.worldmer.permissiondemo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignlePermissionActivity extends AppCompatActivity {

    Button btnCheckPermission;
    int isPermissionGranted = PackageManager.PERMISSION_DENIED;
    boolean isDontShowDialog = true;
    Activity activity;
    int REQUEST_CODE=1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        activity = this;
        btnCheckPermission = findViewById(R.id.btnsinglepermission);
        btnCheckPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPermissionGranted = ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE);
                isDontShowDialog=ActivityCompat.shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.READ_PHONE_STATE);
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);

                Log.d("PermissionTest","Status : " +isPermissionGranted);
                Log.d("PermissionTest","Checkbox Show dialog : " +isDontShowDialog);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d("PermissionTest", "Dialog Request : requestCode : " + requestCode + " permissions : "
                + permissions.length + " grantResults : " + grantResults.length);
    }
}
