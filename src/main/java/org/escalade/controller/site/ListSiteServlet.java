package org.escalade.controller.site;

import org.escalade.model.dao.*;
import org.escalade.model.entity.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListSiteServlet", urlPatterns = "/listSite")
public class ListSiteServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(ListSiteServlet.class);

    SiteDao siteDao;

    public void init() {
        siteDao = new SiteDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNumber = 1;

        if(req.getParameter("page")!=null){
          pageNumber = Integer.parseInt(req.getParameter("page"));

        }

        logger.info("page " + pageNumber);

        List<Site> sites = siteDao.listPage(pageNumber);
        List<Site> siteList = siteDao.list();


        int rows = siteList.size();
        int recordsPerPage = 10;
        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        req.setAttribute("sites", sites);
        req.setAttribute("noOfPages", nOfPages);
        req.setAttribute("pageNumber", pageNumber);


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/site/listSite.jsp").forward(req, resp);
    }


}
