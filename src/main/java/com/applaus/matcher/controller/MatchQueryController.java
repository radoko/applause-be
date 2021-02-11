package com.applaus.matcher.controller;

import com.applaus.matcher.model.Device;
import com.applaus.matcher.model.Match;
import com.applaus.matcher.service.MatchQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/query")
@AllArgsConstructor
public class MatchQueryController {

    private MatchQueryService matchQueryService;

    @GetMapping("/matches")
    Collection<Match> findMatches(@RequestParam Collection<String> countries,
                                  @RequestParam Collection<String> deviceIds
    ) {
        return matchQueryService.findMatches(countries, deviceIds);
    }

    @GetMapping("/countries")
    Collection<String> findAllCountries() {
        return matchQueryService.findAllCountries();
    }

    @GetMapping("/devices")
    Collection<Device> findAllDevices() {
        return matchQueryService.findAllDevices();
    }
}
