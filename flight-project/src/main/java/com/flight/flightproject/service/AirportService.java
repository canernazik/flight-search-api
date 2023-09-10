package com.flight.flightproject.service;

import com.flight.flightproject.model.Airports;
import com.flight.flightproject.repository.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AirportService {
    @Autowired
    private AirportRepo repo;

    public Optional<Airports> updateAirport(String id, Airports updatedAirport) {
        Optional<Airports> existingAirport = repo.findById(id);
        if (existingAirport.isPresent()) {
            Airports airport = existingAirport.get();
            airport.setCity(updatedAirport.getCity());
            repo.save(airport);
        }
        return existingAirport;
    }
}
