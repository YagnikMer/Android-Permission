package com.worldmer.permissiondemo;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MultiplePermissionActivity extends AppCompatActivity {

    Button btnCheckPermission;
    int REQUEST_CODE = 4321;
    String[] permission = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);
        btnCheckPermission = findViewById(R.id.btnmultiplepermission);
        btnCheckPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissions(permission, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i = 0; i < permissions.length; i++) {
            Log.d("PermissionTest", permissions[i] + " : " + grantResults[i]);
            if (grantResults[i] == -1) {
                requestPermissions(permission, REQUEST_CODE);
                break;
            }
        }
    }
}
