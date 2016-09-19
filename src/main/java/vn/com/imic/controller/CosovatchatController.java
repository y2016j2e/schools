package vn.com.imic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.com.imic.model.Banghe;
import vn.com.imic.model.Cosovatchat;
import vn.com.imic.model.Diemtruong;
import vn.com.imic.model.Khuonvien;
import vn.com.imic.model.Namhoc;
import vn.com.imic.model.NhaXe;
import vn.com.imic.model.Nhavesinh;
import vn.com.imic.model.Thietbi;
import vn.com.imic.service.Bangheimpl;
import vn.com.imic.service.CosovatchatService;
import vn.com.imic.service.DiemtruongServicesIplm;
import vn.com.imic.service.KhuonVienImpl;
import vn.com.imic.service.NamhocServices;
import vn.com.imic.service.Nhavesinhimpl;
import vn.com.imic.service.Nhaxeimpl;
import vn.com.imic.service.ServicesInterface;
import vn.com.imic.service.Thietbiimpl;

@Controller
@Scope(scopeName = "session")
public class CosovatchatController {
	@Autowired
	private ServicesInterface<Diemtruong> diemtruongser;

	@Autowired
	private CosovatchatService<Banghe> bangheservice;

	@Autowired
	private CosovatchatService<Khuonvien> khuonvienser;

	@Autowired
	private CosovatchatService<Nhavesinh> nvsser;

	@Autowired
	private CosovatchatService<NhaXe> nxeser;

	@Autowired
	private CosovatchatService<Thietbi> thietbiser;

	// @RequestMapping(value = "cosovatchat")
	// public ModelAndView viewdt() {
	// ModelAndView model = new ModelAndView("cosovatchat");
	// int id = 0;
	// List<Diemtruong> listdt = new ArrayList<>();
	// listdt = diemtruongser.getAllObjects();
	// System.out.println("DIEM TRUONG: "+listdt.get(0));
	// List<Banghe> lisbg = new ArrayList<>();
	// int[] a = new int[listdt.size() - 1];
	// for (int i = 0; i < listdt.size() - 1; i++) {
	// a[i] = listdt.get(i).getMadiemtruong();
	// lisbg.set(i, (Banghe) bangheservice.findByCondition(a[i],
	// listdt.get(i).getCosovatchat().getMacosovatchat(),
	// id));
	// }
	//// model.addObject("banghe", lisbg);
	// model.addObject("dt", listdt);
	// return model;
	//
	// }

	@ModelAttribute("diemtruong")
	public List<Diemtruong> getAllDiemtruong() {
		List<Diemtruong> listdt = new ArrayList<>();
		Diemtruong e = new Diemtruong();
		e.setMadiemtruong(1);
		e.setDiachi("diachi");
		e.setEmail("email");
		e.setSdt("sdt");
		e.setTendiemtruong("Diem truong A");
		listdt.add(e);
		listdt = diemtruongser.getAllObjects();
		return listdt;
	}

	@ModelAttribute("khuonvien")
	@RequestMapping("cosovatchat/khuonvien")
	public Khuonvien getkvById(int iddt) {
		Khuonvien kv = new Khuonvien();
		kv = (Khuonvien) khuonvienser.findByCondition(iddt);
		return kv;
	}

	@ModelAttribute("banghe")
	@RequestMapping("cosovatchat/banghe")
	public Banghe getbgById(int iddt) {
		Banghe bg = new Banghe();
		bg = (Banghe) bangheservice.findByCondition(iddt);
		return bg;
	}

	@ModelAttribute("nhavesinh")
	@RequestMapping("cosovatchat/nhavesinh")
	public Nhavesinh getnvsById(int iddt) {
		Nhavesinh kv = new Nhavesinh();
		kv = (Nhavesinh) nvsser.findByCondition(iddt);
		return kv;
	}

	@ModelAttribute("nhaxe")
	@RequestMapping("cosovatchat/nhaxe")
	public NhaXe getnxById(int iddt) {
		NhaXe nx = new NhaXe();
		nx = (NhaXe) nxeser.findByCondition(iddt);
		return nx;
	}

	@ModelAttribute("thietbis")
	@RequestMapping("cosovatchat/thietbi")
	public List<Thietbi> gettbById() {
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		if (diemtruongs.size() == 0) {
			System.out.println("Size: " + diemtruongs.size());
			return null;
		} else {
			List<Thietbi> thietbis = new ArrayList<>();
			for (Diemtruong diemtruong : diemtruongs) {
				Thietbi tb = new Thietbi();
				tb = thietbiser.FindById(diemtruong.getMadiemtruong());
				thietbis.add(tb);
			}
			return thietbis;
		}
	}

	@RequestMapping(value = "cosovatchat", method = RequestMethod.GET)
	public String xemByDiemtruong(Model model) {
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		model.addAttribute("listdt", diemtruongs);
		return "cosovatchat/cosovatchat";
	}

}
