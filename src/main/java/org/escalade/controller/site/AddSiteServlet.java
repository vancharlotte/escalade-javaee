package org.escalade.controller.site;

import org.escalade.model.dao.SiteDao;
import org.escalade.model.dao.SiteDaoImpl;
import org.escalade.model.entity.EntityUtil;
import org.escalade.model.entity.Site;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "AddSiteServlet", urlPatterns = "/user/addSite")

public class AddSiteServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(AddSiteServlet.class);

    SiteDao siteDao;

    public void init() {
        siteDao = new SiteDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", req.getParameter("message"));
        req.setAttribute("departementList", EntityUtil.InitDepartementList());
        req.setAttribute("quotationList", EntityUtil.InitQuotationList());

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/site/addSite.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Site site = new Site();

        site.setName(req.getParameter("name"));
        site.setCity(req.getParameter("city"));
        site.setDepartement(req.getParameter("departement"));
        site.setQuotationMin("quotationMin");
        site.setQuotationMax("quotationMax");
        site.setDescription(req.getParameter("description"));
        site.setNbRoutes(req.getParameter("nbRoutes"));
        site.setUser((User) session.getAttribute("user"));
        String checked = req.getParameter("checked");
        if (checked.equals("true")) {
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
            req.setAttribute("departementList", EntityUtil.InitDepartementList());
            req.setAttribute("quotationList", EntityUtil.InitQuotationList());

            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/site/addSite.jsp").forward(req, resp);

        } else {
            siteDao.save(site);
            logger.info("save new site");


            resp.sendRedirect(req.getContextPath() + "/site?" + site.getSiteId());

        }
    }
}
