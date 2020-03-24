package org.escalade.controller.site;

import org.escalade.controller.topo.TopoServlet;
import org.escalade.model.dao.*;
import org.escalade.model.entity.Comment;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SiteServlet", urlPatterns = "/site")
public class SiteServlet extends HttpServlet {
    static final Logger logger = LoggerFactory.getLogger(SiteServlet.class);

    SiteDao siteDao;
    CommentDao commentDao;
    UserDao userDao;

    public void init() {
        siteDao = new SiteDaoImpl();
        commentDao = new CommentDaoImpl();
        userDao = new UserDaoImpl();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int siteId = Integer.parseInt(req.getQueryString());
        Site site = siteDao.findById(siteId);
        req.setAttribute("site", site);
        logger.info("site id :" + siteId);
        logger.info("site nom " + site.getName());

        List<Comment> commentList = commentDao.findBySite(siteId);
        HashMap<Comment, String> commentMap = new HashMap<>();

        for (int i = 0; i < commentList.size(); i++) {

            User author = commentList.get(i).getUser();
            commentMap.put(commentList.get(i), author.getUsername());
            logger.info("comment : " + commentList.get(i).getTitle() + "author : " + author.getUsername());

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
