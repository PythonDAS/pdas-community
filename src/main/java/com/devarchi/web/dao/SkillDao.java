package com.devarchi.web.dao;

import com.devarchi.web.domain.Skill;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donghoon on 2016. 2. 19..
 */
@Repository
public interface SkillDao {

    @Select("select count(*) cnt from skill")
    int count();

    @Select("select name, skill from skill")
    List<Skill> find();

    @Select("select name, skill from skill where name = #{name}")
    List<Skill> findSkillByName(String name);
}
