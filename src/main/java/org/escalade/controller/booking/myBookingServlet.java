package org.escalade.controller.booking;

import org.escalade.model.dao.*;
import org.escalade.model.entity.Booking;
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
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "myBookingServlet", urlPatterns = "/user/myBooking")
public class myBookingServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(myBookingServlet.class);

    private BookingDao bookingDao;
    private TopoDao topoDao;
    private UserDao userDao;

    public void init() {
        bookingDao = new BookingDaoImpl();
        topoDao = new TopoDaoImpl();
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User owner = (User) session.getAttribute("user");

        // liste des demandes faites pour les topos de l'utilisateur
        List<Booking> requests = bookingDao.findByOwner(owner);
        HashMap<Booking, Map.Entry<Topo, User>> requestList = new HashMap<>();

        for (int i = 0; i < requests.size(); i++) {
            Booking booking = bookingDao.findById(requests.get(i).getBookingId());
            Topo topo = topoDao.findById(booking.getTopo().getTopoId());
            User user = userDao.findById(booking.getUser().getUserId());
            requestList.put(booking, new AbstractMap.SimpleEntry(topo, user));
        }


        // listes des demandes faite par l'utilisateur pour d'autres topos
        List<Booking> bookings = bookingDao.findByUser(owner);
        HashMap<Booking, Map.Entry<Topo, User>> bookingList = new HashMap<>();

        for (int j = 0; j < bookings.size(); j++) {
            Booking booking = bookingDao.findById(bookings.get(j).getBookingId());
            Topo topo = topoDao.findById(booking.getTopo().getTopoId());
            User user = userDao.findById(topo.getUser().getUserId());
            bookingList.put(booking, new AbstractMap.SimpleEntry(topo, user));
        }

        req.setAttribute("owner", owner);
        req.setAttribute("requestList", requestList);
        req.setAttribute("bookingList", bookingList);


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/booking/myBooking.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
