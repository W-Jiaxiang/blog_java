package com.emptyx.entity.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 文章评论主体
 * @Author emptyx
 * @Date 2022/6/25 19:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Comment {

    //评论主键ID
    private int id;

    //评论内容
    private String content;

    //评论文章ID
    private int articleIId;

    //评论用户ID
    private int userID;

    //评论时间
    private String releaseDate;

}
