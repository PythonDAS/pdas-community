package com.devarchi.web.dao;

import com.devarchi.web.domain.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by donghoon on 2016. 2. 19..
 */
@Repository
public class UserDao {

    private SqlSessionTemplate sessionTemplate;

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public User selectByName(String name) {
        User user = sessionTemplate.selectOne("com.devarchi.web.dao.UserDao", name);
        return user;
    }
}
