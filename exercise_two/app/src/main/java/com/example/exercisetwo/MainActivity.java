package com.example.exercisetwo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnread, btnwrite;
    EditText editdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnread = (Button) findViewById(R.id.btnreadata);
        btnwrite = (Button)findViewById(R.id.btnwritedata);
        editdata = (EditText) findViewById(R.id.editdata);

        btnread.setOnClickListener(this);
        btnwrite.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.getId()==R.id.btnreadata){
            readData();
        }
        else if(v.getId()==R.id.btnwritedata)
        {
            writeData();
        }
    }

    private void writeData() {
        try {
            FileOutputStream out = openFileOutput("myfile.txt",0);
            OutputStreamWriter writer = new OutputStreamWriter(out);
            writer.write(editdata.getText().toString());
            writer.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void readData() {
        try{
            FileInputStream in = openFileInput("myfile.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String data = "";
            StringBuilder builder = new StringBuilder();
            while((data = reader.readLine())!=null){
                builder.append(data);
                builder.append("\n");
            }
            in.close();
            editdata.setText(builder.toString());
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}