package org.escalade.model.entity.validator;

import org.escalade.controller.site.AddSiteServlet;
import org.escalade.model.dao.SiteDao;
import org.escalade.model.dao.SiteDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueSiteValidator implements ConstraintValidator<UniqueSite, String> {

    static final Logger logger = LoggerFactory.getLogger(UniqueSiteValidator.class);

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
            logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
            return false;
        } else {
            logger.info("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
            return true;
        }
    }
}
