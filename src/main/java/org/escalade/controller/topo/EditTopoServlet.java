package org.escalade.controller.topo;

import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.entity.EntityUtil;
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

@WebServlet(name = "EditTopoServlet", urlPatterns = {"/user/editTopo", "/user/editStatusTopo", "/user/deleteTopo"})
public class EditTopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(AddTopoServlet.class);

    private TopoDao topoDao;

    public void init() {
        topoDao = new TopoDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int topoId = Integer.parseInt(req.getParameter("topoId"));

        Topo topo = topoDao.findById(topoId);
        req.setAttribute("topo", topo);
        req.setAttribute("departementList", EntityUtil.InitDepartementList());

        if (req.getRequestURL().toString().contains("Status")) {
            if (topo.isAvailable()) {
                topo.setAvailable(false);
            } else {
                topo.setAvailable(true);
            }
            topoDao.update(topo);
            logger.info("success update topo");
            resp.sendRedirect(req.getContextPath() + "/user/myTopo");

        } else if (req.getRequestURL().toString().contains("deleteTopo")) {
            topoDao.delete(topo);
            logger.info("success delete topo");
            resp.sendRedirect(req.getContextPath() + "/user/myTopo");

        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/editTopo.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int topoId = Integer.parseInt(req.getParameter("topoId"));
        Topo topo = topoDao.findById(topoId);
        logger.info("selected topo : name " + topo.getName() + ",id : " +topo.getTopoId());

        topo.setName(req.getParameter("name"));
        topo.setDescription(req.getParameter("description"));
        topo.setCity(req.getParameter("city"));
        topo.setDepartement(req.getParameter("departement"));
        topo.setReleaseDate(req.getParameter("releaseDate"));

        String available = req.getParameter("available");
        if (available.equals("true")) {
            topo.setAvailable(true);
        } else {
            topo.setAvailable(false);
        }

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Topo>> errors = validator.validate(topo);

        if (!errors.isEmpty()) {
            String errorList = "<ul>";
            for (ConstraintViolation<Topo> constraintViolation : errors) {
                errorList += "<li> " + constraintViolation.getMessage()
                        + "</li>";
            }
            errorList += "</ul>";
            req.setAttribute("message", errorList);
            req.setAttribute("topo", topo);
            req.setAttribute("departementList", EntityUtil.InitDepartementList());

            logger.info("error update topo");

            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/editTopo.jsp").forward(req, resp);

        } else {
            topoDao.update(topo);

            logger.info("success update topo");

            resp.sendRedirect(req.getContextPath() + "/user/myTopo");
        }

    }
}
