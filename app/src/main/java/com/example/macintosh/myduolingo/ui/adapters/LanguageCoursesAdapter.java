package com.example.macintosh.myduolingo.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macintosh.myduolingo.R;
import com.example.macintosh.myduolingo.ui.models.LanguageToLearnEntity;

import java.util.List;

/**
 * Created by macintosh on 2/5/18.
 */

public class LanguageCoursesAdapter extends RecyclerView.Adapter<LanguageCoursesAdapter.ViewHolder>{

    private List<LanguageToLearnEntity> languagesData;
    private final Context context;
    private final DuolingoInterface myDuolingInterface;

    public LanguageCoursesAdapter(List<LanguageToLearnEntity> languagesData, Context context, DuolingoInterface myDuolingInterface) {
        this.languagesData = languagesData;
        this.context = context;
        this.myDuolingInterface = myDuolingInterface;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Attaching row element to its parent activity
        View viewToAttach = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_language_detail, parent, false);

        //Set row view
        ViewHolder viewHolder = new ViewHolder(viewToAttach);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        LanguageToLearnEntity language = languagesData.get(position);

        final int languageDescPosition = position;
        final String languageName;



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
