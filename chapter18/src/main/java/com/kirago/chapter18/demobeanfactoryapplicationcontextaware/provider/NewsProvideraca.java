package com.kirago.chapter18.demobeanfactoryapplicationcontextaware.provider;

import com.kirago.chapter18.demobeanfactoryapplicationcontextaware.base.News;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class NewsProvideraca implements ApplicationContextAware {

    private News news;

    private ApplicationContext applicationContext;

    public void setNews(News news) {
        this.news = news;
    }

    public News getNews(){
        return applicationContext.getBean("news",News.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
