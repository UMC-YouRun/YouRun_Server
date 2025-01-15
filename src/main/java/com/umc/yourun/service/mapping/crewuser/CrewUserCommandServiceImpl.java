package com.umc.yourun.service.mapping.crewuser;

import org.springframework.stereotype.Service;

import com.umc.yourun.converter.mapping.UserCrewConverter;
import com.umc.yourun.domain.Crew;
import com.umc.yourun.domain.User;
import com.umc.yourun.domain.enums.CrewRole;
import com.umc.yourun.domain.enums.UserCrewStatus;
import com.umc.yourun.domain.mapping.UserCrew;
import com.umc.yourun.repository.CrewRepository;
import com.umc.yourun.repository.UserCrewRepository;
import com.umc.yourun.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class CrewUserCommandServiceImpl implements CrewUserCommandService {

	private final CrewRepository crewRepository;
	private final UserRepository userRepository;
	private final UserCrewRepository userCrewRepository;

/*
	TODO: crew Id에 해당하는 DB 있는지 확인
 	user ID에 해당하는값이 DB 있는지 확인
 	userCrew테이블에 pending인 데이터가 이미 있는지 확인
*/
	public UserCrew requestJoin(Long crewId,Long userId) {
		Crew crew=crewRepository.findById(crewId).orElseThrow();//TODO: 예외처리 핸들러 생성필요
		User user=userRepository.findById(userId).orElseThrow();
		UserCrew userCrew= UserCrewConverter.toUserCrew(user,crew, CrewRole.MEMBER, UserCrewStatus.PENDING);
		return userCrewRepository.save(userCrew);
	}

}
