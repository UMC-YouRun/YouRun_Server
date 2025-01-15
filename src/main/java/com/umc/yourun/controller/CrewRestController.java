package com.umc.yourun.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umc.yourun.apiPayload.ApiResponse;
import com.umc.yourun.converter.CrewConverter;
import com.umc.yourun.domain.Crew;
import com.umc.yourun.dto.crew.CrewRequestDTO;
import com.umc.yourun.dto.crew.CrewResponseDTO;
import com.umc.yourun.service.crew.CrewCommandService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crews")
@Tag(name = "Crew", description = "크루 관련 API")
public class CrewRestController {

	private final CrewCommandService crewCommandService;

	@PostMapping
	public ApiResponse<CrewResponseDTO.RegisterResultDTO> register(@RequestBody @Valid CrewRequestDTO.RegisterDTO request){
		Crew crew=crewCommandService.register(request);
		return ApiResponse.success("성공",CrewConverter.toRegisterResultDTO(crew));
	}

}
