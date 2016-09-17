package vn.com.imic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.com.imic.model.Banghe;
import vn.com.imic.model.Cosovatchat;
import vn.com.imic.model.Diemtruong;
import vn.com.imic.model.Namhoc;
import vn.com.imic.service.Bangheimpl;
import vn.com.imic.service.CosovatchatService;
import vn.com.imic.service.DiemtruongServicesIplm;
import vn.com.imic.service.KhuonVienImpl;
import vn.com.imic.service.NamhocServices;
import vn.com.imic.service.NhavesinhImpl;
import vn.com.imic.service.NhaxeImpl;
import vn.com.imic.service.ServicesInterface;
import vn.com.imic.service.ThietbiImpl;

@Controller
@Scope(scopeName = "session")
public class CoSoVatChatController {
	@Autowired
	private DiemtruongServicesIplm diemtruongser;

	@Autowired
	private NamhocServices namhocSer;
	
	@Autowired
	private Bangheimpl bangheser;

	@Autowired
	private KhuonVienImpl khuonvienser;

	@Autowired
	private NhavesinhImpl nvsser;
	
	@Autowired
	private NhaxeImpl nxeser;

	@Autowired
	private ThietbiImpl thietbiser;
	
	@RequestMapping(value="/cosovatchat",method= RequestMethod.GET)
	public ModelAndView setBanghe(HttpServletRequest request){
		ModelAndView model = new ModelAndView("cosovatchat/cosovatchat");
		int id=0;
		List<Diemtruong> listdt =  diemtruongser.getAllObjects();
		List<Banghe> lisbg = new ArrayList<>();
		int []a= new int[listdt.size()-1];
		for(int i=0;i<listdt.size()-1;i++){
		a[i] =listdt.get(i).getMadiemtruong();
		lisbg.set(i,(Banghe)bangheser.findByCondition(a[i], listdt.get(i).getCosovatchat().getMacosovatchat(), id));	
		}
		model.addObject("banghe", lisbg);
		return model;
		
	}
}
