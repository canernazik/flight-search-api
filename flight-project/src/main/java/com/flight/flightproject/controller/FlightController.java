package com.flight.flightproject.controller;

import com.flight.flightproject.model.Flights;
import com.flight.flightproject.repository.FlightRepo;
import com.flight.flightproject.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepo repo;
    @Autowired
    private FlightService flightService;

    @PostMapping("/addFlight")
    public ResponseEntity<Flights> saveFlight(@RequestBody Flights flight){
        repo.save(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }
    @GetMapping("/findFlights/all")
    public List<Flights> getAllFlights() {

        return repo.findAll();
    }

    @GetMapping("/findFlights/{id}")
    public Optional<Flights> getFlight(@PathVariable String id) {

        return repo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable String id){
        if (repo.existsById(id)){
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateFlight/{id}")
    public Optional<Flights> updateFlight(@PathVariable String id, @RequestBody Flights updatedFlight) {
        return flightService.updateFlight(id, updatedFlight);
    }


    @PostMapping("/searchFlight")
    public List<Flights> searchFlights(@RequestBody Flights flights){
        return flightService.searchFlights(flights);
    }


}
