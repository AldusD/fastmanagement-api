package com.managecorp.fastmanagementapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record TokenDto (@NotBlank String token) {
}
