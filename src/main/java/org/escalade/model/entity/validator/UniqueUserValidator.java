package org.escalade.model.entity.validator;

import org.escalade.model.dao.SiteDaoImpl;
import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.Site;
import org.escalade.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserValidator implements ConstraintValidator<UniqueUser, User> {

    static final Logger logger = LoggerFactory.getLogger(UniqueUserValidator.class);

    UserDao userDao;

    @Override
    public void initialize(UniqueUser unique) {
        unique.message();
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        userDao = new UserDaoImpl();
        User userFound = userDao.findByUsername(user.getUsername());

        if (userFound == null) {
            logger.info("pas d'autre utilisateur du même nom");
            return true;
        } else if (user.getUserId() == userFound.getUserId()) {
            logger.info("pas d'autre utilisateur du même nom à part même id");
            return true;
        } else {
            logger.info("utilisateur du même nom");
            return false;
        }
    }
}
