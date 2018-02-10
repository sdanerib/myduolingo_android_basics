package com.example.macintosh.myduolingo.ui.adapters;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macintosh.myduolingo.R;
import com.example.macintosh.myduolingo.models.LanguageToLearnEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by macintosh on 2/5/18.
 */

public class LanguageCoursesAdapter extends RecyclerView.Adapter<LanguageCoursesAdapter.ViewHolder>{

    private List<LanguageToLearnEntity> languagesData;
    private final Context context;
    private final DuolingoBehaviourInterface myDuolingoBehaviourInterface;

    public LanguageCoursesAdapter(List<LanguageToLearnEntity> languagesData, Context context, DuolingoBehaviourInterface myDuolingoInterface) {
        this.languagesData = languagesData;
        this.context = context;
        this.myDuolingoBehaviourInterface = myDuolingoInterface;
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

    //Row Layout Definition
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iviFlagIcon;
        public TextView tviLangName;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            iviFlagIcon = itemView.findViewById(R.id.iviFlagIcon);
            tviLangName = itemView.findViewById(R.id.tviLangName);

        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        LanguageToLearnEntity language = languagesData.get(position);

        final int languageDescPosition = position;
        final String languageName = language.getLangName();

        holder.tviLangName.setText(languageName);
        holder.iviFlagIcon.setImageBitmap(getBitmapFromAssets(language.getLangFlagRes()));

        /*holder.tviLangName.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                try {

                    myDuolingoBehaviourInterface.chooseLanguageToLearn(languageDescPosition, languageName);

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });*/


    }

    private Bitmap getBitmapFromAssets(String filename) {

        AssetManager assetManager = context.getAssets();
        InputStream inputStream = null;

        try {
            inputStream = assetManager.open(filename);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

        return bitmap;
    }

    @Override
    public int getItemCount() {
        return languagesData.size();
    }


}
