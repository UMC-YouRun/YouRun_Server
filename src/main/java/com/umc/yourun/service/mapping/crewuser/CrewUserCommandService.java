package com.umc.yourun.service.mapping.crewuser;

import com.umc.yourun.domain.mapping.UserCrew;

public interface CrewUserCommandService {
	UserCrew requestJoin(Long crewId,Long userId);
}
