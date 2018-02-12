package com.example.macintosh.myduolingo.storage;

import android.util.Log;

import com.example.macintosh.myduolingo.models.LanguageToLearnEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macintosh on 2/5/18.
 */

public class LanguageToLearnData {

    private List<LanguageToLearnEntity> languagesToLearnEntityList;

    public LanguageToLearnData() {
        this.languagesToLearnEntityList = new ArrayList<>();
    }

    public List<LanguageToLearnEntity> generateLanguagesList() {
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(1, "SPA", "Spanish", "images/flag_sp.png", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(3, "FRA", "French", "images/flag_fr.png", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(5, "GER", "German", "images/flag_ge.png", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(6, "CHI", "Chinese", "images/flag_ch.png", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(2, "ENG", "English", "images/flag_us.png", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(7, "JAP", "Japanese", "images/flag_ja.png", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(8, "KOR", "Korean", "images/flag_ko.png", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(9, "ITA", "Italian", "images/flag_it.png", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(4, "POR", "Portuguese", "images/flag_pr.png", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(10, "DUT", "Dutch", "images/flag_du.png", true));

        logAllArrayElements(languagesToLearnEntityList);

        return languagesToLearnEntityList;
    }

    public LanguageToLearnEntity getStudiedLanguage(){
        return new LanguageToLearnData().generateLanguagesList().get(4);
    }


    public void logAllArrayElements(List<LanguageToLearnEntity> languagesToLearnEntityList){
        for(LanguageToLearnEntity lang: languagesToLearnEntityList){
            Log.d("ARRAY_ELEMS",lang.getLangName());
        }

    }

}
