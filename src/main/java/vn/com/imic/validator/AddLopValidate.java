package vn.com.imic.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.imic.model.LopDataTemp;

@Component
public class AddLopValidate implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return LopDataTemp.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		LopDataTemp lop = (LopDataTemp)arg0;
		System.out.println("validate");
		ValidationUtils.rejectIfEmpty(arg1, "tenlop", "Invalid Class name");
		if(lop.getSotiethoc()<10)
			System.out.println("out");
			arg1.rejectValue("sotiethoc","lop.form.more.sotiethoc");
	}

}
