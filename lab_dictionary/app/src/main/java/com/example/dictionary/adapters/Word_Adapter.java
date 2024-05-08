package com.example.dictionary.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.DefinitionActivity;
import com.example.dictionary.R;
import com.example.dictionary.utils.DictionaryModel;

import java.util.List;

public class Word_Adapter extends RecyclerView.Adapter<Word_Adapter.ViewHolder> {

    public List<DictionaryModel> data;

    public Word_Adapter() {
    }

    public void setData(List<DictionaryModel> data) {
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
        DictionaryModel dictionaryModel = data.get(position);
        holder.wordText.setText(dictionaryModel.getWord());
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
                    DictionaryModel dictionaryModel = data.get(position);

                    Intent intent = new Intent(context, DefinitionActivity.class);
                    intent.putExtra("WORD", dictionaryModel.getWord());
                    intent.putExtra("DEFINITION", dictionaryModel.getDefinition());
                    context.startActivity(intent);
                }
            });
        }
    }
}
