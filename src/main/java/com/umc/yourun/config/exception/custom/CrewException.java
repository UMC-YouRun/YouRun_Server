package com.umc.yourun.config.exception.custom;

import com.umc.yourun.config.exception.ErrorCode;
import com.umc.yourun.config.exception.GeneralException;


public class CrewException extends GeneralException {

	public CrewException(ErrorCode errorCode) {
		super(errorCode);
	}
}
