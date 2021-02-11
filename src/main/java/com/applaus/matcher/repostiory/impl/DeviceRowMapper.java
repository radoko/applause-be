package com.applaus.matcher.repostiory.impl;

import com.applaus.matcher.model.Device;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceRowMapper implements RowMapper<Device> {

    @Override
    public Device mapRow(ResultSet rs, int i) throws SQLException {

        return Device.builder()
                .id(rs.getLong("DEVICEID"))
                .description(rs.getString("DESCRIPTION"))
                .build();
    }
}
