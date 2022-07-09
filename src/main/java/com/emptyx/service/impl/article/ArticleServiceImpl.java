package com.emptyx.service.impl.article;

import com.emptyx.dao.article.ArticleDao;
import com.emptyx.entity.article.Article;
import com.emptyx.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author emptyx
 * @Date 2022/6/26 11:39
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public int addArticle(Article article) {
        //获取时间戳
        Date date = new Date();
        //格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);

        //设置文章属性
        article.setReleaseDate(format);

        return articleDao.insert(article);
    }

    @Override
    public List<Article> getArticle() {
        List<Article> list = articleDao.select();
        return list;
    }
}
