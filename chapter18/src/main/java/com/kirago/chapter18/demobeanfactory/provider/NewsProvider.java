package com.kirago.chapter18.demobeanfactory.provider;

import com.kirago.chapter18.demobeanfactory.base.News;

public class NewsProvider {
    private News news;

    public News getNews(){
        return  news;
    }

    public void setNews(News news){
        this.news = news;
    }
}
