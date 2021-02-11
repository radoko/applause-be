package com.applaus.matcher.rest;

import com.applaus.matcher.query.model.Device;
import com.applaus.matcher.query.model.Match;
import com.applaus.matcher.query.ports.inbound.MatchQueryFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/query")
@AllArgsConstructor
class MatchQueryEndpoint {

    private MatchQueryFacade matchQueryFacade;

    @GetMapping("/matches")
    Collection<Match> findMatches(@RequestParam Collection<String> countries,
                                  @RequestParam Collection<String> deviceIds
    ) {
        return matchQueryFacade.findMatches(countries, deviceIds);
    }

    @GetMapping("/countries")
    Collection<String> findAllCountries() {
        return matchQueryFacade.findAllCountries();
    }

    @GetMapping("/devices")
    Collection<Device> findAllDevices() {
        return matchQueryFacade.findAllDevices();
    }
}
