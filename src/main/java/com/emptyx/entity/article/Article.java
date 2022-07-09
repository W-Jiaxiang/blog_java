package com.emptyx.entity.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 文章主体
 * @Author emptyx
 * @Date 2022/6/25 18:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Article {

    //文章主键ID
    private int id;

    //文章标题
    private String title;

    //文章内容
    private String content;

    //文章封面
    private String cover;

    //文章发布者
    private Integer userId;

    //文章发布者头像
    private String avatar;

    //文章发布时间
    private String releaseDate;

    //文章浏览量
    private int browseCount;

    //文章点赞数
    private int like;

}
