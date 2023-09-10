package com.flight.flightproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "flights")

public class Flights {
    @Id
    private String id;
    @DBRef
    private Airports departureAirport;
    @DBRef
    private Airports landingAirport;
    private Date departureTime;

    public Flights(String id, Airports departureAirport, Airports landingAirport, Date departureTime, Date returnTime, float price) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.landingAirport = landingAirport;
        this.departureTime = departureTime;
        this.returnTime = returnTime;
        this.price = price;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Airports getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airports departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airports getLandingAirport() {
        return landingAirport;
    }

    public void setLandingAirport(Airports landingAirport) {
        this.landingAirport = landingAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private Date returnTime;
    private float price;


}

