package com.javamind.model;

import com.javamind.domain.Article;
import com.javamind.exception.PublicationException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Test de {@link BlogArticleService} avec les annotations
 *
 * @author EHRET_G
 */
public class BlogArticleServiceImplCas2Test {
    @InjectMocks
    private BlogArticleService blogArticleService = new BlogArticleServiceImpl();
    @Mock
    private BlogExporterService mockElogExporterService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void writeArticleShouldPublishAndBroadCast(){
        //On prepare le mock
        when(mockElogExporterService.socialBroadcast(any(Article.class))).thenReturn(3);
        //On appelle notre classe
        assertThat(blogArticleService.write("title", "my new content")).isEqualTo(true);
    }

    @Test
    public void writeArticleShouldNotBroadCastWhenArticleIsNotPublished(){
        //On prepare le mock pour qu'il retourne une exception
        doThrow(new PublicationException("error")).when(mockElogExporterService).publish(any(Article.class));
        //On appelle notre classe
        boolean result = blogArticleService.write("title", "my new content");
        //On vérifie le résultat
        verify(mockElogExporterService, never()).socialBroadcast(any(Article.class));
        assertThat(result).isEqualTo(false);
    }
}
