package com.applaus.matcher.persistance;

import com.applaus.matcher.query.model.Device;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class DeviceRowMapper implements RowMapper<Device> {

    @Override
    public Device mapRow(ResultSet rs, int i) throws SQLException {

        return Device.builder()
                .id(rs.getLong("DEVICEID"))
                .description(rs.getString("DESCRIPTION"))
                .build();
    }
}
