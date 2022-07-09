package com.emptyx.dao.article;

import com.emptyx.entity.article.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author emptyx
 * @Date 2022/6/25 19:26
 */
@Repository
public interface ArticleDao {

    int insert(Article article);

    List<Article> select();

}
