package com.flight.flightproject.repository;
import com.flight.flightproject.model.Airports;
import com.flight.flightproject.model.Flights;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface FlightRepo extends MongoRepository<Flights, String> {
    @Query("{'departureAirport.$id' : ?0, 'landingAirport.$id' : ?1, departureTime : ?2")
    List<Flights> getFlights(String departureAirport, String landingAirport,Date departureTime);
    @Query("{'departureAirport.$id' : ?0, 'landingAirport.$id' : ?1, departureTime : ?2, returnTime : ?3}")
    List<Flights> getFlightsWithReturn(String departureAirport, String landingAirport,Date departureTime, Date returnTime);


}
