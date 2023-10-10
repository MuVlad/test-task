package com.gridnine.testing.filters;


import com.gridnine.testing.model.Flight;
import com.gridnine.testing.repository.Repository;

public class FlightFilterServiceFactory {

    private final Repository<Flight> repository;

    public FlightFilterServiceFactory(Repository<Flight> repository) {
        this.repository = repository;
    }

    public FilterService<Flight> getArrivalBeforeDepartureFilter() {
        return new ArrivalBeforeDepartureFilter(repository);
    }

    public FilterService<Flight> getArrivalDateBeforeDepartureDateFilter() {
        return new ArrivalDateBeforeDepartureDateFilter(repository);
    }

    public FilterService<Flight> getDepartureBeforeTheCurrentTimeFilter() {
        return new DepartureBeforeTheCurrentTimeFilter(repository);
    }
}
