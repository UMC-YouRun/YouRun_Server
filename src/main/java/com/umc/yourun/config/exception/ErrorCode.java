package com.umc.yourun.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 서버 에러
    INVALID_INPUT_VALUE(400, "S001", "잘못된 입력값입니다."),
    INTERNAL_SERVER_ERROR(500, "S002", "서버 에러가 발생했습니다."),

    //User 관련 에러(추후 토큰에서 가져올 시 변경 필요)


    // Challenge 관련 에러
    INVALID_START_DATE(400, "C001", "시작일은 오늘부터 이후로만 가능합니다."),
    INVALID_END_DATE(400, "C002","종료일은 시작일 이후여야 합니다."),
    INVALID_CHALLENGE_PERIOD(400, "C003","챌린지 기간은 최소 3일에서 최대 5일이어야 합니다."),
    INVALID_CREW_NAME_NULL(400, "C004","크루명은 필수입니다."),
    INVALID_CREW_NAME_FORMAT(400, "C005","크루명은 특수문자를 포함할 수 없습니다."),

    //Crew 생성 관련 에러
    DUPLICATE_CREW_NAME(409,"CW001","중복된 이름을 가진 크루가 존재합니다."),

    //Crew 가입 신청시 에러
    JOIN_CREW_ONLYONE(409,"J001","이미 소속된 크루가 존재합니다.");


    private final int status;
    private final String code;
    private final String message;

}
