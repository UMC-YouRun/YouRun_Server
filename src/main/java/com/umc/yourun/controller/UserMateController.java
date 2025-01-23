package com.umc.yourun.controller;

import com.umc.yourun.apiPayload.ApiResponse;
import com.umc.yourun.domain.UserMate;
import com.umc.yourun.service.UserMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.umc.yourun.config.exception.ErrorCode.INVALID_INPUT_VALUE;

@Controller
@RequestMapping("api/v1/users")
public class UserMateController {
    private static UserMateService userMateService;

    @Autowired
    public UserMateController(UserMateService userMateService) {
        this.userMateService = userMateService;
    }

    @PostMapping("/mates/{mateId}")
    @ResponseBody
    public ApiResponse<Boolean> addMate(@RequestHeader("Authorization") String accessToken, @PathVariable Long mateId){
        System.out.println(accessToken);
        if(userMateService.addmate(accessToken, mateId)) {
            return ApiResponse.success("메이트 추가에 성공했습니다.", true);
        }else{
            return ApiResponse.error(INVALID_INPUT_VALUE);
        }
    }

//    @GetMapping("/{userId}/mates")
//    @ResponseBody
//    public ApiResponse getMates(@PathVariable Long userId){
//        List<UserMate> userMateList = userMateService.getMateList(userId);
//        if(userMateList.isEmpty()) {
//            return ApiResponse.error(RESOURCE_NOT_FOUND);
//        }else{
//            return ApiResponse.success("친구 목록 조회에 성공했습니다.", userMateList);
//        }
//    }
}
