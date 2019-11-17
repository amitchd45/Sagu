package com.example.Models;

public class MainModel {

    Integer langLogo;
    String langName;
    String langPrices;

    public MainModel(Integer langLogo, String langName, String langPrices) {
        this.langLogo = langLogo;
        this.langName = langName;
        this.langPrices = langPrices;
    }

    public Integer getLangLogo() {
        return langLogo;
    }

    public String getLangName() {
        return langName;
    }

    public String getLangPrices() {
        return langPrices;
    }
}
