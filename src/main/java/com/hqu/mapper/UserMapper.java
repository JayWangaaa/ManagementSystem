package com.hqu.mapper;

import com.hqu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 根据账号密码查询用户
     * @param user
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User getByUsernamePassword(User user);

    /**
     * 将数据插入用户表中
     * @param user
     */
    @Insert("insert into user(username,name,gender,phone,image) " +
            "values (#{username},#{name},#{gender},#{phone},#{image})")
    void insert(User user);

    /**
     * 分页模糊查询
     * @param name
     * @return
     */
    List<User> list(String name,String username);

    /**
     * 根据ID删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    @Select("select * from  user where id = #{id}")
    User getById(Integer id);

    void update(User user);
}
