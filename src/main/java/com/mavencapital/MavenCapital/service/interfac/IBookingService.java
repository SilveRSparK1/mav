package com.mavencapital.MavenCapital.service.interfac;

import com.mavencapital.MavenCapital.dto.Response;
import com.mavencapital.MavenCapital.entity.Booking;

public interface IBookingService {
    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);
}
