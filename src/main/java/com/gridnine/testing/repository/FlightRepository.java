package com.gridnine.testing.repository;


import com.gridnine.testing.builders.FlightBuilder;
import com.gridnine.testing.model.Flight;

import java.util.List;

public class FlightRepository implements Repository<Flight> {

    private final List<Flight> flights;

    public FlightRepository() {
        this.flights = FlightBuilder.createFlights();
    }

    @Override
    public List<Flight> getAll() {
        return flights;
    }
}
