package com.example.manatrashidov.lw2;

/**
 * Created by Manat Rashidov on 4/13/2018.
 */

public class News {
    private String headline;
    private String published;
    private Integer imageRes;
    private String article;


    public News(String headline, String published, String article, Integer imageRes) {
        this.headline = headline;
        this.published = published;
        this.imageRes = imageRes;
        this.article = article;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Integer getImageRes() {
        return imageRes;
    }

    public void setImageRes(Integer imageRes) {
        this.imageRes = imageRes;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

}
