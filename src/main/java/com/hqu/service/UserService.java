package com.hqu.service;

import com.hqu.pojo.PageBean;
import com.hqu.pojo.User;
import java.util.List;


public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户注册（插入数据）
     * @param user
     */
    void insert(User user);

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name,String username);

    /**
     * 根据ID删除数据
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * 更新数据
     * @param user
     */
    void update(User user);
}
