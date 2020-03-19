package org.escalade.controller.validator;

import org.escalade.model.entity.User;
import org.escalade.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        /*
        if i don't use annotation for validation empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userForm.username");
          */

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Diff.user.confirmPassword");
        }

        if (userService.existUsername(user.getUsername())!=null) {
            errors.rejectValue("username", "Unique.user.username");
        }

        if (userService.existEmail(user.getEmail())!=null) {
            errors.rejectValue("email", "Unique.user.email");
        }

    }
}
