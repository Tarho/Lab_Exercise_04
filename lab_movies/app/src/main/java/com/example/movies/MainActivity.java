package com.example.movies;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import com.example.movies.R;
import com.example.movies.adapters.Name_Adapter;
import com.example.movies.utils.DatabaseHelper;
import com.example.movies.utils.MovieModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvWord;
    private Name_Adapter name_adapter;
    private List<MovieModel> movieModelsList;
    private DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWord = (RecyclerView) findViewById(R.id.rvWord);
        rvWord.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mDBHelper = new DatabaseHelper(this);

        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if (database.exists() == false) {
            mDBHelper.getReadableDatabase();
            if (copyDatabase(this)) {
                Toast.makeText(getApplicationContext(), "Copy Successful", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Copy Failed", Toast.LENGTH_LONG).show();
                return;
            }
        }
        movieModelsList = mDBHelper.getListWord("");
        name_adapter = new Name_Adapter();
        name_adapter.setData(movieModelsList);


        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchWord(newText);
                return false;
            }

            private void searchWord(String wordSearch) {
                movieModelsList.clear();
                movieModelsList = mDBHelper.getListWord(wordSearch);
                name_adapter.setData(movieModelsList);
                rvWord.setAdapter(name_adapter);
            }
        });
    }

    private boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("Database", "Copy Success");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}