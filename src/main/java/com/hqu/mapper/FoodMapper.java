package com.hqu.mapper;

import com.hqu.pojo.Food;
import com.hqu.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodMapper {
    /**
     * 分页模糊查询
     * @param name
     * @param location
     * @param score
     * @return
     */
    List<Food> list(String name, String location, String score);

    /**
     * 根据ID删除数据
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增
     * @param food
     */
    @Insert("insert into food(name,location,introduction,score,picture) " +
            "values (#{name},#{location},#{introduction},#{score},#{picture})")
    void insert(Food food);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Select("select * from  food where id = #{id}")
    Food getById(Integer id);

    void update(Food food);
}
