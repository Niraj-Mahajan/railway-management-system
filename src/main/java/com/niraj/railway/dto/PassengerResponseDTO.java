package com.niraj.railway.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerResponseDTO {

    private Long passengerId;
    private String name;
    private String email;
    private String phone;
}
