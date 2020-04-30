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

@WebServlet(name = "AddTopoServlet", urlPatterns = {"/user/addTopo", "/addTopo"})

public class AddTopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(AddTopoServlet.class);

    private TopoDao topoDao;

    public void init() {
        topoDao = new TopoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", req.getParameter("message"));
        req.setAttribute("departementList", EntityUtil.InitDepartementList());

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/addTopo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Topo topo = new Topo();

        topo.setName(req.getParameter("name"));
        topo.setDescription(req.getParameter("description"));
        topo.setCity(req.getParameter("city"));
        topo.setDepartement(req.getParameter("departement"));
        topo.setReleaseDate(req.getParameter("releaseDate"));
        topo.setUser((User) session.getAttribute("user"));

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
            req.setAttribute("departementList", EntityUtil.InitDepartementList());
            logger.info("error save topo");
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/addTopo.jsp").forward(req, resp);

        } else {

            topoDao.save(topo);
            logger.info("success save topo");
            resp.sendRedirect(req.getContextPath() + "/user/myTopo");

        }


    }
}
