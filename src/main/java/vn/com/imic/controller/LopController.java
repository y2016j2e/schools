package vn.com.imic.controller;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.imic.dao.LopDao;
import vn.com.imic.model.Diemtruong;
import vn.com.imic.model.Hocky;
import vn.com.imic.model.Hocsinh;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.KhoahocDataTemp;
import vn.com.imic.model.Lop;
import vn.com.imic.model.LopDataTemp;
import vn.com.imic.model.Namhoc;
import vn.com.imic.service.HocsinhLopServices;
import vn.com.imic.service.LopServices;
import vn.com.imic.service.NamhocServices;
import vn.com.imic.service.ServicesInterface;

@Controller
@Scope(scopeName="session")
public class LopController {
	
	@Autowired
	private LopServices sevices;
	
	@Autowired
	private NamhocServices namhocServices;
	
	@Autowired
	private ServicesInterface<Hocky> hockiServices;
	
	@Autowired
	private ServicesInterface<Diemtruong> diemtruongServices;
	
	@Autowired
	private HocsinhLopServices hocsinhServices;
	
	@Autowired
	private LopDao dao;
	
//	@Autowired
//	private AddLopValidate lopValidate;

	
	private KhoahocDataTemp t;
	private int r=5;
	private int hsr = 5;
	private Khoahoc khtemp = null;

	private int checkAddHs = 0;
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder){
//		binder.setValidator(lopValidate);
		binder.registerCustomEditor(Diemtruong.class,"diemtruong",new PropertyEditorSupport(){ //add object for selected option in jsp file
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Diemtruong diemtruong = diemtruongServices.getObjectById(Integer.parseInt(text));
				setValue(diemtruong);
			}
		});
		
		binder.registerCustomEditor(Namhoc.class,"namhoc", new PropertyEditorSupport(){

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Namhoc namhoc = namhocServices.getNamhocById(Integer.parseInt(text));
				setValue(namhoc);
			}
			
		});
		
		binder.registerCustomEditor(Hocky.class,"hocky", new PropertyEditorSupport(){

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Hocky hocky = hockiServices.getObjectById(Integer.parseInt(text));
				setValue(hocky);
			}
			
		});
	}
	
	
//	@RequestMapping(value="/lop/row/{num}",method = RequestMethod.GET)
//	public ModelAndView setViewLop(@RequestParam(value="page",required=false) String page, HttpServletRequest request,@PathVariable("num") int num){
//		System.out.println(num);
//		ModelAndView model = new ModelAndView("lop/lop");
//		int count = sevices.getPage("2016-2017","Học Kỳ I","Imic Hoàng Quốc Việt",num);
//		System.out.println(count+"so page");
//		List<Khoahoc> lis = new ArrayList<>();
//		if(page!=null){
//			int pg = Integer.parseInt(page);
//			lis = sevices.getLimitLopInKhoahoc("2016-2017","Học Kỳ I","Imic Hoàng Quốc Việt",num*(pg-1),num);
//			model.addObject("act",pg);
//		}
//		else{
//			lis = sevices.getLimitLopInKhoahoc("2016-2017","Học Kỳ I","Imic Hoàng Quốc Việt",0,num);
//			model.addObject("act",1);
//		}
//		model.addObject("lastpage",count);
//		model.addObject("lop", new Khoahoc());
//		model.addObject("lis", lis);
//		return model;
//	}
//	
	
	//Show info 
	
	@RequestMapping(value="/lop",method = RequestMethod.GET)
	public ModelAndView setViewLopa(@RequestParam(value="page",required=false) String page, HttpServletRequest request){
		
		ModelAndView model = new ModelAndView("lop/lop");
		int count = sevices.getPageById(t.getNamhoc(),t.getHocki(),t.getDiemtruong(),r);
		System.out.println(count+"so page");
		List<Khoahoc> lis = new ArrayList<>();
		if(page!=null){
			int pg = Integer.parseInt(page);
			lis = sevices.getLimitLopInKhoahocById(t.getNamhoc(),t.getHocki(),t.getDiemtruong(),r*(pg-1),r);
			model.addObject("act",pg);
		}
		else{
			lis = sevices.getLimitLopInKhoahocById(t.getNamhoc(),t.getHocki(),t.getDiemtruong(),0,r);
			model.addObject("act",1);
		}
		
		List<String> ss = new ArrayList<>();
		for(int i=0;i<lis.size();i++){
			ss.add(hocsinhServices.countHocsinhInLop(lis.get(i).getMakhoahoc())+"");
		}
		
		List<Namhoc> nam = new ArrayList<>();
		nam = namhocServices.getAllNamhoc();
//		nam.add("2016-2017");
//		nam.add("2015-2016");
		
		List<Hocky> hk = new ArrayList<>();
		hk = hockiServices.getAllObjects();
//		hk.add("Học Kỳ I");
//		hk.add("Học Kỳ II");
		
		List<Diemtruong> dt = new ArrayList<>();
		dt = diemtruongServices.getAllObjects();
//		dt.add("Imic Hoàng Quốc Việt");
//		dt.add("Imic Cầu Giấy");
		
		model.addObject("nrow", r);
		model.addObject("lastpage",count);
		model.addObject("lop", new Khoahoc());
		model.addObject("lis", lis);
		model.addObject("ss", ss);
		model.addObject("nam", nam);
		model.addObject("hk", hk);
		model.addObject("dt", dt);
		model.addObject("temp", new KhoahocDataTemp());
		
		
		return model;
	}
	
	@RequestMapping(value="/lop/xem",method = RequestMethod.POST) //set info to show
	public String showData(Model model,@ModelAttribute("temp") KhoahocDataTemp temp,BindingResult result,
			RedirectAttributes redirect){
		t = temp;
		return "redirect:/lop";
	}
	
	@RequestMapping(value="/lop/row",method = RequestMethod.POST) //set number of row
	public String selectRow(Model model,@ModelAttribute("row") String row,BindingResult result,
			RedirectAttributes redirect){
		r = Integer.parseInt(row);
		return "redirect:/lop";
	}
	
	@RequestMapping(value="/lop/delete/{id}") //delete object
	public String deleteIndex(@PathVariable(value="id")String id,Model model,RedirectAttributes redirect){
		System.out.println("id "+id);
		sevices.DeleteLopInKhoahoc(Integer.parseInt(id));
		return "redirect:/lop";
	}
	
	//show add object's view
