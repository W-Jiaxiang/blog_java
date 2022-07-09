package com.emptyx.controller;

import com.emptyx.entity.bangumi.Bangumi;
import com.emptyx.entity.bangumi.Catalog;
import com.emptyx.utils.PageResult;
import com.emptyx.utils.R;
import com.emptyx.service.impl.BangumiServiceImpl;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author emptyx
 * @Date 2022/6/17 15:23
 */
@Slf4j
@RestController
//@CrossOrigin
public class BangumiController {

    @Autowired
    private BangumiServiceImpl bangumiService;

//    @GetMapping("/bangumi")
//    public R testRequest(){
//
//        List<Bangumi> bangumis = bangumiService.queryBangumi();
//        List<Catalog> catalogs = bangumiService.queryCatalog();
//
//        return new R(bangumis);
//    }
    @GetMapping("/bangumi")
    public R getListByPage(@RequestParam Map<String, Object> paramMap){

        PageInfo pageInfo = bangumiService.queryBangumiByPage(paramMap);

        return new R(pageInfo);
    }

    @GetMapping("/catalog")
    public R getCatalog(){
        List<Catalog> list = bangumiService.queryCatalog();

        return new R(list);
    }



}
