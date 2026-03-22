package com.niraj.railway.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {
    private Long bookingId;
    private String passengerName;
    private String trainName;
    private String routeName;
    private Integer seatNumber;
    private String bookingDate;
    private String status;
}
