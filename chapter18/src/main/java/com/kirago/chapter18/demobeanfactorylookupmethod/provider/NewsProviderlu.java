package com.kirago.chapter18.demobeanfactorylookupmethod.provider;

import com.kirago.chapter18.demobeanfactorylookupmethod.base.News;

public class NewsProviderlu {

    private News news;

    public void setNews(News news) {
        this.news = news;
    }

    public News getNews(){
        return news;
    }
}
