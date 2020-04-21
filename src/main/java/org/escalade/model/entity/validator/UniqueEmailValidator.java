package org.escalade.model.entity.validator;

import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    UserDao userDao;


    @Override
    public void initialize(UniqueEmail unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        userDao = new UserDaoImpl();

        if (userDao.findByEmail(email) != null) {
            return false;
        } else {
            return true;
        }
    }
}
