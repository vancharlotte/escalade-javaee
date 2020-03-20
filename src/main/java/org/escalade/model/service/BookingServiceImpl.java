package org.escalade.model.service;

import org.escalade.model.dao.BookingDao;
import org.escalade.model.entity.Booking;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    BookingDao bookingDao;

    @Override
    public List<Booking> list() {
       return bookingDao.list();
    }

}
