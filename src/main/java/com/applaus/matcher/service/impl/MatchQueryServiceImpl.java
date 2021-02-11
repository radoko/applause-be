package com.applaus.matcher.service.impl;

import com.applaus.matcher.model.Device;
import com.applaus.matcher.model.Match;
import com.applaus.matcher.repostiory.impl.InMemoryMatchQueryRepository;
import com.applaus.matcher.service.MatchQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class MatchQueryServiceImpl implements MatchQueryService {

    private InMemoryMatchQueryRepository matchQueryRepository;

    @Override
    public Collection<Match> findMatches(Collection<String> countries, Collection<String> deviceIds) {
        return matchQueryRepository.findMatches(countries, deviceIds);
    }

    @Override
    public Collection<String> findAllCountries() {
        return matchQueryRepository.findAllCountries();
    }

    @Override
    public Collection<Device> findAllDevices() {
        return matchQueryRepository.findAllDevices();
    }
}
