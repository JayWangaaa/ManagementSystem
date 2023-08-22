package com.hqu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id; //ID
    private String name; //姓名
    private String username; //用户名
    private String password; //密码
    private String image; //图像url
    private String gender;
    private String phone;
}
