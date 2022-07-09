package com.emptyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @Author emptyx
 * @Date 2022/6/20 12:32
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    private int id;
    private String account;
    private String userName;
    private String password;
    private String verCode;

}
