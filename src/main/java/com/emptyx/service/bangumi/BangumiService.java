package com.emptyx.service.bangumi;

import com.emptyx.entity.bangumi.Bangumi;
import com.emptyx.entity.bangumi.Catalog;
import com.emptyx.utils.PageResult;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author emptyx
 * @Date 2022/6/19 17:21
 */
public interface BangumiService {

    List<Catalog> queryCatalog();

    PageInfo queryBangumiByPage(Map<String,Object> map);

}
