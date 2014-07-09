package com.javamind.model;

import com.javamind.domain.Article;
import com.javamind.exception.PublicationException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Test de {@link com.javamind.model.BlogArticleService} avec les annotations
 * en utilisant le mot clé given à la place de when
 * @author EHRET_G
 */
public class BlogArticleServiceImplCas3Test {
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
        given(mockElogExporterService.socialBroadcast(any(Article.class))).willReturn(3);
        //On appelle notre classe
        assertThat(blogArticleService.write("title", "my new content")).isEqualTo(true);
    }

}
