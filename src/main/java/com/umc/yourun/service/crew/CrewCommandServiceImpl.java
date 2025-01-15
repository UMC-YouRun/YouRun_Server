package com.umc.yourun.service.crew;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umc.yourun.config.exception.ErrorCode;
import com.umc.yourun.config.exception.custom.CrewException;
import com.umc.yourun.converter.CrewConverter;
import com.umc.yourun.converter.mapping.UserCrewConverter;
import com.umc.yourun.domain.Crew;
import com.umc.yourun.domain.User;
import com.umc.yourun.domain.enums.CrewRole;
import com.umc.yourun.domain.enums.UserCrewStatus;
import com.umc.yourun.domain.mapping.UserCrew;
import com.umc.yourun.dto.crew.CrewRequestDTO;
import com.umc.yourun.repository.CrewRepository;
import com.umc.yourun.repository.UserCrewRepository;
import com.umc.yourun.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrewCommandServiceImpl implements CrewCommandService {
	private final CrewRepository crewRepository;

	private final UserRepository userRepository;

	private final UserCrewRepository userCrewRepository;

	@Override
	@Transactional
	public Crew register(CrewRequestDTO.RegisterDTO request) {
		Crew newCrew=CrewConverter.toCrew(request);
		User admin=userRepository.findById(request.adminId()).orElseThrow(()->new CrewException(ErrorCode.DUPLICATE_CREW_NAME));//TODO:예외처리 필요
		UserCrew userCrew= UserCrewConverter.toUserCrew(admin,newCrew, CrewRole.ADMIN, UserCrewStatus.APPROVED);
		newCrew.addUserCrew(userCrew);
		userCrewRepository.save(userCrew);
		return crewRepository.save(newCrew);
	}
}
