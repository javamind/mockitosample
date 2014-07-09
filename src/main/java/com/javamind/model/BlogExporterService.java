package com.javamind.model;

import com.javamind.domain.Article;

/**
 * {@link }
 *
 * @author EHRET_G
 */
public interface BlogExporterService {

    public void publish(Article article);

    public int socialBroadcast(Article article);
}
