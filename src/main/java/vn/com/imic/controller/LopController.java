package vn.com.imic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.imic.model.Khoahoc;
import vn.com.imic.service.LopServices;

@Controller
public class LopController {
	
	@Autowired
	private LopServices sevices;
	
	@RequestMapping(value="/lop/row/{num}",method = RequestMethod.GET)
	public ModelAndView setViewLop(@RequestParam(value="page",required=false) String page, HttpServletRequest request,@PathVariable("num") int num){
		System.out.println(num);
		ModelAndView model = new ModelAndView("lop/lop");
		int count = sevices.getPage("2016-2017","Học Kỳ I","Imic Hoàng Quốc Việt",num);
		System.out.println(count+"so page");
		List<Khoahoc> lis = new ArrayList<>();
		if(page!=null){
			int pg = Integer.parseInt(page);
			lis = sevices.getLimitLopInKhoahoc("2016-2017","Học Kỳ I","Imic Hoàng Quốc Việt",num*(pg-1),num);
			model.addObject("act",pg);
		}
		else{
			lis = sevices.getLimitLopInKhoahoc("2016-2017","Học Kỳ I","Imic Hoàng Quốc Việt",0,num);
			model.addObject("act",1);
		}
		model.addObject("lastpage",count);
		model.addObject("lop", new Khoahoc());
		model.addObject("lis", lis);
		return model;
	}
	
	@RequestMapping(value="/lop",method = RequestMethod.GET)
	public ModelAndView setViewLopa(@RequestParam(value="page",required=false) String page,@RequestParam(value="row",required=false) String row, HttpServletRequest request){
		ModelAndView model = new ModelAndView("lop/lop");
		int r = 0;
		if(row == null)
				r = 5;
		else
			r = Integer.parseInt(row);
		int count = sevices.getPage("2016-2017","Học Kỳ I","Imic Hoàng Quốc Việt",r);
		System.out.println(count+"so page");
		List<Khoahoc> lis = new ArrayList<>();
		if(page!=null){
			int pg = Integer.parseInt(page);
			lis = sevices.getLimitLopInKhoahoc("2016-2017","Học Kỳ I","Imic Hoàng Quốc Việt",r*(pg-1),r);
			model.addObject("act",pg);
		}
		else{
			lis = sevices.getLimitLopInKhoahoc("2016-2017","Học Kỳ I","Imic Hoàng Quốc Việt",0,r);
			model.addObject("act",1);
		}
		model.addObject("nrow", r);
		model.addObject("lastpage",count);
		model.addObject("lop", new Khoahoc());
		model.addObject("lis", lis);
		return model;
	}
	
	@RequestMapping(value="/lop/delete/{id}")
	public String deleteIndex(@PathVariable(value="id")String id,Model model,RedirectAttributes redirect){
		System.out.println("id "+id);
		sevices.DeleteLopInKhoahoc(Integer.parseInt(id));
		return "redirect:/lop";
	}
	
}
