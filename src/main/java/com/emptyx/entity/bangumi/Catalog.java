package com.emptyx.entity.bangumi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 筛选
 * @Author emptyx
 * @Date 2022/7/1 21:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Catalog {

    /*主键ID*/
    private int id;

    /*筛选类型*/
    private String category;

    /*筛选关键词集合*/
    private String keyword;

    /*筛选关键词数组*/
    private String[] item;

}
