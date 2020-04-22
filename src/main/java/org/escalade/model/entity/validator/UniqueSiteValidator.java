package org.escalade.model.entity.validator;

import org.escalade.controller.site.AddSiteServlet;
import org.escalade.model.dao.SiteDao;
import org.escalade.model.dao.SiteDaoImpl;
import org.escalade.model.entity.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueSiteValidator implements ConstraintValidator<UniqueSite, Site> {

    static final Logger logger = LoggerFactory.getLogger(UniqueSiteValidator.class);

    SiteDao siteDao;

    private String message;

    @Override
    public void initialize(final UniqueSite constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Site site, ConstraintValidatorContext context) {

        siteDao = new SiteDaoImpl();
        Site siteFound = siteDao.findByName(site.getName());

        if (siteFound == null) {
            logger.info("pas d'autre site du même nom");
            return true;
        } else {
            if (site.getSiteId() == siteFound.getSiteId()) {
                logger.info("pas d'autre site du même nom à part même id");
                return true;
            } else {
                logger.info("site du même nom");
                return false;
            }
        }
    }
}
