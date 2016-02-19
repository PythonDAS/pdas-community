package com.devarchi.web.command;

import lombok.Data;

/**
 * Created by donghoon on 2016. 2. 15..
 */
@Data
public class MemberJoinRequest {

    String email;
    String name;
    String pass;
    String confirmPass;
}
