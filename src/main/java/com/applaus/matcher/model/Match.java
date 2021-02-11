package com.applaus.matcher.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Match {
    String userName;
    Long numberOfBugs;
}
