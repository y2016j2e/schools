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
		ValidationUtils.rejectIfEmpty(errors, "ten", "giaovien.form.emty.ten");
		ValidationUtils.rejectIfEmpty(errors, "diachi", "giaovien.form.emty.diachi");

//		if{
//			
//		}
//		
	}
		

}
