package com.analitic_data.demo.dto;

import java.util.Date;

public record Log(
        Date date,
        String action
) {
}
