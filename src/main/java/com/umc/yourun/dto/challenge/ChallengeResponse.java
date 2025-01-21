package com.umc.yourun.dto.challenge;

import com.umc.yourun.domain.enums.ChallengeDistance;
import com.umc.yourun.domain.enums.ChallengePeriod;
import com.umc.yourun.domain.enums.ChallengeStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.List;

public class ChallengeResponse {

    // TODO: 남은 인원 응답에 추가하기
    @Schema(title = "CHALLENGE_RES_01 : 상태 별 크루 챌린지 응답 DTO")
    public record CrewChallengeStatusRes(
            @Schema(description = "챌린지 ID", example = "1")
            Long challengeId,

            @Schema(description = "크루명", example = "거진홍길동")
            String crewName,

            @Schema(description = "시작일", example = "2025-01-15")
            LocalDate startDate,

            @Schema(description = "마감일", example = "2025-01-20")
            LocalDate endDate,

            @Schema(description = "챌린지 기간", example = "4")
            int challengePeriod
    ) {}

    // TODO: 만든 사용자의 해시태그 응답에 추가
    @Schema(title = "CHALLENGE_RES_02 : 상태 별 솔로 챌린지 응답 DTO")
    public record SoloChallengeStatusRes(
            @Schema(description = "챌린지 ID", example = "1")
            Long challengeId,

            @Schema(description = "시작일", example = "2025-01-15")
            LocalDate startDate,

            @Schema(description = "마감일", example = "2025-01-20")
            LocalDate endDate,

            @Schema(description = "챌린지 거리", example = "1")
            int challengeDistance,

            @Schema(description = "챌린지 기간", example = "4")
            int challengePeriod
    ) {}

    @Schema(title = "CHALLENGE_RES_03 : 솔로 챌린지 참여 응답 DTO")
    public record ChallengeMateRes(
            @Schema(description = "솔로 챌린지 ID", example = "1")
            Long challengeId,

            @Schema(description = "챌린지 생성자 ID", example = "2")
            Long userId
    ) {}

    @Schema(description = "CHALLENGE_RES_04 : 크루 챌린지 참여 응답 DTO")
    public record CrewChallengeMateRes(
            @Schema(description = "크루 챌린지 ID", example = "1")
            Long challengeId,

            @Schema(description = "참여자 ID 목록", example = "[\n" +
                    "      1,\n" +
                    "      2,\n" +
                    "      3,\n" +
                    "      4\n" +
                    "    ]")
            List<Long> participantIds
    ) {}

    @Schema(description = "CHALLENGE_RES_05 : 크루 챌린지 매칭 조회 응답 DTO")
    public record CrewMatchingRes(
            @Schema(description = "챌린지 기간(일)", example = "3")
            int period,

            @Schema(description = "내 크루명", example = "거진홍길동")
            String crewName,

            @Schema(description = "내 크루원 ID 목록 (참여 순서대로)", example = "[\n" +
                    "      1,\n" +
                    "      2,\n" +
                    "      3,\n" +
                    "      4\n" +
                    "    ]")
            List<Long> crewMemberIds,

            @Schema(description = "매칭된 크루명", example = "거진이봉주")
            String matchedCrewName,

            @Schema(description = "매칭된 크루원 ID 목록 (참여 순서대로)", example = "[\n" +
                    "      5,\n" +
                    "      6,\n" +
                    "      7,\n" +
                    "      8\n" +
                    "    ]")
            List<Long> matchedCrewMemberIds
    ) {}

    @Schema(description = "CHALLENGE_RES_06 : 홈 화면 챌린지 조회 응답")
    public record HomeChallengeRes(
            @Schema(description = "솔로 챌린지 정보")
            UserSoloChallengeInfo soloChallenge,

            @Schema(description = "크루 챌린지 정보")
            UserCrewChallengeInfo crewChallenge
    ) {}

    // 유저의 솔로 챌린지 응답
    public record UserSoloChallengeInfo(
            @Schema(description = "챌린지 ID")
            Long challengeId,

            @Schema(description = "챌린지 상태", example = "PENDING/IN_PROGRESS")
            ChallengeStatus status,

            @Schema(description = "목표 거리", example = "1")
            int challengeDistance,

            @Schema(description = "챌린지 기간(일)", example = "3")
            int challengePeriod,

            @Schema(description = "챌린지 메이트 ID", example = "1")
            Long challengeMateId
    ) {}

    // 유저의 크루 챌린지 응답
    public record UserCrewChallengeInfo(
            @Schema(description = "챌린지 ID", example = "1")
            Long challengeId,

            @Schema(description = "크루명", example = "거진홍길동")
            String crewName,

            @Schema(description = "챌린지 상태", example = "PENDING/IN_PROGRESS")
            ChallengeStatus challengeStatus,

            @Schema(description = "챌린지 기간(일)", example = "3")
            int challengePeriod,

            @Schema(description = "크루원 ID 목록", example = "[\n" +
                    "      1,\n" +
                    "      2,\n" +
                    "      3,\n" +
                    "      4\n" +
                    "    ]")
            List<Long> crewMemberIds
    ) {}
}