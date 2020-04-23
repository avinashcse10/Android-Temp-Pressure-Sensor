package com.example.homework19;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.pm.PackageManager;
import android.widget.Toast;
import android.widget.Button;


public class MainActivity extends Activity {
    final private int REQUEST_LOCATION = 121;
    boolean permissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_LOCATION);
        } else {
            permissionGranted = true;
        }
        Button b = (Button) findViewById(R.id.button4);
        b.setEnabled(permissionGranted);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this,
                            "Permission Granted", Toast.LENGTH_SHORT).show();
                    System.out.println("permission granted");
                    permissionGranted = true;
                    Button b = (Button) findViewById(R.id.button4);
                    b.setEnabled(permissionGranted);
                } else {
                    Toast.makeText(MainActivity.this,"Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    public void navigateToTemperatureActivity(View v)
    {
        Intent mIntent = new Intent(this, TemperatureActivity.class);
        startActivity(mIntent);
    }

    public void navigateToPressureAltitudeActivity(View v)
    {
        Intent mIntent = new Intent(this, PressureAltitudeActivity.class);
        startActivity(mIntent);
    }

    public void navigateToHumidityActivity(View v)
    {
        Intent mIntent = new Intent(this, HumidityActivity.class);
        startActivity(mIntent);
    }

    public void navigateToCompareSensorActivity(View v)
    {
        Intent mIntent = new Intent(this, CompareSensorActivity.class);
        startActivity(mIntent);
    }
}

