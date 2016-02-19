package com.devarchi.web.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by donghoon on 2016. 2. 19..
 */
@Repository
public interface UserDao {

    @Select("select count(*) cnt from user")
    int count();
}
