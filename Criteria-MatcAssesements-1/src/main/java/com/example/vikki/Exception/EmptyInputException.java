package com.example.vikki.Exception;

import org.springframework.stereotype.Component;

@Component
public class EmptyInputException extends RuntimeException {

	  private String ErrCode;
      private String ErrMsg;
	public String getErrCode() {
		return ErrCode;
	}
	public void setErrCode(String errCode) {
		ErrCode = errCode;
	}
	public String getErrMsg() {
		return ErrMsg;
	}
	public void setErrMsg(String errMsg) {
		ErrMsg = errMsg;
	}
	public EmptyInputException (String errCode, String errMsg) {
		super();
		ErrCode = errCode;
		ErrMsg = errMsg;
	}
        public EmptyInputException() {
        	
        }
	
}