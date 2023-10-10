package com.gridnine.testing.filters;


import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalDateBeforeDepartureDateFilter extends FilterService<Flight> {

    protected ArrivalDateBeforeDepartureDateFilter(Repository<Flight> repository) {
        super(repository);
    }

    @Override
    public List<Flight> filter() {
        return repository
                .getAll()
                .stream()
                .filter(flight -> filterSegment(flight.getSegments()))
                .collect(Collectors.toList());
    }

    private boolean filterSegment(List<Segment> segments) {
        return segments
                .stream()
                .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));
    }

}
