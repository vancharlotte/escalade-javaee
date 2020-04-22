package org.escalade.model.entity.validator;

import org.escalade.model.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ComparePasswordValidator implements ConstraintValidator<ComparePassword, User> {

    String message;

    public void initialize(ComparePassword constraint) {
        message = constraint.message();

    }

    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            return true;
        } else {
            return false;
        }
    }
}

