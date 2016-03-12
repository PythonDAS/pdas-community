package com.devarchi.web.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by donghoon on 2016. 2. 19..
 * <p>
 * Kakao 와 1:1 관계이다.
 */
@Data
public class User {

    @Id
    private Integer user_id;
    private String name;
    private String password;
    private String email;
    private Integer kakao_id;

    /**
     * However, if Kakao is stored in the database as a separate table, nested inserts are not supported.
     * You will need to call both inserts in Java. ResultMaps are for selects.
     * If you are just putting a few columns from one table in a separate object, then you can do this with dot notation, Kakao.myField_xx
     */
//    @Data
//    public class Kakao {
//
//    }

}
