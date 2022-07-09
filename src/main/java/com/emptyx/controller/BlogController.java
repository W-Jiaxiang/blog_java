package com.emptyx.controller;

import com.emptyx.entity.article.Article;
import com.emptyx.service.impl.article.ArticleServiceImpl;
import com.emptyx.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author emptyx
 * @Date 2022/6/23 16:34
 */
@Slf4j
@RestController
public class BlogController {

    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping("/editor")
    public ModelAndView editArticle(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/article/ArticleEditor");
        return modelAndView;
    }

    @PostMapping("/editor")
    public void writeArticle(Article article, HttpSession session, HttpServletResponse response) throws IOException {
        log.info("******"+article);
        log.info("************userId:{}",session.getAttribute("userId"));
        article.setUserId((Integer) session.getAttribute("userId"));
        articleService.addArticle(article);
        response.sendRedirect("/");
    }

    @GetMapping("/article")
    public R upArticle(){
        List<Article> articles = articleService.getArticle();
        return new R(articles);
    }

}
