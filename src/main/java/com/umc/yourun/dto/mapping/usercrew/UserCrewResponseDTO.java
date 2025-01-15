package com.umc.yourun.dto.mapping.usercrew;

import java.time.LocalDateTime;

import lombok.Builder;

public record UserCrewResponseDTO() {
	@Builder
	public record requestJoinResultDTO(
		Long userCrewId,
		LocalDateTime createdAt
	){}
}
