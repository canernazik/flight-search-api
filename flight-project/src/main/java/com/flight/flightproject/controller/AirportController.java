package com.flight.flightproject.controller;

import com.flight.flightproject.model.Airports;
import com.flight.flightproject.repository.AirportRepo;
import com.flight.flightproject.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")

public class AirportController {
    @Autowired
    private AirportRepo repo;
    @Autowired
    private AirportService airportService;

    @PostMapping("/addAirport")
    public ResponseEntity<Airports> saveAirport(@RequestBody Airports airport){
        repo.save(airport);
        return new ResponseEntity<>(airport, HttpStatus.CREATED);
    }
    @GetMapping("/findAirports/all")
    public List<Airports> getAirports() {

        return repo.findAll();
    }

    @GetMapping("/findAirports/{id}")
    public Optional<Airports> getAirport(@PathVariable String id) {
        return repo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable String id){
        if (repo.existsById(id)){
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public Optional<Airports> updateAirport(@PathVariable String id, @RequestBody Airports updatedAirport) {
        return airportService.updateAirport(id, updatedAirport);
    }
}
