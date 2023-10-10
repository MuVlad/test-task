package com.gridnine.testing;


import com.gridnine.testing.filters.FilterService;
import com.gridnine.testing.filters.FlightFilterServiceFactory;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.repository.FlightRepository;
import com.gridnine.testing.repository.Repository;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Repository<Flight> repository = new FlightRepository();
        FlightFilterServiceFactory flightFilterServiceFactory = new FlightFilterServiceFactory(repository);

        FilterService<Flight> arrivalBeforeDepartureFilter = flightFilterServiceFactory.getArrivalBeforeDepartureFilter();
        List<Flight> filter = arrivalBeforeDepartureFilter.filter();
        System.out.println(filter);

        FilterService<Flight> arrivalDateBeforeDepartureDateFilter = flightFilterServiceFactory.getArrivalDateBeforeDepartureDateFilter();
        List<Flight> filter1 = arrivalDateBeforeDepartureDateFilter.filter();
        System.out.println(filter1);

        FilterService<Flight> departureBeforeTheCurrentTimeFilter = flightFilterServiceFactory.getDepartureBeforeTheCurrentTimeFilter();
        List<Flight> filter2 = departureBeforeTheCurrentTimeFilter.filter();
        System.out.println(filter2);
    }
}
