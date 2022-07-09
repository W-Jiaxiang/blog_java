package com.emptyx.service.article;

import com.emptyx.entity.article.Article;

import java.util.List;

/**
 * @Author emptyx
 * @Date 2022/6/26 11:38
 */
public interface ArticleService {

    int addArticle(Article article);

    List<Article> getArticle();
}
