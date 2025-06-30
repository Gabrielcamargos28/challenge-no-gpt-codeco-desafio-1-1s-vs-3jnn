package com.analitic_data.demo.dto;

import java.util.List;

public record ResponseSuperUsers(
        List<UserDTO> users,
        String timeRequest
) {
}
