package org.escalade.model.entity.validator;

import org.escalade.model.dao.SiteDao;
import org.escalade.model.dao.SiteDaoImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueSiteValidator implements ConstraintValidator<UniqueSite, String> {

    SiteDao siteDao;

    @Override
    public void initialize(UniqueSite unique) {
        unique.message();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        siteDao = new SiteDaoImpl();

        if (siteDao.findByName(name) != null) {
            return false;
        } else {
            return true;
        }
    }
}
