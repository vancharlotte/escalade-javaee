package org.escalade.controller.booking;

import org.escalade.model.dao.BookingDao;
import org.escalade.model.dao.BookingDaoImpl;
import org.escalade.model.entity.Booking;
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

@WebServlet(name="BookingServlet" , urlPatterns = "/myBooking")
public class BookingServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(BookingServlet.class);

    BookingDao bookingDao;

    public void init() {
        bookingDao = new BookingDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        //demande faite pour topos de l'utilisateur
        // find topo de l'utlisateur puis booking dessus puis order by status"en attente".
        //rajouter proprriétaire de topo sur entity booking
        List<Booking> requestList= bookingDao.findByOwner(user);
        req.setAttribute("requestList", requestList);


        // demande faite par l'utilisateur
        List<Booking> bookingList= bookingDao.findByUser(user);
        req.setAttribute("bookingList", bookingList);


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/booking/myBooking.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
