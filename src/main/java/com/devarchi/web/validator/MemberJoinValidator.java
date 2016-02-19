package com.devarchi.web.validator;

import com.devarchi.web.command.MemberJoinRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by donghoon on 2016. 2. 15..
 */
public class MemberJoinValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return MemberJoinRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberJoinRequest request = (MemberJoinRequest) target;

        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "required");
        }
    }
}
