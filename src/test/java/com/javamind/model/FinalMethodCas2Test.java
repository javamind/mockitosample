package com.javamind.model;

import com.javamind.domain.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * {@link }
 *
 * @author EHRET_G
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest( { DefaultMessagerServiceImpl.class })
public class FinalMethodCas2Test {
    @InjectMocks
    private BlogArticleServiceImpl blogArticleService = new BlogArticleServiceImpl();
    @Mock
    private BlogExporterService mockElogExporterService;

    private DefaultMessagerServiceImpl defaultMessagerService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        defaultMessagerService = PowerMockito.mock(DefaultMessagerServiceImpl.class);
        blogArticleService.setMessagerService(defaultMessagerService);
    }

    @Test
    public void test(){
        when(mockElogExporterService.socialBroadcast(any(Article.class))).thenReturn(3);
        PowerMockito.when(defaultMessagerService.isRunning()).thenReturn(false);

        assertThat(blogArticleService.write("title", "my new content")).isEqualTo(false);
    }

}
