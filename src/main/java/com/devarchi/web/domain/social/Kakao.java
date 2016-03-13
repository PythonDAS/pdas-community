package com.devarchi.web.domain.social;

import lombok.Data;

/**
 * Created by donghoon on 2016. 3. 13..
 * <p>
 * User 와 1:1 관계 이다.
 */
@Data
public class Kakao {

    private Integer kakao_id;
    private String profile_img;
    private String thumbnail_img;
}
