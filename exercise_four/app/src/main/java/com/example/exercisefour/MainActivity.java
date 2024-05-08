package com.example.exercisefour;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 101;
    Button btnreaddata, btnwritedata;
    EditText editdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnreaddata = findViewById(R.id.btnreaddata);
        btnwritedata = findViewById(R.id.btnwritedata);
        editdata = findViewById(R.id.editdata);

        btnreaddata.setOnClickListener(this);
        btnwritedata.setOnClickListener(this);

        // Request storage permissions at runtime
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnreaddata) {
            readData();
        }
        if (v.getId() == R.id.btnwritedata) {
            writeData();
        }
    }

    private void writeData() {
        String sdcard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/myfile.txt";
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(sdcard));
            writer.write(editdata.getText().toString());
            writer.close();
            Toast.makeText(this, "Data written to file", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData() {
        String sdcard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/myfile.txt";
        try {
            Scanner scan = new Scanner(new File(sdcard));
            StringBuilder data = new StringBuilder();
            while (scan.hasNext()) {
                data.append(scan.nextLine()).append("\n");
            }
            scan.close();
            editdata.setText(data.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, perform your operations
            } else {
                // Permission denied, handle accordingly
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
