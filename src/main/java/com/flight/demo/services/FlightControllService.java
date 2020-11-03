package com.flight.demo.services;


import com.flight.demo.entities.Flight;
import com.flight.demo.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class FlightControllService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightControllService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Transactional
    public void addFlight(Flight flight) {
        this.flightRepository.save(flight);
    }

    @Transactional
    public List<Flight> getFlights() {
        return this.flightRepository.findAll();
    }

    @Transactional
    public void updateFlight(Flight flight) {
        this.flightRepository.save(flight);
    }

    @Transactional
    public void deleteFlight(Flight flight) {
        this.flightRepository.delete(flight);
    }

    @Transactional
    public Flight getFlight(UUID id) {
        return this.flightRepository.findById(id).orElseThrow();
    }
}
