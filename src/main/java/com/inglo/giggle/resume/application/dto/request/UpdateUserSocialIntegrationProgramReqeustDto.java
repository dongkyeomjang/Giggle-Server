package com.inglo.giggle.resume.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateUserSocialIntegrationProgramReqeustDto(
        @JsonProperty("level")
        Integer level
) {
}
