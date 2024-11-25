package com.mavencapital.MavenCapital.dto;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.kms.model.UnsupportedOperationException;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
    private List<BookingDTO> bookings = new ArrayList<>();
    public void setBookings(List<Object> collect) {
        throw new UnsupportedOperationException("Unimplemented method 'setBookings'");
    }
}
