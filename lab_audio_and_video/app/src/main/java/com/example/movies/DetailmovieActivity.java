package com.example.movies;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dictionary.R;
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

        TextView nameText = findViewById(R.id.name);
        ImageView backgroundpictureText = findViewById(R.id.backgroundpicture);
        ImageView pictureText = findViewById(R.id.picture);
        TextView descriptionText = findViewById(R.id.description);

        nameText.setText(name);
        descriptionText.setText(description);

        // Load background picture
        Picasso.get().load(backgroundpicture).into(backgroundpictureText);

        // Load picture
        Picasso.get().load(picture).into(pictureText);
    }
}
