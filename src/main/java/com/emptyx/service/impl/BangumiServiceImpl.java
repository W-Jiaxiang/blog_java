package com.emptyx.service.impl;

import com.emptyx.dao.bangumi.BangumiDao;
import com.emptyx.entity.bangumi.Bangumi;
import com.emptyx.entity.bangumi.Catalog;
import com.emptyx.service.bangumi.BangumiService;
import com.emptyx.utils.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author emptyx
 * @Date 2022/6/19 17:25
 */
@Slf4j
@Service
public class BangumiServiceImpl implements BangumiService {

    private static final String[] weekDays = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ,"星期日"};

    @Autowired
    private BangumiDao bangumiDao;

    @Override
    public List<Catalog> queryCatalog() {
        List<Catalog> list = bangumiDao.getCatalogs();
        for (Catalog catalog : list) {
            String keyword = catalog.getKeyword();
            String[] item = keyword.split(" ");
            for (String str : item) {
                log.info(str);
            }
            catalog.setItem(item);

        }
        return list;
    }

    @Override
    public PageInfo queryBangumiByPage(Map<String, Object> paramMap) {
        //设置页数和页面条数的默认值
        Integer pageNum = 0;
        Integer pageSize = 30;
        if (null != paramMap.get("pageNum")){
            pageNum = Integer.parseInt(paramMap.get("pageNum").toString());
            paramMap.put("rowNum", pageSize*pageNum);
        }
        if (null != paramMap.get("pageSize")){
            pageSize = Integer.parseInt(paramMap.get("pageSize").toString());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Bangumi> page = bangumiDao.getBangumiByPage(paramMap);
        PageInfo<Bangumi> pageInfo = new PageInfo<>(page);
        pageInfo.setTotal(bangumiDao.getCount());

        return pageInfo;
    }


    /*获取当前时间*/
    private Map getTime(){
        Map time = new HashMap();

        Date date = new Date();
        time.put("date",date);
        SimpleDateFormat dateFm2 = new SimpleDateFormat("EE");
        String currSun = dateFm2.format(date);
        log.info("date2:"+currSun);
        //计算出周几
        for (int i = 0; i < weekDays.length; i++) {
            if (currSun.equals(weekDays[i])){
                time.put("weekDay",++i);
                break;
            }
        }
        return time;
    }

    /*计算最近更新时间*/
    private Date calcDays(int current, int update,Date date) {
        int days = 0;
        //计算今天距离最后一次更新间的天数
        if (current >= update) {
            days = current - update;
        } else {
            days = 7 - update + current;
        }
        //返回最近一次更新的时间戳
        return new Date(date.getTime() - 1000 * 3600 * 24 * days);
    }
}
