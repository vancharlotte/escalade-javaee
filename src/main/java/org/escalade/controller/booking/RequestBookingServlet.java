package org.escalade.controller.booking;

import org.escalade.model.dao.BookingDao;
import org.escalade.model.dao.BookingDaoImpl;
import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RequestBookingServlet", urlPatterns = "/user/booking")
public class RequestBookingServlet extends HttpServlet {

    BookingDao bookingDao;
    TopoDao topoDao;

    public void init() {
        bookingDao = new BookingDaoImpl();
        topoDao = new TopoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int topoId = Integer.parseInt(req.getQueryString());
        Topo topo = topoDao.findById(topoId);

        User user = (User) req.getSession().getAttribute("user");

        Booking booking = new Booking();
        booking.setTopo(topo);
        booking.setStatus("en attente");
        booking.setUser(user);
        bookingDao.save(booking);

        req.setAttribute("user", user);
        req.setAttribute("message",
                "demande envoyée! Votre adresse email a été transmise au propriétaire du topo. Il prendra contact avec vous rapidement.");

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/page.jsp").forward(req, resp);


    }

}
