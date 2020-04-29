package org.escalade.controller.site;

import org.escalade.model.dao.SiteDao;
import org.escalade.model.dao.SiteDaoImpl;
import org.escalade.model.entity.EntityUtil;
import org.escalade.model.entity.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "EditSiteServlet", value = {"/editSite", "/admin/editSite", "/admin/deleteSite", "/admin/editChecked"})
public class EditSiteServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(EditSiteServlet.class);

    SiteDao siteDao;

    @Override
    public void init() throws ServletException {
        siteDao = new SiteDaoImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int siteId = Integer.parseInt(req.getParameter("siteId"));
        Site site = siteDao.findById(siteId);
        req.setAttribute("departementList", EntityUtil.InitDepartementList());
        req.setAttribute("quotationList", EntityUtil.InitQuotationList());


        if (req.getRequestURL().toString().contains("editChecked")) {
            if (site.isChecked()) {
                site.setChecked(false);
            } else {
                site.setChecked(true);
            }
            siteDao.update(site);
            resp.sendRedirect(req.getContextPath() + "/site?siteId=" + site.getSiteId());

        } else if (req.getRequestURL().toString().contains("deleteSite")) {
            siteDao.delete(site);
            resp.sendRedirect(req.getContextPath() + "/search");

        } else {

            req.setAttribute("site", site);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/site/editSite.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int siteId = Integer.parseInt(req.getParameter("siteId"));
        Site site = siteDao.findById(siteId);
        logger.info("site : " + site.getName() + site.getSiteId());
        logger.info(site.getName()+"/"+req.getParameter("name"));

        if (!site.getName().equals(req.getParameter("name"))){
            logger.info(site.getName()+"/"+req.getParameter("name"));
        site.setName(req.getParameter("name"));}
        site.setCity(req.getParameter("city"));
        site.setDepartement(req.getParameter("departement"));
        site.setDescription(req.getParameter("description"));
        site.setQuotationMin(req.getParameter("quotationMin"));
        site.setQuotationMax(req.getParameter("quotationMax"));
        site.setNbRoutes(req.getParameter("nbRoutes"));

        String available = req.getParameter("checked");
        logger.info("checked?" + available);
        if (available.equals("true")) {
            site.setChecked(true);
        } else {
            site.setChecked(false);
        }

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Site>> errors = validator.validate(site);

        if (!errors.isEmpty()) {
            String errorList = "<ul>";
            for (ConstraintViolation<Site> constraintViolation : errors) {
                errorList += "<li> " + constraintViolation.getMessage()
                        + "</li>";
            }
            errorList += "</ul>";
            req.setAttribute("message", errorList);
            req.setAttribute("site", site);
            req.setAttribute("departementList", EntityUtil.InitDepartementList());
            req.setAttribute("quotationList", EntityUtil.InitQuotationList());

            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/site/editSite.jsp").forward(req, resp);

        } else {
            siteDao.update(site);
            logger.info("update site");

            resp.sendRedirect(req.getContextPath() + "/site?siteId=" + site.getSiteId());
        }
    }
}
