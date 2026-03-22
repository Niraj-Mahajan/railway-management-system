package com.niraj.railway.service;

import com.niraj.railway.dto.BookingResponseDTO;
import com.niraj.railway.entity.Booking;
import com.niraj.railway.entity.Schedule;
import com.niraj.railway.repository.BookingRepository;
import com.niraj.railway.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

//convert Booking to DTO
    public BookingResponseDTO convertToDTO(Booking booking) {
        return new BookingResponseDTO(
                booking.getBookingId(),
                booking.getPassenger().getName(),
                booking.getSchedule().getTrain().getTrainName(),
                booking.getSchedule().getRoute().getRouteName(),
                booking.getSeatNumber(),
                booking.getBookingDate(),
                booking.getStatus()
        );

    }

    public BookingResponseDTO addBooking(Booking booking){

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
        return convertToDTO(bookingRepository.save(booking));
    }
    public List<BookingResponseDTO> getAllBooking(){
        return bookingRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookingResponseDTO getBookingById(Long id){

       Booking booking =   bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
       return convertToDTO(booking);
    }

    public BookingResponseDTO updateBooking(Long id, Booking booking){

         Booking existing = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
         existing.setPassenger(booking.getPassenger());
         existing.setSchedule(booking.getSchedule());
         existing.setSeatNumber(booking.getSeatNumber());
         existing.setBookingDate(booking.getBookingDate());
         existing.setStatus(booking.getStatus());
         return convertToDTO(bookingRepository.save(existing));

    }

    public BookingResponseDTO cancelBooking(Long id) {
        //  Get booking
        Booking existing = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));

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
        return convertToDTO(bookingRepository.save(existing));
    }

    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }
}
