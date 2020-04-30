package org.escalade.controller.booking;

import org.escalade.model.dao.BookingDao;
import org.escalade.model.dao.BookingDaoImpl;
import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.entity.Booking;
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
import java.io.IOException;

@WebServlet(name = "RequestBookingServlet", urlPatterns = {"/booking", "/user/booking"})
public class RequestBookingServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(RequestBookingServlet.class);

    private BookingDao bookingDao;
    private TopoDao topoDao;

    public void init() {
        bookingDao = new BookingDaoImpl();
        topoDao = new TopoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int topoId = Integer.parseInt(req.getParameter("topoId"));
        Topo topo = topoDao.findById(topoId);

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.setAttribute("message", "Vous devez être connecté pour faire une demande de réservation.");
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);

        } else if (bookingDao.checkAvailability(topo, user) != null) {
            resp.sendRedirect(req.getContextPath() + "/topo?topoId=" + topo.getTopoId() + "&error=error");

        } else {
            Booking booking = new Booking();
            booking.setTopo(topo);
            booking.setStatus("en attente");
            booking.setUser(user);
            bookingDao.save(booking);

            resp.sendRedirect(req.getContextPath() + "/user/myBooking");

        }
    }

}
