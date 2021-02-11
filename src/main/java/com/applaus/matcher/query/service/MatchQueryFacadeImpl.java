package com.applaus.matcher.query.service;

import com.applaus.matcher.query.model.Device;
import com.applaus.matcher.query.model.Match;
import com.applaus.matcher.query.ports.inbound.MatchQueryFacade;
import com.applaus.matcher.query.ports.outbound.MatchQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class MatchQueryFacadeImpl implements MatchQueryFacade {

    private MatchQueryRepository matchQueryRepository;

    public Collection<Match> findMatches(Collection<String> countries, Collection<String> deviceIds) {
        return matchQueryRepository.findMatches(countries, deviceIds);
    }

    public Collection<String> findAllCountries() {
        return matchQueryRepository.findAllCountries();
    }

    public Collection<Device> findAllDevices() {
        return matchQueryRepository.findAllDevices();
    }
}
