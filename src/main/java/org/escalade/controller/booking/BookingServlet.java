package org.escalade.controller.booking;

import org.escalade.model.dao.BookingDao;
import org.escalade.model.dao.BookingDaoImpl;
import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Topo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookingServlet", urlPatterns = {"/rejectBooking", "/acceptBooking", "/cancelBooking"})
public class BookingServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(BookingServlet.class);

    BookingDao bookingDao;
    TopoDao topoDao;

    public void init() {
        bookingDao = new BookingDaoImpl();
        topoDao = new TopoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookingId = Integer.parseInt(req.getParameter("bookingId"));

        Booking booking = bookingDao.findById(bookingId);
        req.setAttribute("booking", booking);
        logger.info(req.getRequestURL().toString());

        if (req.getRequestURL().toString().contains("reject")) {
            booking.setStatus("refusée");
            bookingDao.update(booking);
            resp.sendRedirect(req.getContextPath() + "/user/myBooking");
        } else if (req.getRequestURL().toString().contains("cancel")) {
            booking.setStatus("annulée");
            bookingDao.update(booking);
            resp.sendRedirect(req.getContextPath() + "/user/myBooking");
        } else if (req.getRequestURL().toString().contains("accept")) {
            booking.setStatus("acceptée");
            bookingDao.update(booking);
            Topo topo = topoDao.findById(booking.getTopo().getTopoId());
            topo.setAvailable(false);
            topoDao.update(topo);
            logger.info("demande acceptée");
            resp.sendRedirect(req.getContextPath() + "/user/myBooking");
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/editTopo.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
