package com.emptyx.dao.bangumi;

import com.emptyx.entity.bangumi.Bangumi;
import com.emptyx.entity.bangumi.Catalog;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author emptyx
 * @Date 2022/6/19 16:57
 */
@Mapper
@Repository
public interface BangumiDao {

    /*获取番剧列表*/
    Long getCount();

    /*获取筛选列表*/
    List<Catalog> getCatalogs();

    /*分页查询*/
    List<Bangumi> getBangumiByPage(Map<String,Object> map);
}
