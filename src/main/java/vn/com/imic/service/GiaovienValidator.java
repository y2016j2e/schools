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
		
		return  Giaovien.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Giaovien giaovien = (Giaovien) target;
		ValidationUtils.rejectIfEmpty(errors, "ten", "giaovien.form.emty.ten");
		ValidationUtils.rejectIfEmpty(errors, "diachi", "giaovien.form.emty.diachi");
		ValidationUtils.rejectIfEmpty(errors, "quequan", "giaovien.form.emty.quequan");
		ValidationUtils.rejectIfEmpty(errors, "email", "giaovien.form.emty.email");
		ValidationUtils.rejectIfEmpty(errors, "sdt", "giaovien.form.emty.sdt");
		ValidationUtils.rejectIfEmpty(errors, "namvaonghe", "giaovien.form.emty.namvaonghe");
		ValidationUtils.rejectIfEmpty(errors,"trinhdo","giaovien.form.emty.trinhdo");

		if((giaovien.getTen().length()< 6) |(giaovien.getTen().length()> 30)){
			errors.rejectValue("ten", "giaovien.form.error.ten");
		}




	}


}
