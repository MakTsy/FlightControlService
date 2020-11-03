package com.flight.demo.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.flight.demo.entities.Flight;
import com.flight.demo.entities.dto.FlightDTO;
import com.flight.demo.services.FlightControllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flights")
public class FlightControlController {
    private final FlightControllService flightControllService;

    @Autowired
    public FlightControlController(FlightControllService flightControllService) {
        this.flightControllService = flightControllService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> createFlight(@RequestBody String delJson) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        FlightDTO flightDTO = gson.fromJson(delJson, FlightDTO.class);
        this.flightControllService.addFlight(new Flight(flightDTO.departureDate, flightDTO.arrivalDate, flightDTO.departing,
                flightDTO.arriving, flightDTO.checkInOpens, flightDTO.status, flightDTO.economClassSeat,
                flightDTO.firstClassSeat, flightDTO.businessClassSeat, flightDTO.economClassPrice,
                flightDTO.firstClassPrice, flightDTO.businessClassPrice));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getFlights", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> sendFlights() {
        Gson json = new Gson();
        String ans = json.toJson(this.flightControllService.getFlights());
        return new ResponseEntity<String>(ans, HttpStatus.OK);
    }

}

