package com.sap.wtl.validator;


import com.sap.wtl.models.User;
import com.sap.wtl.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.annotation.Resource;

@Component
public class UserValidator implements Validator {
    @Resource
    private UserService defaultUserService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (defaultUserService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
    }
    }
}