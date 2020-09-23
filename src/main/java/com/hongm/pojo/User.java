package com.hongm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private String loginName;
    private int gender;//1男  0女
    private String phoneNum;
    private String address;
    private String status;
    private String password;
    private int age;
}
