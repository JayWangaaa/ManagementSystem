package com.hqu.service;

import com.hqu.pojo.Food;
import com.hqu.pojo.Message;
import com.hqu.pojo.PageBean;

public interface FoodService {
    /**
     * 分页模糊查询
     * @param page
     * @param pageSize
     * @param name
     * @param location
     * @param score
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, String location, String score);

    /**
     * 根据ID删除数据
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增
     * @param food
     */
    void insert(Food food);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Food getById(Integer id);

    /**
     * 更新数据
     * @param food
     */
    void update(Food food);
}
