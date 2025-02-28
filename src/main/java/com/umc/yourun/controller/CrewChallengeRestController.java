package com.umc.yourun.controller;

import com.umc.yourun.apiPayload.ApiResponse;
import com.umc.yourun.config.exception.ErrorResponse;
import com.umc.yourun.dto.challenge.ChallengeRequest;
import com.umc.yourun.dto.challenge.CrewChallengeResponse;
import com.umc.yourun.service.challenge.CrewChallengeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/challenges/crew")
@Tag(name = "CrewChallenge", description = "크루 챌린지 API")
public class CrewChallengeRestController {

    private final CrewChallengeService crewChallengeService;

    @Operation(summary = "CREW_CHALLENGE_API_01 : 크루 챌린지 생성", description = "새로운 크루 챌린지를 생성합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "챌린지 생성 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })

    @PostMapping("")
    public ApiResponse<CrewChallengeResponse.CrewChallengeCreateRes> createCrewChallenge(
            @RequestHeader(value = "Authorization") String accessToken,
            @RequestBody @Valid ChallengeRequest.CreateCrewChallengeReq request) {

        CrewChallengeResponse.CrewChallengeCreateRes response = crewChallengeService.createCrewChallenge(request, accessToken);
        return ApiResponse.success("크루 챌린지가 생성되었습니다.", response);
    }

    @Operation(summary = "CREW_CHALLENGE_API_02 : 크루 결성 대기 중인 크루 챌린지 조회", description = "크루가 결성되지 않아 PENDING 상태인 크루 챌린지 목록을 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/pending")
    public ApiResponse<CrewChallengeResponse.CrewChallenge> getPendingCrewChallenges(
            @RequestHeader(value = "Authorization") String accessToken
    ) {
        CrewChallengeResponse.CrewChallenge response = crewChallengeService.getPendingCrewChallenges(accessToken);
        return ApiResponse.success("결성 대기 중인 크루 챌린지 목록입니다.", response);
    }

    @Operation(summary = "CREW_CHALLENGE_API_03 : 크루 챌린지 상세 페이지 조회", description = "크루 챌린지의 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "참여중인 크루 챌린지가 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/pending/{challengeId}")
    public ApiResponse<CrewChallengeResponse.CrewChallengeDetailRes> getCrewChallengeDetail(
            @RequestHeader(value = "Authorization") String accessToken,
            @PathVariable Long challengeId) {
        CrewChallengeResponse.CrewChallengeDetailRes response = crewChallengeService.getCrewChallengeDetail(challengeId, accessToken);
        return ApiResponse.success("크루 챌린지 상세 정보입니다.", response);
    }

    @Operation(summary = "CREW_CHALLENGE_API_04 : 크루 챌린지 매칭 조회", description = "사용자가 현재 참여중인 크루 챌린지의 매칭 정보를 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "참여중인 크루 챌린지가 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/matching")
    public ApiResponse<CrewChallengeResponse.CrewChallengeMatchingRes> getCrewMatch(
            @RequestHeader(value = "Authorization") String accessToken) {
        CrewChallengeResponse.CrewChallengeMatchingRes response = crewChallengeService.getCrewMatch(accessToken);
        return ApiResponse.success("크루 챌린지 매칭 정보입니다.", response);
    }

    @Operation(summary = "CREW_CHALLENGE_API_05 : 크루 챌린지 상세 진행도 조회", description = "홈 - 크루 챌린지 클릭시 조회됩니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "참여중인 크루 챌린지가 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/detail-progress")
    public ApiResponse<CrewChallengeResponse.CrewChallengeDetailProgressRes> getCrewMatchDetailProgress(
            @RequestHeader(value = "Authorization") String accessToken) {
        CrewChallengeResponse.CrewChallengeDetailProgressRes response = crewChallengeService.getCrewChallengeDetailProgress(accessToken);
        return ApiResponse.success("크루 챌린지 상세 진행도 정보입니다.", response);
    }

    @Operation(summary = "CREW_CHALLENGE_API_06 : 러닝 후 크루 챌린지 결과 조회", description = "러닝 후 크루 챌린지의 결과를 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "참여중인 크루 챌린지가 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/running-result")
    public ApiResponse<CrewChallengeResponse.CrewChallengeRunningResultRes> getCrewChallengeRunningResult(
            @RequestHeader(value = "Authorization") String accessToken) {
        CrewChallengeResponse.CrewChallengeRunningResultRes response = crewChallengeService.getCrewChallengeRunningResult(accessToken);
        return ApiResponse.success("러닝 후 크루 챌린지 결과입니다.", response);
    }

    @Operation(summary = "CREW_CHALLENGE_API_07 : 크루 챌린지 순위 결과 조회", description = "크루 챌린지의 기여도 결과를 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "참여중인 크루 챌린지가 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/ranking-result")
    public ApiResponse<CrewChallengeResponse.CrewChallengeContributionRes> getCrewChallengeContribution(
            @RequestHeader(value = "Authorization") String accessToken) {
        CrewChallengeResponse.CrewChallengeContributionRes response = crewChallengeService.getCrewChallengeContribution(accessToken);
        return ApiResponse.success("크루 챌린지 순위 결과입니다.", response);
    }

    @Operation(summary = "CREW_CHALLENGE_API_08 : 크루 챌린지 참여", description = "대기 중인 크루 챌린지에 참여합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "챌린지 참여 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/{challengeId}/join")
    public ApiResponse<CrewChallengeResponse.CrewChallengeMateRes> joinCrewChallenge(
            @RequestHeader(value = "Authorization") String accessToken,
            @PathVariable Long challengeId) {
        CrewChallengeResponse.CrewChallengeMateRes response = crewChallengeService.joinCrewChallenge(challengeId, accessToken);
        return ApiResponse.success("크루 챌린지 참여가 완료되었습니다.", response);
    }
}
