package com.umc.yourun.dto.crew;

import java.time.LocalDateTime;

import lombok.Builder;

public record CrewResponseDTO() {
	@Builder
	public record RegisterResultDTO(
		Long crewId,
		LocalDateTime createdAt
	){}
}
