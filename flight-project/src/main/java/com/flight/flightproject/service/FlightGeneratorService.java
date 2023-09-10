package com.flight.flightproject.service;

import com.flight.flightproject.model.Airports;
import com.flight.flightproject.model.Flights;
import com.flight.flightproject.repository.AirportRepo;
import com.flight.flightproject.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Component
public class FlightGeneratorService {
    @Autowired
    FlightRepo flightRepo;
    @Autowired
    AirportRepo airportRepo;

    @Scheduled(cron = "0 0 7 * * ?")
    public void generateFlights() {
        List<Airports> airports = airportRepo.findAll();
        for (int i = 1; i <= 10; i++) {

            Airports departureAirport = getRandomAirport(airports);
            Airports landingAirport = getRandomAirport(airports);
            Date departureTime = generateRandomDate();
            Date returnTime = addRandomHoursToDate(departureTime);
            float price = generatePrice();
            Flights randomFlight = new Flights(null, departureAirport, landingAirport, departureTime, returnTime, price);
            flightRepo.save(randomFlight);
        }
    }

    public Date generateRandomDate() {
        Random random = new Random();
        Date currentDate = new Date();
        long currentTimeMillis = currentDate.getTime();
        long maxTimeMillis = currentTimeMillis + (10L * 24 * 60 * 60 * 1000); // Şu andan 10 gün sonrası (milisaniye cinsinden)

        long randomTimeMillis = currentTimeMillis + (long) (random.nextDouble() * (maxTimeMillis - currentTimeMillis));
        Date randomDate = new Date(randomTimeMillis);
        return randomDate;
    }

    public Date addRandomHoursToDate(Date randomDate) {
        Random random = new Random();
        int randomHoursToAdd = random.nextInt(10) + 1;
        long timeToAddMillis = randomHoursToAdd * 60 * 60 * 1000;
        long finalTimeMillis = randomDate.getTime() + timeToAddMillis;

        Date randomDateWithRandomTime = new Date(finalTimeMillis);
        return randomDateWithRandomTime;
    }

    public float generatePrice() {
        Random random = new Random();
        float min = 1.0f;
        float max = 10.0f;

        float price = min + random.nextFloat() * (max - min);
        return price;
    }

    public Airports getRandomAirport(List<Airports> allDocuments) {
        if (!allDocuments.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(allDocuments.size());
            Airports airport = allDocuments.get(randomIndex);
            return airport;
        }

        return null;

    }
}
