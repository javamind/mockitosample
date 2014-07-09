package com.javamind.model;

import com.google.common.annotations.VisibleForTesting;
import com.javamind.domain.Article;
import com.javamind.exception.PublicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * {@link }
 *
 * @author EHRET_G
 */
@Service("blogArticleService")
public class BlogArticleServiceImpl implements BlogArticleService{

    @Autowired
    BlogExporterService blogExporterService;

    @Override
    public boolean write(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setDate(new Date());
        article.setContent(content);

        if(checkArticle(article)){
            try{
                blogExporterService.publish(article);
                blogExporterService.socialBroadcast(article);
                return true;
            }
            catch(PublicationException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean checkArticle(Article article) {
        return true;
    }

    @VisibleForTesting
    protected void setBlogExporterService(BlogExporterService blogExporterService) {
        this.blogExporterService = blogExporterService;
    }
}
