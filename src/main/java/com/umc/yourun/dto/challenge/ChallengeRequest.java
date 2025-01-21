package com.umc.yourun.dto.challenge;

import com.umc.yourun.config.exception.custom.annotation.ValidCrewName;
import com.umc.yourun.config.exception.custom.annotation.ValidSlogan;
import com.umc.yourun.domain.enums.ChallengeDistance;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ChallengeRequest {

    @Schema(title = "CHALLENGE_REQ_01 : 크루 챌린지 생성 요청")
    public record CreateCrewChallengeReq(
            @Schema(description = "크루 이름", example = "거진홍길동")
            @ValidCrewName(message = "공백 포함 없이 한글로만 2-5자로 입력해주세요.")
            String crewName,

            @Schema(description = "구호", example = "헤르메스 신발의 주인공")
            @ValidSlogan(message = "공백 포함하여 한글로만 3-12자로 입력해주세요.")
            String slogan,

            @Schema(description = "챌린지 종료일", example = "2025-01-17")
            LocalDate endDate
    ) {}

    @Schema(title = "CHALLENGE_REQ_02 : 개인 챌린지 생성 요청 DTO")
    public record CreateSoloChallengeReq(

            @Schema(description = "챌린지 종료일", example = "2025-01-17")
            LocalDate endDate,

            @Schema(description = "챌린지 거리", example = "ONE_KM",
            title = "ONE_KM = 1, THREE_KM = 3, FIVE_KM = 5")
            ChallengeDistance challengeDistance
    ) {}
}
