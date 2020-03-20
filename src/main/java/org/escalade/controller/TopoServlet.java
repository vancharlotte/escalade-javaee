package org.escalade.controller;

import org.escalade.config.HibernateUtil;
import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TopoServlet", urlPatterns = {"/myTopo"})
public class TopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(TopoServlet.class);

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
        logger.info(this.getServletContext().toString());

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/myTopo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /*
    @Autowired
    TopoService topoService;

    @Autowired
    UserService userService;


    static final Logger logger = LoggerFactory.getLogger(TopoController.class);

    @GetMapping(value = "user/myTopo")
    public ModelAndView myTopo(@SessionAttribute("user") User user) {
        List<Topo> list = topoService.findByUser(user);
        logger.info(list.toString());
        ModelAndView mav = new ModelAndView("topo/myTopo");
        mav.addObject("topoList", list);
        return mav;

    }


    @GetMapping(value = "/user/addTopo")
    public ModelAndView addTopo() {
        return new ModelAndView("topo/addTopo", "topo", new Topo());

    }

    @PostMapping(value = "/user/addTopo")
    public String successTopo(@SessionAttribute("user") User user, @Valid @ModelAttribute("topo") @Validated Topo topo,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "topo/addTopo";
        } else {
            topo.setUser(user);
            topoService.save(topo);
            return "redirect:/user/myTopo";
        }
    }

    @GetMapping(value = "/user/editTopo/{topoId}")
    public ModelAndView editTopo(@PathVariable int topoId) {
        Topo editTopo = topoService.findById(topoId);
        return new ModelAndView("topo/editTopo", "topo", editTopo);
    }

    @PostMapping(value = "/user/editTopo/{topoId}")
    public String successEditTopo(@SessionAttribute("user") User user, @Valid @ModelAttribute("topo") @Validated Topo topo,
                                  BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "topo/editTopo";
        } else {
            topo.setUser(user);
            topoService.update(topo);
            return "redirect:/user/myTopo";
        }
    }

    @GetMapping(value = "/user/deleteTopo/{topoId}")
    public String deleteTopo(@PathVariable int topoId) {
        topoService.delete(topoService.findById(topoId));
        return "redirect:/user/myTopo";

    }

    @GetMapping(value = "/user/editStatus/{topoId}")
    public ModelAndView editStatus(@PathVariable int topoId) {
        Topo editTopo = topoService.findById(topoId);
        return new ModelAndView("topo/editStatus", "topo", editTopo);
    }

    @PostMapping(value = "/user/editStatus/{topoId}")
    public String successEditStatus(@PathVariable int topoId, @ModelAttribute("topo") Topo topo,
                                    BindingResult result) {
        Topo updateTopo = topoService.findById(topoId);
        updateTopo.setAvailable(topo.isAvailable());
        if (result.hasErrors()) {
            logger.info(result.toString());
            return "topo/editStatus";
        } else {
            topoService.update(updateTopo);
            return "redirect:/user/myTopo";
        }
    }*/
}


