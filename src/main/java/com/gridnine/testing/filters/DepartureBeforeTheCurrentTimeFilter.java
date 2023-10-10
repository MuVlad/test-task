package com.gridnine.testing.filters;


import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.repository.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeTheCurrentTimeFilter extends FilterService<Flight> {

    protected DepartureBeforeTheCurrentTimeFilter(Repository<Flight> repository) {
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
        return segments
                .stream()
                .anyMatch(segment -> {
                    LocalDateTime departureDate = segment.getDepartureDate();
                    return departureDate.isBefore(LocalDateTime.now());
                });
    }
}
