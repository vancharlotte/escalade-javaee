package org.escalade.controller.topo;

import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
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
import java.util.List;

@WebServlet(name = "MyTopoServlet", urlPatterns = {"/user/myTopo", "/myTopo"})
public class MyTopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(MyTopoServlet.class);

    TopoDao topoDao;

    public void init() {
        topoDao = new TopoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        List<Topo> list= topoDao.findByUser(user);

        req.setAttribute("list", list);
        logger.info("topo : "+ list);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/myTopo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}


