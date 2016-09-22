package vn.com.imic.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vn.com.imic.model.Giaovien;

@Component
public class GiaovienValidator	implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return  Giaovien.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Giaovien giaovien = (Giaovien)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "magiaovien", "", "Giao Vien ID is empty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "diachi", "", "Adress is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Email is empty");
		if(!giaovien.getEmail().contains("@")){
			errors.rejectValue("email", "", "Email is not valid.");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ngaysinh", "", "Date of Birth is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quequan", "", "Place was born is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sdt", "", "Phone number is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ten", "", "Name is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trinhdo", "", "Level is empty");

		
	}
		

}
