package com.javamind.model;

import com.javamind.domain.Article;

/**
 * Exemple d'interface d'un service métier
 *
 * @author EHRET_G
 */
public interface MonServiceMetier {
    /**
     * Execution d'un traitement
     */
    void execute();

    /**
     * Verification d'un article
     * @param article
     * @return
     */
    boolean checkArticle(Article article);
}