//	@RequestMapping(value="/lop/add",method = RequestMethod.GET)
//	public ModelAndView setAddView(){
//		ModelAndView model = new ModelAndView("lop/addLop");
//		List<Namhoc> nam = new ArrayList<>();
//		nam = namhocServices.getAllNamhoc();
//		
//		List<Hocky> hk = new ArrayList<>();
//		hk = hockiServices.getAllObjects();
//		
//		List<Diemtruong> dt = new ArrayList<>();
//		dt = diemtruongServices.getAllObjects();
//		
//		model.addObject("nam", nam);
//		model.addObject("hk", hk);
//		model.addObject("dt", dt);
//		model.addObject("loptemp", new LopDataTemp());
//		return model;
//	}
//	
//	@RequestMapping(value="/lop/addLop",method = RequestMethod.POST) //add object
//	public String addLop(Model model,@ModelAttribute("loptemp") @Validated LopDataTemp loptemp,BindingResult result,
//			RedirectAttributes redirect){
////		System.out.println(loptemp.getTenlop());
////		if(result.hasErrors()){
////			List<Namhoc> nam = new ArrayList<>();
////			nam = namhocServices.getAllNamhoc();
////			
////			List<Hocky> hk = new ArrayList<>();
////			hk = hockiServices.getAllObjects();
////			
////			List<Diemtruong> dt = new ArrayList<>();
////			dt = diemtruongServices.getAllObjects();
////			
////			model.addAttribute("nam", nam);
////			model.addAttribute("hk", hk);
////			model.addAttribute("dt", dt);
////			model.addAttribute("loptemp", new LopDataTemp());
////			return "lop/addLop";
////		}
////		
//		Khoahoc kh = new Khoahoc();
//		kh.setHocky(loptemp.getHocky());
//		kh.setNamhoc(loptemp.getNamhoc());
//		Lop lop = null;
//		//check Lop, if Lop already exists , do nothing , else add new Lop
//		if(null == sevices.findLop(loptemp.getTenlop(),loptemp.getDiemtruong().getTendiemtruong())){ 
//			lop = new Lop();
//			lop.setDiemtruong(loptemp.getDiemtruong());
//			lop.setSotiethoc(loptemp.getSotiethoc());
//			lop.setTenlop(loptemp.getTenlop());
//			kh.setLop(lop);
//		}
//		else {
//			lop = sevices.findLop(loptemp.getTenlop(),loptemp.getDiemtruong().getTendiemtruong());
//			lop.setSotiethoc(loptemp.getSotiethoc());
//			kh.setLop(lop);
//		}
//		
//		sevices.SaveOrUpdateLopInKhoahoc(lop, kh);
//		return "redirect:/lop";
//	}
	
	//show Edit view
	@RequestMapping(value="/lop/edit/{id}",method = RequestMethod.GET)
	public ModelAndView setEditView(@PathVariable(value="id") String id){
		ModelAndView model = new ModelAndView("lop/editLop");
		
		Khoahoc khoahoc = sevices.getKhoahocById(Integer.parseInt(id));
		khtemp = khoahoc;
		
		List<Namhoc> nam = new ArrayList<>();
		nam = namhocServices.getAllNamhoc();
		
		List<Hocky> hk = new ArrayList<>();
		hk = hockiServices.getAllObjects();
		
		List<Diemtruong> dt = new ArrayList<>();
		dt = diemtruongServices.getAllObjects();
		
		model.addObject("nam", nam);
		model.addObject("hk", hk);
		model.addObject("dt", dt);
		model.addObject("khoahoc",khoahoc);
		model.addObject("update", new LopDataTemp());
		return model;
	}
	
	@RequestMapping(value="/lop/update",method = RequestMethod.POST)
	public String updateLop(Model model,@ModelAttribute("update") LopDataTemp update,BindingResult result,
			RedirectAttributes redirect){
		
		if(khtemp.getLop().getSotiethoc() != update.getSotiethoc())
			khtemp.getLop().setSotiethoc(update.getSotiethoc());
		
		khtemp.setHocky(update.getHocky());
		khtemp.setNamhoc(update.getNamhoc());
		sevices.SaveOrUpdateLopInKhoahoc(khtemp.getLop(), khtemp);
		return "redirect:/lop";
	}
	
	
	
	@RequestMapping(value="/lop/download")
	public String downloadFile(HttpServletResponse response){
		dao.download();
		response.setContentType("application/xlsx");
		response.setHeader("Content-Disposition", "attachment; filename=excelfile.xlsx");
		try {
			InputStream input = new FileInputStream("C://Users/Administrator/Desktop/ex.xlsx");
			IOUtils.copy(input,response.getOutputStream());
			response.flushBuffer();
	        input.close();
	        File file = new File("C:/Users/Administrator/Desktop/ex.xlsx");
	        file.delete();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:/lop";
	}
	
	
	@RequestMapping(value="/lop/{id}",method = RequestMethod.GET)
	public ModelAndView viewHocsinh(@PathVariable(value="id") int id,@RequestParam(value="pg",defaultValue = "1") String pg){
		int count = hocsinhServices.countHocsinhInLop(id).intValue();
		ModelAndView model = new ModelAndView("lop/hocsinhlop");
		List<Hocsinh> lis = null;
		
		lis = hocsinhServices.getLimitHocsinhInLop(id, (Integer.parseInt(pg)-1)*hsr, hsr);
		List<Khoahoc> lisLop = sevices.getLopChange(id);

		List<Hocsinh> lisHS = hocsinhServices.getAllHocsinh();
		
		model.addObject("lis",lis);
		model.addObject("checkadd",checkAddHs);
		model.addObject("lisHS",lisHS);
		model.addObject("lenght",lisHS.size());
		model.addObject("count",count);
		model.addObject("act",Integer.parseInt(pg));
		model.addObject("hocsinh",new Hocsinh());
		model.addObject("lisLop",lisLop);
		model.addObject("khoahoc",sevices.getKhoahocById(id));
		return model;
	}
	
	@RequestMapping(value="/lop/{id}/delete/{hsid}")
	public String deleteHocsinhInLop(@PathVariable(value="id") int id,@PathVariable(value="hsid")int hsid,RedirectAttributes redirect){
		hocsinhServices.deleteHocsinhInLop(id,hsid);
		return "redirect:/lop/"+id;
	}
	
	@RequestMapping(value="/lop/{id}/change/{hsid}")
	public String changeLop(@PathVariable(value="id") int id,@PathVariable(value="hsid")int hsid,
			RedirectAttributes redirect,@ModelAttribute("chang")int chang){
		System.out.println("id : "+id);
		System.out.println("change : "+chang);
		sevices.changeLop(id,hsid,chang);
		return "redirect:/lop/"+id;
	}
	
	@RequestMapping(value="/lop/{id}/addIn",method = RequestMethod.POST)
	public String addInLop(@PathVariable(value="id") int id,
			RedirectAttributes redirect,@ModelAttribute("addHS")int maso){
		System.out.println("add "+maso);
		
		boolean x = hocsinhServices.addHocsinhToLop(maso, id);
		System.out.println(x);
		if(!x)
			checkAddHs = 1;
		else
			checkAddHs = 0;
		return "redirect:/lop/"+id;
	}
	
	
	@PostConstruct
	public void init(){
		//set Default info to show when begin
		t = new KhoahocDataTemp(1,1,1);
	}
	
}
