package com.devarchi.web.dao.mybatis;

import com.devarchi.web.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donghoon on 2016. 2. 19..
 */
@Repository
public interface UserDao {

    @Delete("delete from user where name = #{name}")
    void deleteUserByName(String name);

    @Select("select count(*) cnt from user")
    int count();

    @Select("select * from user")
    List<User> find();

    @Select("select name, password, email from user where name = #{name}")
    User findByName(String name);

    @Insert("insert into user (name, password, email) values (#{name}, #{password}, #{email})")
    void insertUser(User user);

    @Update("update user set password = #{password} where name = #{name}")
    void updateUserPasswordByName(@Param("password") String password, @Param("name") String name);
}