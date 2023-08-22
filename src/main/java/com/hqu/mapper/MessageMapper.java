package com.hqu.mapper;

import com.hqu.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface MessageMapper {

    /**
     * 将数据插入message表中
     * @param message
     */
    @Insert("insert into message(name,link,create_time,update_time) " +
            "values (#{name},#{link},#{createTime},#{updateTime})")
    void insert(Message message);

    /**
     * 分页模糊查询
     * @param name
     * @return
     */
    List<Message> list(String name);

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
    @Select("select * from  message where id = #{id}")
    Message getById(Integer id);

    void update(Message message);
}
