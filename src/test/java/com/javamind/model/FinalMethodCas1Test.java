package com.javamind.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * {@link }
 *
 * @author EHRET_G
 */
@RunWith(MockitoJUnitRunner.class)
public class FinalMethodCas1Test {
    @InjectMocks
    private BlogArticleService blogArticleService = new BlogArticleServiceImpl();
    @Mock
    private BlogExporterService mockElogExporterService;
    @Mock
    private DefaultMessagerServiceImpl defaultMessagerService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = NullPointerException.class)
    public void test(){
        when(defaultMessagerService.isRunning()).thenReturn(false);
        assertThat(blogArticleService.write("title", "my new content")).isEqualTo(false);
    }

}
