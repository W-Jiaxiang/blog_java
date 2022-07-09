package com.emptyx.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询返回结果
 * @Author emptyx
 * @Date 2022/7/5 18:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PageResult implements Serializable {
    /*总数*/
    private Long total;
    /*内容*/
    private List data;

}
