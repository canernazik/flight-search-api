package com.flight.flightproject.repository;
import com.flight.flightproject.model.Airports;
import com.flight.flightproject.model.Flights;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface AirportRepo extends MongoRepository<Airports, String> {

}
