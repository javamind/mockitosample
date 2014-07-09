package com.javamind.model;

import com.javamind.domain.Article;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Test de {@link BlogArticleService} avec les annotations
 * en utilisant les spy
 * @author EHRET_G
 */
public class BlogArticleServiceImplCas4Test {
    @InjectMocks
    @Spy
    private BlogArticleService blogArticleService = new BlogArticleServiceImpl();
    @Mock
    private BlogExporterService mockElogExporterService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void writeArticleShouldNotPublishAndBroadCastWhenCheckFailed(){
        given(blogArticleService.checkArticle(any(Article.class))).willReturn(false);
        //On appelle notre classe
        assertThat(blogArticleService.write("title", "my new content")).isEqualTo(false);
        verifyZeroInteractions(mockElogExporterService);
    }

}
