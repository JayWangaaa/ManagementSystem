package com.hqu.mapper;

import com.hqu.pojo.Attraction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttractionMapper {

    List<Attraction> list(String name, String location, String score);

    void delete(Integer id);

    @Insert("insert into attraction(name,location,score,picture) " +
            "values (#{name},#{location},#{score},#{picture})")
    void insert(Attraction attraction);

    @Select("select * from  attraction where id = #{id}")
    Attraction getByID(Integer id);

    void update(Attraction attraction);
}
