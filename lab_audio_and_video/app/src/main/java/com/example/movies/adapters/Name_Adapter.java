package com.example.movies.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;
import com.example.movies.DetailmovieActivity;
import com.example.movies.utils.MovieModel;

import java.util.List;

public class Name_Adapter extends RecyclerView.Adapter<Name_Adapter.ViewHolder> {

    public List<MovieModel> data;

    public Name_Adapter() {
    }

    public void setData(List<MovieModel> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View wordView = inflater.inflate(R.layout.word_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(wordView, context);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieModel movieModel = data.get(position);
        holder.wordText.setText(movieModel.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Context context;
        public TextView wordText;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            wordText = (TextView) itemView.findViewById(R.id.wordtext);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    MovieModel movieModel = data.get(position);

                    Intent intent = new Intent(context, DetailmovieActivity.class);
                    intent.putExtra("NAME", movieModel.getName());
                    intent.putExtra("BACKGROUNDPICTURE", movieModel.getBackgroundpicture());
                    intent.putExtra("PICTURE", movieModel.getPicture());
                    intent.putExtra("DESCRIPTION", movieModel.getDescription());
                    context.startActivity(intent);
                }
            });
        }
    }
}
