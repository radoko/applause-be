package com.applaus.matcher.persistance;


import com.applaus.matcher.query.model.Match;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class MatchRowMapper implements RowMapper<Match> {

    @Override
    public Match mapRow(ResultSet rs, int i) throws SQLException {

        return Match.builder()
                .userName(rs.getString("USERNAME"))
                .numberOfBugs(rs.getLong("NUMBEROFBUGS"))
                .build();
    }
}
