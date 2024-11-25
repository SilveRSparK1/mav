package com.mavencapital.MavenCapital.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "bookings")
public class Booking{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Check-In Date is required") 
    private LocalDate checkInDate;
    @Future(message = "Check-Out Date must be in the future") // you can't give same day as checkout date, only a future date
    private LocalDate checkOutDate;

    @Min(value = 1, message = "Number of adults must not be less than 1") // setting a minimum value to how many people as a group can book one room
    private int numOfAdults;

    @Min(value = 0, message = "Number of adults must not be less than 0") 
    private int numOfChildren;

    private int totalNumOfGuest;

    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER) // check actively for a room
    @JoinColumn(name = "user_id") //many bookings can be done by one user
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) //don't want to actively check for a room
    @JoinColumn(name = "room_id") 
    private Room room;

    public void calculateTotalNumberOfGuest() {
        this.totalNumOfGuest = this.numOfAdults + this.numOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

    @Override
    public String toString() {
        return "Booking [id=" + id + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
                + ", numOfAdults=" + numOfAdults + ", numOfChildren=" + numOfChildren + ", totalNumOfGuest="
                + totalNumOfGuest + ", bookingConfirmationCode=" + bookingConfirmationCode + ", user=" + user
                + ", room=" + room + "]";
    }
}
