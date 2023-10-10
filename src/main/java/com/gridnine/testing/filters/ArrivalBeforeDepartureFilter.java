package com.gridnine.testing.filters;


import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.repository.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter extends FilterService<Flight> {

    protected ArrivalBeforeDepartureFilter(Repository<Flight> repository) {
        super(repository);
    }

    @Override
    public List<Flight> filter() {
        return repository
                .getAll()
                .stream()
                .filter(flight -> filterSegments(flight.getSegments()))
                .collect(Collectors.toList());
    }

    private boolean filterSegments(List<Segment> segments) {
        if (segments.size() > 1) {
            LocalDateTime currentArrival;
            LocalDateTime nextFlight;
            Duration waitingInEarth = Duration.ZERO;
            for (int i = 0; i < segments.size() - 1; i++) {
                currentArrival = segments.get(i).getArrivalDate();
                nextFlight = segments.get(i + 1).getDepartureDate();
                waitingInEarth = waitingInEarth.plus(waitingBetweenFlights(currentArrival, nextFlight));
            }
            return waitingInEarth.toHours() >= 2;
        }
        return false;
    }

    private Duration waitingBetweenFlights(LocalDateTime flightTimeArrival, LocalDateTime DepartureOfTheNextFlight) {
        return Duration
                .between(flightTimeArrival, DepartureOfTheNextFlight)
                .abs();
    }
}
