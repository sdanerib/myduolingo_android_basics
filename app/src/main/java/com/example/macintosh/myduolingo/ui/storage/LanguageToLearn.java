package com.example.macintosh.myduolingo.ui.storage;

import com.example.macintosh.myduolingo.ui.models.LanguageToLearnEntity;

import java.util.ArrayList;

/**
 * Created by macintosh on 2/5/18.
 */

public class LanguageToLearn {

    private ArrayList<LanguageToLearnEntity> languagesToLearnEntityList = new ArrayList<LanguageToLearnEntity>();

    public ArrayList<LanguageToLearnEntity> getLanguagesToLearnEntityList() {
        return languagesToLearnEntityList;
    }

    public void setLanguagesToLearnEntityList(ArrayList<LanguageToLearnEntity> languagesToLearnEntityList) {
        this.languagesToLearnEntityList = languagesToLearnEntityList;
    }

    public LanguageToLearn(ArrayList<LanguageToLearnEntity> languagesToLearnEntityList) {
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(1, "ENG", "English","flag_us", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(2, "FRA", "French","flag_fr", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(3, "POR", "Portuguese","flag_pr", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(4, "GER", "German","flag_ge", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(5, "CHI", "Chinese","flag_ch", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(6, "JAP", "Japanese","flag_ja", false));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(7, "KOR", "Korean","flag_ja", false));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(8, "ITA", "Italian","flag_it", true));
        this.languagesToLearnEntityList.add(new LanguageToLearnEntity(12, "DUT", "Dutch","flag_du", true));
    }






}
