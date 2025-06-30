package com.analitic_data.demo.dto;

import java.util.List;

public record Team (
        String name,
        Boolean  leader,
        List<Project> projects
){
}
