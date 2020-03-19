package org.escalade.controller;

import org.escalade.model.entity.Booking;
import org.escalade.model.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/user/{id}/booking")
    public ModelAndView myTopo() {
        List<Booking> list = bookingService.list();
        ModelAndView mav = new ModelAndView("booking/myBooking");
        mav.addObject("list", list);
        return mav;

    }
}
