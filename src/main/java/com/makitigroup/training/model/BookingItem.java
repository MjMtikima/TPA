package com.makitigroup.training.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "booking_item")
public class BookingItem{

    @Id
    private String id;

    private String courseId;

    private Integer maxPeople;

    private Integer registeredPeople;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Zagreb")
    private LocalDateTime startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Zagreb")
    private LocalDateTime endDate;
    private  BookingStatusEnum status;



    public String getId() {
        return id;
    }

    public BookingItem(){

    }

    public BookingItem(String courseId, Integer maxPeople, LocalDateTime startDate, LocalDateTime endDate, BookingStatusEnum status){
        this.courseId = courseId;
        this.maxPeople = maxPeople;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.registeredPeople = 0;

    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public BookingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BookingStatusEnum status) {
        this.status = status;
    }

    public Integer getRegisteredPeople() {
        return registeredPeople;
    }

    public void setRegisteredPeople(Integer registeredPeople) {
        this.registeredPeople = registeredPeople;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ",  courseId=" + courseId +  ",  registeredPeople=" + registeredPeople +", maxPeople=" + maxPeople + ", startDate=" + startDate.toString() + ", endDate=" + endDate.toString() +", status=" + status.getValue() + "]";
    }
}
