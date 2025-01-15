package com.umc.yourun.controller.mapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umc.yourun.apiPayload.ApiResponse;
import com.umc.yourun.converter.mapping.UserCrewConverter;
import com.umc.yourun.domain.mapping.UserCrew;
import com.umc.yourun.dto.crew.CrewResponseDTO;
import com.umc.yourun.dto.mapping.usercrew.UserCrewResponseDTO;
import com.umc.yourun.service.mapping.crewuser.CrewUserCommandService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crews/{crew_id}/users")
@Slf4j
@Tag(name = "JoinCrew", description = "크루 가입 관련 API")
public class UserCrewRestController {
	private final CrewUserCommandService crewUserCommandService;

	//TODO: 해당 부분 토큰에서 가져오기
	@PostMapping("/{user_id}/join")
	public ApiResponse<UserCrewResponseDTO.requestJoinResultDTO> requestJoin(@PathVariable("crew_id") Long crewId,@PathVariable("user_id") Long userId){
		log.info("requestJoin crewId:{}, userId:{}",crewId,userId);
		UserCrew userCrew=crewUserCommandService.requestJoin(crewId,userId);
		return ApiResponse.success("성공",UserCrewConverter.toRequestJoinResultDTO(userCrew));
	}
}
