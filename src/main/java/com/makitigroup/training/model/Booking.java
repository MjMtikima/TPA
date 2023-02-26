package com.makitigroup.training.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "booking")
public class Booking {
    @Id
    private String id;

    private String bookingItemId;

    private String customerId;
    private LocalDateTime date;
    private BookingStatusEnum status;

    public Booking(){
    }
    public Booking(String bookingItemId, String customerId ){
        this.bookingItemId = bookingItemId;
        this.customerId = customerId;
        this.status = BookingStatusEnum.PLACED;
        this.date = LocalDateTime.now();

    }

    public String getId() {
        return id;
    }
    public String getBookingItemId() {
        return bookingItemId;
    }

    public void setBookingItemId(String bookingItemId) {
        this.bookingItemId = bookingItemId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BookingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BookingStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", bookingItemId=" + bookingItemId + ", customerId=" + customerId + ", date=" + date + ", status=" + status.getValue() + "]";
    }
}
