package com.inglo.giggle.banner.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inglo.giggle.security.domain.type.ESecurityRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateAdminBannerRequestDto (

        @JsonProperty("title")
        @NotBlank(message = "배너 제목은 필수입니다.")
        String title,

        @JsonProperty("content")
        @NotBlank(message = "배너 내용은 필수입니다.")
        String content,

        @JsonProperty("role")
        @NotNull(message = "배너 권한은 필수입니다.")
        ESecurityRole role
) {
}
