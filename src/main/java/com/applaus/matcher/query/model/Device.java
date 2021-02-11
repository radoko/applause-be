package com.applaus.matcher.query.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Device {
    Long id;
    String description;
}
