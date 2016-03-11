package com.devarchi.web.dao;

import com.devarchi.web.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donghoon on 2016. 2. 19..
 */
@Repository
public interface UserDao {

    @Select("select count(*) cnt from user")
    int count();

    @Select("select name, pass, email from user")
    List<User> find();

    @Select("select name, pass, email from user where name = #{name}")
    User findByName(String name);
}
