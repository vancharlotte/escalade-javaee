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

@WebServlet(name = "SearchSiteServlet", value = {"/user/searchSite", "/searchSite",  "/admin/searchSite"})
public class SearchSiteServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(SearchSiteServlet.class);

    private SiteDao siteDao;

    @Override
    public void init() throws ServletException {
        siteDao = new SiteDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name")==null? "" : req.getParameter("name");
        String city = req.getParameter("city")==null? "" : req.getParameter("city");
        String departement = req.getParameter("departement")==null? "" : req.getParameter("departement");
        String nbRoutes = req.getParameter("nbRoutes")==null? "" : req.getParameter("nbRoutes");
        String quotation = req.getParameter("quotation")==null? "" : req.getParameter("quotation");
        String checkedString = req.getParameter("checked")==null? "false" : req.getParameter("checked");
        boolean checked = checkedString.equals("true");

        logger.info("Site, selected criteria for research : name " +  name);

        List<Site> siteList = siteDao.search(name, city, departement,nbRoutes, checked, quotation);

        req.setAttribute("siteList", siteList);
        req.setAttribute("departementList", EntityUtil.InitDepartementList());
        req.setAttribute("quotationList", EntityUtil.InitQuotationList());

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/searchSite.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("searchByName")==null? "" : req.getParameter("searchByName");
        String city = req.getParameter("searchByCity")==null? "" : req.getParameter("searchByCity");
        String departement = req.getParameter("searchByDepartement")==null? "" : req.getParameter("searchByDepartement");
        String nbRoutes = req.getParameter("searchByNbRoutes")==null? "" : req.getParameter("searchByNbRoutes");
        String quotation = req.getParameter("searchByQuotation")==null? "" : req.getParameter("searchByQuotation");
        String checkedString = req.getParameter("searchByChecked")==null? "false" :"true";
        boolean checked = checkedString.equals("true");

        List<Site> siteList = siteDao.search(name, city, departement,nbRoutes, checked, quotation);
        req.setAttribute("siteList", siteList);
        req.setAttribute("departementList", EntityUtil.InitDepartementList());
        req.setAttribute("quotationList", EntityUtil.InitQuotationList());

        logger.info("Site, selected criteria for research : name " +  name + " ,city " +  city + " ,departement " + departement + " ,nbRoutes " + nbRoutes + " ,quotation " + quotation + " ,checked" + checkedString );

        resp.sendRedirect(req.getContextPath() + "/searchSite?name="+ name +"&city=" + city+"&departement=" + departement +
                "&nbRoutes=" + nbRoutes + "&quotation="+ quotation +"&checked="+ checked);

    }
}
