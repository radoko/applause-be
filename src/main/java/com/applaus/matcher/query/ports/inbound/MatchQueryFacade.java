package com.applaus.matcher.query.ports.inbound;

import com.applaus.matcher.query.model.Device;
import com.applaus.matcher.query.model.Match;

import java.util.Collection;

public interface MatchQueryFacade {

    Collection<Match> findMatches(Collection<String> countries, Collection<String> deviceIds);

    Collection<String> findAllCountries();

    Collection<Device> findAllDevices();
}
