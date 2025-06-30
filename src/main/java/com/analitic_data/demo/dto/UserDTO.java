package com.analitic_data.demo.dto;

import java.util.List;

public record UserDTO(
        String id,
        String name,
        Integer age,
        Integer score,
        Boolean active,
        String country,
        Team team,
        List<Log> logs
) {
}
