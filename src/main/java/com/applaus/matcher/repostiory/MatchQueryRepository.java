package com.applaus.matcher.repostiory;

import com.applaus.matcher.model.Device;
import com.applaus.matcher.model.Match;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MatchQueryRepository{

    Collection<Match> findMatches(Collection<String> countries, Collection<String> deviceIds);

    Collection<String> findAllCountries();

    Collection<Device> findAllDevices();
}
