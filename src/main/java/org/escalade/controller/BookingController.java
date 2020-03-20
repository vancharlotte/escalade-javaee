package org.escalade.controller;

import org.escalade.model.dao.BookingDao;
import org.escalade.model.dao.BookingDaoImpl;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.Booking;
import org.escalade.model.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet
public class BookingController {


    BookingDao userDao;
    public void init() {
        userDao = new BookingDaoImpl();
    }

    static final Logger logger = LoggerFactory.getLogger(UserController.class);
/*
    doGet (value = "/user/{id}/booking")
    public ModelAndView myTopo() {
        List<Booking> list = bookingService.list();
        ModelAndView mav = new ModelAndView("booking/myBooking");
        mav.addObject("list", list);
        return mav;

    }*/
}
