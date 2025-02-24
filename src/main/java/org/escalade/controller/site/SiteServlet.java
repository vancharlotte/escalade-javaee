package org.escalade.controller.site;

import org.escalade.model.dao.*;
import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Site;
import org.escalade.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static java.util.Map.Entry.comparingByKey;

@WebServlet(name = "SiteServlet", urlPatterns = "/site")
public class SiteServlet extends HttpServlet {
    static final Logger logger = LoggerFactory.getLogger(SiteServlet.class);

    private SiteDao siteDao;
    private CommentDao commentDao;

    public void init() {
        siteDao = new SiteDaoImpl();
        commentDao = new CommentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int siteId = Integer.parseInt(req.getParameter("siteId"));
        Site site = siteDao.findById(siteId);
        req.setAttribute("site", site);

        List<Comment> commentList = commentDao.findBySite(siteId);
        LinkedHashMap<Comment, String> commentMap = new LinkedHashMap<>();

        for (int i = 0; i < commentList.size(); i++) {
            User author = commentList.get(i).getUser();
            commentMap.put(commentList.get(i), author.getUsername());
        }

        req.setAttribute("commentList", commentList);
        req.setAttribute("commentMap", commentMap);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/site/Site.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
