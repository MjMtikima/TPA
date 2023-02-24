package com.makitigroup.training.model;

import org.springframework.data.annotation.Id;


public class Customer {
    @Id
    private String id;

    private String name;

    private String email;

    private String addressCity;
    private String addressStreet;

    public Customer(){

    }

    public Customer(String name, String email, String addressCity, String addressStreet){
        this.name = name;
        this.email = email;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;

    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", email=" + email + ", addressCity=" + addressCity + ", name=" + addressCity +", addressStreet=" + addressStreet + "]";
    }
}
