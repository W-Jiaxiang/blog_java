package com.emptyx.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 统一后端返回结果
 * @Author emptyx
 * @Date 2022/7/5 14:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class R {

    /*响应是否成功*/
    private Boolean success;

    /*响应码*/
    private Integer code;

    /*字符串*/
    private String message;

    /*数据*/
    private Object data;

    /*成功，没有数据*/
    public R ok(){
        this.setSuccess(true);
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("请求成功，无返回数据");
        return this;
    }

    /*失败*/
    public R error(){
        this.setSuccess(false);
        this.setCode(ResultCode.ERROR);
        this.setMessage("请求失败");
        return this;
    }

    /*成功，有数据*/
    public R(Object data){
        this.setSuccess(true);
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("请求成功，有返回数据");
        this.setData(data);
    }

}