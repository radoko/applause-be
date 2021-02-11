package com.applaus.matcher.repostiory.impl;

import com.applaus.matcher.model.Match;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchRowMapper implements RowMapper<Match> {

    @Override
    public Match mapRow(ResultSet rs, int i) throws SQLException {

        return Match.builder()
                .userName(rs.getString("USERNAME"))
                .numberOfBugs(rs.getLong("NUMBEROFBUGS"))
                .build();
    }
}
