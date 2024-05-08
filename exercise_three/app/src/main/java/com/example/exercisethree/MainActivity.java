package com.example.exercisethree;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button btnchangeprofilephoto, btnsave, btncancelandread;
    EditText editname, editemail, editphone;
    RadioButton male, female;

    private static final int CAMERA_REQUESTED_CODE = 1001;
    private static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnchangeprofilephoto = findViewById(R.id.btnchangeprofilephoto);
        btnsave = findViewById(R.id.btnsave);
        editname = findViewById(R.id.editname);
        editemail = findViewById(R.id.editemal);
        editphone = findViewById(R.id.editphone);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        btncancelandread = findViewById(R.id.cancelandread);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        }

        btnchangeprofilephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUESTED_CODE);
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeData();
            }
        });

        btncancelandread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAction();
            }
        });

        // Read data when activity is created
        readData();
    }

    private void writeData() {
        String sdcard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/userinfo.txt";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(sdcard));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            outputStreamWriter.write(editname.getText().toString() + "\n");
            outputStreamWriter.write(editemail.getText().toString() + "\n");
            outputStreamWriter.write(editphone.getText().toString() + "\n");

            // Save the selected gender
            SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            if (male.isChecked()) {
                editor.putString("gender", "male");
            } else if (female.isChecked()) {
                editor.putString("gender", "female");
            }
            editor.apply();

            outputStreamWriter.close();
            Toast.makeText(this, "Data written to file", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData() {
        String sdcard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/userinfo.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(sdcard));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String name = bufferedReader.readLine();
            String email = bufferedReader.readLine();
            String phone = bufferedReader.readLine();

            editname.setText(name);
            editemail.setText(email);
            editphone.setText(phone);

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Restore the selected gender
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String gender = preferences.getString("gender", "");
        if (gender.equals("male")) {
            male.setChecked(true);
        } else if (gender.equals("female")) {
            female.setChecked(true);
        }
    }


    private void cancelAction() {
        // Close the app
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUESTED_CODE) {
            if (resultCode == RESULT_OK) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                // Set the bitmap to your ImageView
                ImageView imageView = findViewById(R.id.profilephoto);
                imageView.setImageBitmap(bitmap);
            }
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
