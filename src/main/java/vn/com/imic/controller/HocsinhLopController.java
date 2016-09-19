package vn.com.imic.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.imic.model.Hocsinh;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.service.HocsinhLopServices;
import vn.com.imic.service.LopServices;
import vn.com.imic.validator.HocsinhLopValidate;


@Controller
public class HocsinhLopController {
	
	@Autowired
	private LopServices sevices;
	
	@Autowired
	private HocsinhLopServices hocsinhServices;

	@Autowired
	private HocsinhLopValidate validator;
	

	private int check = 0;
	
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	


	
	@RequestMapping(value="/lop/{id}/addHocsinh",method = RequestMethod.POST)
	public String addHocsinh(@PathVariable(value="id") int id,Model model,
			@ModelAttribute("hocsinh") @Validated Hocsinh hocsinh,RedirectAttributes redirect,BindingResult result){
		
		if(result.hasErrors()){
			model.addAttribute("hocsinh",new Hocsinh());
			model.addAttribute("date",new Date());
			model.addAttribute("khoahoc",sevices.getKhoahocById(id));
			return "redirect:/lop/"+id+"/add";
		}
		
		Khoahoc kh = sevices.getKhoahocById(id);
		Hocsinh hs = hocsinhServices.getHocsinh(hocsinh.getTen(), hocsinh.getDiachi());
		if(hs != null && check == 0){
			check = 1;
			model.addAttribute("hocsinh",hocsinh);
			model.addAttribute("date",new Date());
			model.addAttribute("khoahoc",sevices.getKhoahocById(id));
			model.addAttribute("check",check);
			return "redirect:/lop/"+id+"/add";
		}
		check = 0;
		if(hs == null){
			hocsinhServices.addHocsinhInLop(id, hocsinh);
		}else{
			hs.getKhoahoc().add(kh);
			hs.setBo(hocsinh.getBo());
			hs.setDiachi(hocsinh.getDiachi());
			hs.setMe(hocsinh.getMe());
			hs.setNgaysinh(hocsinh.getNgaysinh());
			hocsinhServices.addHocsinhInLop(id,hs);
		}
		
		return "redirect:/lop/"+id;
	}
}
