package com.makitigroup.training.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Arrays;

@Document(collection = "course")
public class Course {
    @Id
    private String id;

    private String name;
    private String description;
    private String[] lecturers;

    private double price;

    private String currency;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private int maxPeople;

    public int getRegisteredPeople() {
        return registeredPeople;
    }

    public void setRegisteredPeople(int registeredPeople) {
        this.registeredPeople = registeredPeople;
    }

    private int registeredPeople;



    public Course() {

    }

    public Course(String name, String description, String[] lecturers) {
        this.name = name;
        this.description = description;
        this.lecturers = lecturers;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getLecturers() {
        return lecturers;
    }

    public void setLecturers(String[] lecturers) {
        this.lecturers = lecturers;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", description=" + description + ", lecturers=" + Arrays.toString(lecturers) + "]";
    }
}
