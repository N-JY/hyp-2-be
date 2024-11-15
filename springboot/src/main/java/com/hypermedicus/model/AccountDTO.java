package com.hypermedicus.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AccountDTO {
    @JsonIgnore
    @Schema(hidden = true)
    private UUID uuid;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String nation;
    private String hospital;
    private String department;
}