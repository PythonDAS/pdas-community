package com.devarchi.web.dao.mybatis;

import com.devarchi.web.domain.social.Kakao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donghoon on 2016. 3. 13..
 */
@Repository
public interface KakaoDao {

    @Delete("delete from kakao where kakao_id = #{kakao_id}")
    void deleteKakaoInfoById(Integer kakao_id);

    @Select("select count(*) cnt from kakao")
    int count();

    @Select("select * from kakao")
    List<Kakao> find();

    @Select("select * from kakao where kakao_id = #{kakao_id}")
    Kakao findById(Integer kakao_id);

    @Select("select kakao_id from kakao where kakao_id = #{kakao_id}")
    Kakao exist(Integer kakao_id);

    @Insert("insert into kakao (kakao_id, nick_name, profile_img, thumbnail_img) " +
            "values (#{kakao_id}, #{nick_name}, #{profile_img}, #{thumbnail_img})")
    void insertKakaoInfo(Kakao kakaoInfo);

    @Update("update kakao set nick_name = #{nick_name} where kakao_id = #{kakao_id}")
    void updateKakaoInfoById(@Param("nick_name") String nick_name, @Param("kakao_id") String kakao_id);
}