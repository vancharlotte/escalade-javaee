package org.escalade.model.entity.validator;

import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, User> {
    static final Logger logger = LoggerFactory.getLogger(UniqueEmailValidator.class);

    UserDao userDao;

    @Override
    public void initialize(UniqueEmail unique) {
        unique.message();
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        userDao = new UserDaoImpl();
        User userFound = userDao.findByEmail(user.getEmail());

        if (userFound == null) {
            logger.info("adresse email pas encore utilisé");
            return true;
        } else if (user.getUserId() == userFound.getUserId()) {
            logger.info("adresse email du même id");
            return true;
        } else {
            logger.info("adresse email utilisé");
            return false;
        }
    }
}
