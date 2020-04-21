package org.escalade.model.entity.validator;

import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserValidator implements ConstraintValidator<UniqueUser, String> {

    UserDao userDao;

    @Override
    public void initialize(UniqueUser unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        userDao = new UserDaoImpl();

        if (userDao.findByUsername(username) != null) {
            return false;
        } else {
            return true;
        }
    }
}
