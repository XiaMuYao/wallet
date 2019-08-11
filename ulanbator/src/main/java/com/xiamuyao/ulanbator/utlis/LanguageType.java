package com.xiamuyao.ulanbator.utlis;

/**
 * Created by dumingwei on 2018/5/31 0031.
 */
public enum LanguageType {

    CHINESE("ch"),
    ENGLISH("en"),
    KOREAN("ko"),
    JAPANESE("ja");

    private String language;

    LanguageType(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language == null ? "" : language;
    }
}
