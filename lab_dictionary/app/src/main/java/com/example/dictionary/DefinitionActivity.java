package com.example.dictionary;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DefinitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);

        String word = getIntent().getStringExtra("WORD");
        String definition = getIntent().getStringExtra("DEFINITION");
        TextView wordText = (TextView) findViewById(R.id.wordtext);
        TextView definitionWordText = (TextView) findViewById(R.id.definitionwordtext);

        wordText.setText(word);
        definitionWordText.setText(definition);
    }
}