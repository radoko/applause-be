package com.applaus.matcher.persistance;

import com.applaus.matcher.query.model.Device;
import com.applaus.matcher.query.model.Match;
import com.applaus.matcher.query.ports.outbound.MatchQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
@AllArgsConstructor
class InMemoryMatchRepositoryAdapter implements MatchQueryRepository {

    JdbcTemplate jdbcTemplate;

    @Override
    public Collection<String> findAllCountries() {
        String query = "select distinct COUNTRY from TESTERS";
        return jdbcTemplate.queryForList(query, String.class);
    }

    @Override
    public Collection<Device> findAllDevices() {
        String query = "select distinct * from DEVICES";
        return jdbcTemplate.query(
                query,
                new DeviceRowMapper());

    }

    @Override
    public Collection<Match> findMatches(Collection<String> countries, Collection<String> deviceIds) {
        final StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("select CONCAT(FIRSTNAME, ' ', LASTNAME) as USERNAME, COUNT(BUGID) AS NUMBEROFBUGS from TESTERS t " +
                "    join BUGS B on t.TESTERID = B.TESTERID WHERE 1=1 ");
        queryBuilder.append(String.format("AND COUNTRY IN (%s)",
                String.join(",", Collections.nCopies(countries.size(), "?"))));
        queryBuilder.append(String.format("AND DEVICEID IN (%s) ",
                String.join(",", Collections.nCopies(deviceIds.size(), "?"))));
        queryBuilder.append(" GROUP BY B.TESTERID ORDER BY NUMBEROFBUGS DESC");

        final List<String> params = new ArrayList<>();
        params.addAll(countries);
        params.addAll(deviceIds);

        return jdbcTemplate.query(
                queryBuilder.toString(),
                new MatchRowMapper(),
                params.toArray());
    }

}
