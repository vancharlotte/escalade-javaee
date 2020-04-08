package org.escalade.controller.search;

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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchSiteServlet", value = {"/user/searchSite", "/searchSite"})
public class SearchSiteServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(SearchSiteServlet.class);


    SiteDao siteDao;


    @Override
    public void init() throws ServletException {
        siteDao = new SiteDaoImpl();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("searchByName");
       // String quotation = req.getParameter("searchByQuotation");
        String city = req.getParameter("searchByCity");
        String departement = req.getParameter("searchByDepartement");
        String quotation = req.getParameter("searchByQuotation");
        
        String checkedString = req.getParameter("searchByChecked");
        boolean checked = true;
        if (checkedString==null) { checked=false; }


        List<Site> siteList = siteDao.search(name, city, departement, checked, quotation);
        //logger.info(siteList.toString());
        req.setAttribute("siteList", siteList);
        req.setAttribute("departementList", EntityUtil.InitDepartementList());
        req.setAttribute("quotationList", EntityUtil.InitQuotationList());


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/searchSite.jsp").forward(req, resp);

    }
}
