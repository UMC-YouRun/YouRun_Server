package com.umc.yourun.converter.mapping;

import java.time.LocalDateTime;

import com.umc.yourun.domain.Crew;
import com.umc.yourun.domain.User;
import com.umc.yourun.domain.enums.CrewRole;
import com.umc.yourun.domain.enums.UserCrewStatus;
import com.umc.yourun.domain.mapping.UserCrew;
import com.umc.yourun.dto.mapping.usercrew.UserCrewResponseDTO;

public class UserCrewConverter {
	public static UserCrew toUserCrew(User user, Crew crew,CrewRole role,UserCrewStatus status) {
		return UserCrew.builder()
			.role(role)
			.status(status)
			.crew(crew)
			.user(user)
			.build();
	}

	public static UserCrewResponseDTO.requestJoinResultDTO toRequestJoinResultDTO(UserCrew userCrew) {
		return UserCrewResponseDTO.requestJoinResultDTO.builder()
			.userCrewId(userCrew.getUser().getId())
			.createdAt(LocalDateTime.now())
			.build();
	}
}
