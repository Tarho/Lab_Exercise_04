package com.example.movies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetailmovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);

        String name = getIntent().getStringExtra("NAME");
        String backgroundpicture = getIntent().getStringExtra("BACKGROUNDPICTURE");
        String picture = getIntent().getStringExtra("PICTURE");
        String description = getIntent().getStringExtra("DESCRIPTION");
        String videoUrl = getIntent().getStringExtra("VIDEO");

        TextView nameText = findViewById(R.id.name);
        ImageView backgroundpictureText = findViewById(R.id.backgroundpicture);
        ImageView pictureText = findViewById(R.id.picture);
        TextView descriptionText = findViewById(R.id.description);
        Button openVideoButton = findViewById(R.id.open_video_button);

        nameText.setText(name);
        descriptionText.setText(description);

        // Load background picture
        Picasso.get().load(backgroundpicture).into(backgroundpictureText, new Callback() {
            @Override
            public void onSuccess() {
                // Image loaded successfully
            }

            @Override
            public void onError(Exception e) {
                // Handle error
                e.printStackTrace();
            }
        });

        // Load picture
        Picasso.get().load(picture).into(pictureText, new Callback() {
            @Override
            public void onSuccess() {
                // Image loaded successfully
            }

            @Override
            public void onError(Exception e) {
                // Handle error
                e.printStackTrace();
            }
        });

        // Set a click listener for the button to open the video
        openVideoButton.setOnClickListener(view -> {
            // Open the video using an intent
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
            startActivity(intent);
        });
    }
}
