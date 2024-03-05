package com.mvc.file.model;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {
// Validator라는 인터페이스 상속 받는다.
	
	// Validator를 이용할 수 있는 클래스인지 확인 용도
	// 여기서는 사용 안할거다.
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// 유효성 검사
	@Override
	public void validate(Object uploadFile, Errors errors) {
		
		UploadFile file = (UploadFile)uploadFile;
		
		if(file.getFile().getSize() == 0) { // 파일 크기가 0이면
			errors.rejectValue("file", "errorCode", "Please select a file");
			// 에러메세지를 저장한다.
			// .rejectValue("변수명", "errorCode", "에러 메세지 내용");
			// 여기서 file은 <form:errors path="file"/>의 file과 같다.
		}
		
	}

}
