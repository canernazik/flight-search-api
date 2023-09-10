package com.flight.flightproject.service;

import com.flight.flightproject.model.Flights;
import com.flight.flightproject.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service

public class FlightService {
    @Autowired
    private FlightRepo repo;

    public Optional<Flights> updateFlight(String id, Flights updatedFlight) {
        Optional<Flights> existingFlight = repo.findById(id);
        if (existingFlight.isPresent()) {
            Flights flight = existingFlight.get();
            flight.setDepartureAirport(updatedFlight.getDepartureAirport());
            flight.setDepartureTime(updatedFlight.getDepartureTime());
            flight.setPrice(updatedFlight.getPrice());
            flight.setReturnTime(updatedFlight.getReturnTime());
            flight.setLandingAirport(updatedFlight.getLandingAirport());
            repo.save(flight);
        }
        return existingFlight;
    }
    public List<Flights> searchFlights(Flights flight){
        List<Flights> flights;
        if (flight.getReturnTime()==null){
            flights=repo.getFlights(flight.getDepartureAirport().getId(),flight.getLandingAirport().getId(),flight.getDepartureTime());
        }
        else{
            flights=repo.getFlightsWithReturn(flight.getDepartureAirport().getId(),
                    flight.getLandingAirport().getId(),flight.getDepartureTime(),flight.getReturnTime());
        }
        return flights;
    }

}
