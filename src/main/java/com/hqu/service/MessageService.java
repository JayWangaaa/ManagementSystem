package com.hqu.service;

import com.hqu.pojo.Message;
import com.hqu.pojo.PageBean;
import com.hqu.pojo.User;

public interface MessageService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name);

    /**
     * 根据ID删除资讯
     * @param id
     */
    void delete(Integer id);

    /**
     * 增加资讯
     * @param message
     */
    void insert(Message message);

    /**
     * 根据ID查询资讯
     * @param id
     * @return
     */
    Message getById(Integer id);

    /**
     * 更新资讯信息
     * @param message
     */
    void update(Message message);
}
