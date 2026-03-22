package com.niraj.railway.service;

import com.niraj.railway.entity.Booking;
import com.niraj.railway.entity.Schedule;
import com.niraj.railway.repository.BookingRepository;
import com.niraj.railway.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;


    public Booking addBooking(Booking booking){

        //  Get the schedule
        Schedule schedule = scheduleRepository.findById(booking.getSchedule().getScheduleId())
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        //  Check available seats
        if (schedule.getAvailableSeats() <= 0) {
            throw new RuntimeException("No seats available for this schedule");
        }

        // Reduce seat count
        schedule.setAvailableSeats(schedule.getAvailableSeats() - 1);
        scheduleRepository.save(schedule);

        //  Save booking
        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }
    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id){

        return  bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking updateBooking(Long id, Booking booking){

         Booking existing = getBookingById(id);
         existing.setPassenger(booking.getPassenger());
         existing.setSchedule(booking.getSchedule());
         existing.setSeatNumber(booking.getSeatNumber());
         existing.setBookingDate(booking.getBookingDate());
         existing.setStatus(booking.getStatus());
         return bookingRepository.save(existing);

    }

    public Booking cancelBooking(Long id) {
        //  Get booking
        Booking existing = getBookingById(id);

        // Check if already cancelled
        if (existing.getStatus().equals("CANCELLED")) {
            throw new RuntimeException("Booking is already cancelled");
        }

        //  Restore seat count
        Schedule schedule = existing.getSchedule();
        schedule.setAvailableSeats(schedule.getAvailableSeats() + 1);
        scheduleRepository.save(schedule);

        //  Update status
        existing.setStatus("CANCELLED");
        return bookingRepository.save(existing);
    }

    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }
}
