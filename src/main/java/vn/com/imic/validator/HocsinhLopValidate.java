package vn.com.imic.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.imic.model.Hocsinh;

@Component
public class HocsinhLopValidate implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Hocsinh.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		//Hocsinh hs = (Hocsinh)arg0;
		ValidationUtils.rejectIfEmpty(arg1, "ten", "lop.form.empty.tenlop");
		ValidationUtils.rejectIfEmpty(arg1, "ngaysinh", "lop.form.empty.tenlop");
		ValidationUtils.rejectIfEmpty(arg1, "diachi", "lop.form.empty.tenlop");
		ValidationUtils.rejectIfEmpty(arg1, "quequan", "lop.form.empty.tenlop");
		ValidationUtils.rejectIfEmpty(arg1, "bo", "lop.form.empty.tenlop");
		ValidationUtils.rejectIfEmpty(arg1, "me", "lop.form.empty.tenlop");
	}

}
