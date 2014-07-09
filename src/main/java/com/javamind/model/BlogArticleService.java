package com.javamind.model;

import com.javamind.domain.Article;

/**
 * Exemple d'interface d'un service métier
 *
 * @author EHRET_G
 */
public interface BlogArticleService {
    /**
     * Execution d'un traitement
     */
    boolean write(String title, String content);

    /**
     * Verification d'un article
     * @param article
     * @return
     */
    boolean checkArticle(Article article);
}
