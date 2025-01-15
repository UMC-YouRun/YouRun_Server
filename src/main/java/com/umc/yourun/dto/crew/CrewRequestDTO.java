package com.umc.yourun.dto.crew;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CrewRequestDTO() {
	@Schema(title = "CREW_REQ_01 : 크루 생성 요청 DTO")
	public record RegisterDTO(
		//TODO: 추후 토큰에서 가져올 것
		Long adminId,
		@Schema(description = "크루 이름",example = "동작구 크루")
		@NotNull(message = "크루 이름은 필수 값입니다.")
		//TODO:중복 확인 필요
		@Size(min = 1,max = 50,message = "이름은 1자 이상 50자 이하여야 합니다.")
		String name,
		@Schema(description = "응원 문구",example = "동작 크루가 최고")
		@Size(max = 50,message = "응원 문구는 50자 이하여야 합니다.")
		String cheerMessage//응원 문구
	)
	{}
}
