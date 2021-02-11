package com.applaus.matcher.service;

import com.applaus.matcher.model.Device;
import com.applaus.matcher.model.Match;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface MatchQueryService {

    Collection<Match> findMatches(Collection<String> countries, Collection<String> deviceIds);

    Collection<String> findAllCountries();

    Collection<Device> findAllDevices();
}
