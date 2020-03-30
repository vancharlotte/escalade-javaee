package org.escalade.controller.site;

import org.escalade.controller.topo.AddTopoServlet;
import org.escalade.model.dao.SiteDao;
import org.escalade.model.dao.SiteDaoImpl;
import org.escalade.model.entity.Site;
import org.escalade.model.entity.Topo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditSiteServlet", value = {"/admin/editSite", "/admin/deleteSite", "/admin/editChecked"})
public class EditSiteServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(EditSiteServlet.class);

    SiteDao siteDao;

    @Override
    public void init() throws ServletException {
        siteDao = new SiteDaoImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int siteId = Integer.parseInt(req.getQueryString());
        Site site = siteDao.findById(siteId);

        if (req.getRequestURL().toString().contains("Status")) {
            if (site.isChecked()) {
                site.setChecked(false);
            } else {
                site.setChecked(true);
            }
            siteDao.update(site);
            resp.sendRedirect(req.getContextPath() + "/Site?" + site.getSiteId());
            //a vérifier
        } else if (req.getRequestURL().toString().contains("delete")) {
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
        logger.info("topo : " + site.getName() + site.getSiteId());

        site.setName(req.getParameter("name"));
        site.setCity(req.getParameter("city"));
        site.setDepartement(req.getParameter("departement"));
        site.setDescription(req.getParameter("description"));
        site.setQuotationMin(req.getParameter("quotationMin"));
        site.setQuotationMax(req.getParameter("quotationMax"));

        String available = req.getParameter("checked");
        logger.info("checked?" + available);
        if (available.equals("true")) {
            site.setChecked(true);
        } else {
            site.setChecked(false);
        }

        siteDao.update(site);

        resp.sendRedirect(req.getContextPath() + "/Site?" + site.getSiteId());
        //a vérifier
    }
}
