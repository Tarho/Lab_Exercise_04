package com.example.exerciseone;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final EditText editdata = (EditText) findViewById(R.id.editdata);

        final Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data;
                InputStream in = getResources().openRawResource(R.raw.myfile);
                InputStreamReader inreader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(inreader);
                StringBuilder builder = new StringBuilder();
                if(in!=null){
                    try {
                        while((data=bufferedReader.readLine())!=null)
                        {
                            builder.append(data);
                            builder.append("\n");
                        }
                        in.close();
                        editdata.setText(builder.toString());
                    }
                    catch (IOException Ex)
                    {
                        Log.e("Error", Ex.getMessage());
                    }
                }
            }
        });
    }
}