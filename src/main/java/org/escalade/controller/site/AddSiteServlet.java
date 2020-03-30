package org.escalade.controller.site;

import org.escalade.model.dao.SiteDao;
import org.escalade.model.dao.SiteDaoImpl;
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
import java.io.IOException;

@WebServlet(name = "AddSiteServlet", urlPatterns ="/addSite")

public class AddSiteServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(AddSiteServlet.class);

    SiteDao siteDao;

    public void init() {
        siteDao = new SiteDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", req.getParameter("message"));

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/site/addSite.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Site site = new Site();

        site.setName(req.getParameter("site"));
        site.setCity(req.getParameter("city"));
        site.setDepartement(req.getParameter("departement"));
        site.setQuotationMin("quotationMin");
        site.setQuotationMax("quotationMax");
        site.setDescription(req.getParameter("description"));
        site.setUser((User) session.getAttribute("user"));
        String checked = req.getParameter("checked");
        if (checked.equals("true")) {
            site.setChecked(true);
        } else {
            site.setChecked(false);
        }


        siteDao.save(site);
        logger.info("save new site");

        resp.sendRedirect(req.getContextPath() + "/Site?" + site.getSiteId());
        //a vérifier
    }
}
