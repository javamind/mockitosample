package com.javamind.model;

import com.javamind.domain.Article;
import com.javamind.exception.PublicationException;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Test de {@link com.javamind.model.BlogArticleService} sans utiliser les annotations
 *
 * @author EHRET_G
 */
public class BlogArticleServiceImplCas1Test {

    private BlogArticleService blogArticleService;

    private BlogExporterService mockElogExporterService;

    @Before
    public void setUp(){
        //J'initie les mocks
        mockElogExporterService = mock(BlogExporterService.class);
        //Le service a tester est créé
        blogArticleService = new BlogArticleServiceImpl();
        ((BlogArticleServiceImpl)blogArticleService).setBlogExporterService(mockElogExporterService);
    }

    @Test
    public void writeArticleShouldPublishAndBroadCast(){
        //On prepare le mock
        when(mockElogExporterService.socialBroadcast(any(Article.class))).thenReturn(3);
        //On appelle notre classe
        boolean result = blogArticleService.write("title", "my new content");
        //On vérifie que le mock a ete appele
        verify(mockElogExporterService).publish(any(Article.class));
        verify(mockElogExporterService).socialBroadcast(any(Article.class));
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void writeArticleShouldNotBroadCastWhenArticleIsNotPublished(){
        //On prepare le mock pour qu'il retourne une exception
        doThrow(new PublicationException("error")).when(mockElogExporterService).publish(any(Article.class));
        //On appelle notre classe
        boolean result = blogArticleService.write("title", "my new content");
        //On vérifie le résultat
        verify(mockElogExporterService).publish(any(Article.class));
        verify(mockElogExporterService, never()).socialBroadcast(any(Article.class));
        assertThat(result).isEqualTo(false);
    }
}
