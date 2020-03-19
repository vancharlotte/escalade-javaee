package org.escalade.model.service;

import org.escalade.model.dao.BookingDao;
import org.escalade.model.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDao bookingDao;

    @Override
    public List<Booking> list() {
       return bookingDao.list();
    }

}
