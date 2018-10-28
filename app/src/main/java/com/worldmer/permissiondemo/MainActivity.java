package com.worldmer.permissiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSinglePermission, btnMultiplePermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSinglePermission = findViewById(R.id.btnsinglepermission);
        btnMultiplePermission = findViewById(R.id.btnmultiplepermission);
        btnSinglePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignlePermissionActivity.class));
            }
        });
        btnMultiplePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MultiplePermissionActivity.class));
            }
        });
    }
}
