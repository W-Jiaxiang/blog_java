package com.emptyx.entity.bangumi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * 番剧实体
 * @Author emptyx
 * @Date 2022/6/19 16:53
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Bangumi {

    /*主键ID*/
    private int id;

    /*名称*/
    private String title;

    /*上映日期*/
    private String releaseDate;

    /*归属地区*/
    private String region;

    /*版本*/
    private String versions;

    /*状态*/
    private String condition;

    /*集数*/
    private String part;

    /*更新日期*/
    private String updateTime;

    /*封面地址*/
    private String cover;

    /*更新时间*/
    private String week;
}
