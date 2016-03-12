package com.devarchi.web.dao.mybatis;

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

    @Select("select skill_name from skill")
    List<Skill> find();

    @Select("select skill_name from skill where user_id = #{user_id}")
    List<Skill> findSkillByName(String name);
}
