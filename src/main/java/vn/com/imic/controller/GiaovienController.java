package vn.com.imic.controller;


import java.beans.PropertyEditorSupport;
import java.lang.annotation.Annotation;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;

import vn.com.imic.service.GiaovienValidator;
import vn.com.imic.model.Giaovien;
import vn.com.imic.service.GiaovienServices;

@Controller
@Scope(scopeName = "session")
public class GiaovienController {

    @Autowired
    private GiaovienServices    giaovienServices;

    @Autowired
    private GiaovienValidator gvValidator;
    
    private int r= 10;
    
    //Need validator class . for date and other type of input text.

    @InitBinder
    public void dataBinding(WebDataBinder binder){

    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	dateFormat.setLenient(true);
    	binder.registerCustomEditor(Date.class,"ngaysinh",  new CustomDateEditor(dateFormat, true));
        binder.setValidator(gvValidator);

    }



    @RequestMapping(value="/giaovien", method = RequestMethod.GET) //set info of giaovien to show
    public String showData(Model model){
        List<Giaovien> giaovienList = giaovienServices.getALL();
        System.out.println(giaovienList.get(0).getMagiaovien());
        model.addAttribute("giaovienList", giaovienList);
    	return "giaovien/giaovien";
    }
    
    @RequestMapping(value="/giaovien/rows", method = RequestMethod.GET)
    public String selectedRow(Model model,@ModelAttribute("rows") String row , BindingResult result, RedirectAttributes redirect){
      r = Integer.parseInt(row);
    return "redirect:/giaovien";
    }
    
    
    @RequestMapping(value="/giaovien/delete/{id}")//delete Giao vien
    public String deleteIndex(@PathVariable("id") int id ,RedirectAttributes redirect){
    	System.out.println("Giao vien ID : "+ id);
    	giaovienServices.deleteGiaovien(id);
    	return  "redirect:/giaovien";
    }
  
    @RequestMapping(value="/giaovien/addGiaoVien", method = RequestMethod.GET)
    public ModelAndView setAndView(){
    	ModelAndView model = new ModelAndView("giaovien/addGiaoVien");
    	  	/////// ???????????
    	model.addObject("giaovien", new Giaovien());
    	return model;
    }
    
    @RequestMapping(value="/giaovien/addGV", method = RequestMethod.POST) //add giaovien Object
    public String addGiaoVien(Model model, @ModelAttribute("giaovien") @Validated Giaovien giaovien, BindingResult result, RedirectAttributes redirect){
    	if (result.hasErrors()){
            return "/giaovien/addGiaoVien";
        }
        giaovienServices.saveOrupdate(giaovien);
    	return "redirect:/giaovien";
    }
    
    
    @RequestMapping(value="/giaovien/editGiaoVien/{id}" , method = RequestMethod.GET)// edit giao vien 
    public ModelAndView editGiaovien(@PathVariable("id") int id  , RedirectAttributes redirect){
        // tim giao vien theo ID
    	ModelAndView model = new ModelAndView("giaovien/editGiaoVien");
        // add giao vien vao model
        Giaovien giaovien = giaovienServices.getGVbyID(id);

		model.addObject("giaovien", giaovien);
		return model;

    }
    	        
    
    @RequestMapping(value="/giaovien/update", method =  RequestMethod.POST) /// update giao vien trong edit form
    public String updateGV( @ModelAttribute("giaovien")  @Validated Giaovien giaovien, BindingResult  result,RedirectAttributes redirect,Model model ){
    	if(result.hasErrors()){
                return "/giaovien/editGiaoVien";
        }

        giaovienServices.saveOrupdate(giaovien);
        System.out.println("GiaoVien: "+giaovien.getTen());
        return "redirect:/giaovien";
      	
    }

}

