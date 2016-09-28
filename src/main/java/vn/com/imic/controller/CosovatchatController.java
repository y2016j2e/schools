package vn.com.imic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.imic.model.Banghe;
import vn.com.imic.model.Diemtruong;
import vn.com.imic.model.Khuonvien;
import vn.com.imic.model.Khuonvienform;
import vn.com.imic.model.NhaXe;
import vn.com.imic.model.Nhavesinh;
import vn.com.imic.model.Nhavesinhform;
import vn.com.imic.model.NhaxeTG;
import vn.com.imic.model.Phonghoc;
import vn.com.imic.model.Thietbi;
import vn.com.imic.model.Thietbiform;
import vn.com.imic.model.bangheform;
import vn.com.imic.model.phonghocform;
import vn.com.imic.service.CosovatchatService;
import vn.com.imic.service.ServicesInterface;

@Controller
@Scope(scopeName = "session")
public class CosovatchatController {
	@Autowired
	private ServicesInterface<Diemtruong> diemtruongser;

	@Autowired
	@Qualifier("bangheS")
	private CosovatchatService<Banghe> bangheservice;

	@Autowired
	@Qualifier("khuonvienS")
	private CosovatchatService<Khuonvien> khuonvienser;

	@Autowired
	@Qualifier("nhavesinhS")
	private CosovatchatService<Nhavesinh> nvsser;

	@Autowired
	@Qualifier("nhaxeS")
	private CosovatchatService<NhaXe> nxeser;

	@Autowired
	@Qualifier("thietbiS")
	private CosovatchatService<Thietbi> thietbiser;

	@Autowired
	@Qualifier("phonghocS")
	private CosovatchatService<Phonghoc> phonghocser;

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
	@RequestMapping(value = "cosovatchat/nhaxe", method = RequestMethod.GET)
	public ModelAndView getnxById() {
		ModelAndView model = new ModelAndView("cosovatchat/nhaxe");
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		List<NhaXe> nhaxes = new ArrayList<>();
		NhaxeTG nhaxeTG = new NhaxeTG();
		for (Diemtruong diemtruong : diemtruongs) {
			NhaXe nhaxe = (NhaXe) nxeser.FindById(diemtruong.getCosovatchat().getNhaXe().getMaNhaxe());
			nhaxes.add(nhaxe);
		}
		model.addObject("nhaxes", nhaxes);
		model.addObject("nhaxetemp", nhaxeTG);
		return model;

	}

	@RequestMapping(value = "cosovatchat/banghe", method = RequestMethod.GET)
	public ModelAndView getbgById() {
		ModelAndView model = new ModelAndView("cosovatchat/banghe");
		bangheform bangheform = new bangheform();
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		List<Banghe> banghes = new ArrayList<>();
		for (Diemtruong diemtruong : diemtruongs) {
			Banghe bg = (Banghe) bangheservice.FindById(diemtruong.getMadiemtruong());
			banghes.add(bg);
		}
		model.addObject("banghetemp", bangheform);
		model.addObject("banghes", banghes);
		return model;
	}

	@RequestMapping(value = "cosovatchat/nhavesinh", method = RequestMethod.GET)
	public ModelAndView getnvsById() {
		ModelAndView model = new ModelAndView("cosovatchat/nhavesinh");
		Nhavesinhform nhavesinhform = new Nhavesinhform();
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		List<Nhavesinh> nhavss = new ArrayList<>();
		for (Diemtruong diemtruong : diemtruongs) {
			Nhavesinh nvs = (Nhavesinh) nvsser.FindById(diemtruong.getCosovatchat().getNhaXe().getMaNhaxe());
			nhavss.add(nvs);
		}
		model.addObject("nhavesinhtemp", nhavesinhform);
		model.addObject("nhavss", nhavss);
		return model;
	}

	@RequestMapping(value = "cosovatchat/phonghoc", method = RequestMethod.GET)
	public ModelAndView getphonghocById() {
		ModelAndView model = new ModelAndView("cosovatchat/phonghoc");
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		phonghocform phonghocform = new phonghocform();
		List<Phonghoc> phonghocs = new ArrayList<>();
		for (Diemtruong diemtruong : diemtruongs) {
			Phonghoc ph = phonghocser.FindById(diemtruong.getMadiemtruong());
			phonghocs.add(ph);
		}
		model.addObject("phonghoctemp", phonghocform);
		model.addObject("phonghocs", phonghocs);
		return model;
	}

	@RequestMapping(value = "cosovatchat/khuonvien", method = RequestMethod.GET)
	public ModelAndView getkvById() {
		ModelAndView model = new ModelAndView("cosovatchat/khuonvien");
		Khuonvienform khuonvienform = new Khuonvienform();
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		if (diemtruongs.size() == 0) {
			System.out.println("Size: " + diemtruongs.size());
			return null;
		} else {
			 List<Double> lissum = new ArrayList<>();
			List<Khuonvien> khuonviens = new ArrayList<>();
			for (Diemtruong diemtruong : diemtruongs) {
				Khuonvien kv = new Khuonvien();
				kv = khuonvienser.FindById(diemtruong.getMadiemtruong());
				double Ssum = kv.getDithue() + kv.getDuoccap() + kv.getSanchoi() + kv.getSantap();
				System.out.println(Ssum);
				khuonviens.add(kv);
				lissum.add(Ssum);
			}
			System.out.println("sizee:" +lissum.size());
			model.addObject("listsum", lissum);
			model.addObject("khuonviens", khuonviens);
			model.addObject("khuonvientemp", khuonvienform);

			return model;
		}
	}

	@RequestMapping(value = "cosovatchat/thietbi", method = RequestMethod.GET)
	public ModelAndView gettbById() {
		ModelAndView model = new ModelAndView("cosovatchat/thietbi");
		Thietbiform thietbiform = new Thietbiform();
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		List<Thietbi> thietbis = new ArrayList<>();
		for (Diemtruong diemtruong : diemtruongs) {
			Thietbi tb = new Thietbi();
			tb = thietbiser.FindById(diemtruong.getMadiemtruong());
			thietbis.add(tb);
		}
		model.addObject("thietbitemp", thietbiform);
		model.addObject("thietbis", thietbis);
		return model;
	}

	@RequestMapping(value = "cosovatchat/nhavesinh", method = RequestMethod.POST)
	public String EditNvs(Model model, @ModelAttribute("nhavesinh") Nhavesinh nhavesinh ) {
		Nhavesinh nvs = nvsser.FindById(nhavesinh.getMaNvs());
		nvs.setGvnamchuadatchuan(nhavesinh.getGvnamchuadatchuan());
		nvs.setGvnamdatchuan(nhavesinh.getGvnamdatchuan());
		nvs.setGvnuchuadatchuan(nhavesinh.getGvnuchuadatchuan());
		nvs.setGvnudatchuan(nhavesinh.getGvnudatchuan());
		nvs.setHsnamchuadatchuan(nhavesinh.getHsnamchuadatchuan());
		nvs.setHsnamdatchuan(nhavesinh.getHsnamdatchuan());
		nvs.setHsnuchuadatchuan(nhavesinh.getHsnuchuadatchuan());
		nvs.setHsnudatchuan(nhavesinh.getHsnudatchuan());
		nvs.setSgvnamchuachuan(nhavesinh.getSgvnamchuachuan());
		nvs.setSgvnamchuan(nhavesinh.getSgvnamchuan());
		nvs.setSgvnnuchuan(nhavesinh.getSgvnnuchuan());
		nvs.setSgvnuchuachuan(nhavesinh.getSgvnuchuachuan());
		nvs.setShsnamchuachuan(nhavesinh.getShsnamchuachuan());
		nvs.setShsnamchuan(nhavesinh.getShsnamchuan());
		nvs.setShsnuchuachuan(nhavesinh.getShsnuchuachuan());
		nvs.setShsnuchuan(nhavesinh.getShsnuchuan());
		nvsser.SaveOrUpdate(nvs);
		return "redirect:nhavesinh";

	}

	@RequestMapping(value = "cosovatchat/nhaxe", method = RequestMethod.POST)
	public String EditNxe(Model model, @ModelAttribute("nhaxetemp") NhaxeTG nhaxetg) {
		int id = Integer.parseInt(nhaxetg.getManhaxe());
		System.out.println("id:" +id);
		NhaXe nxe = nxeser.FindById(id);
		if (nhaxetg.getNhaxegv() == "") {
			nxe.setNhaxegv(0);
		} else {
			nxe.setNhaxegv(Integer.parseInt(nhaxetg.getNhaxegv()));
		}
		if (nhaxetg.getNhaxehs() == "") {
			nxe.setNhaxehs(0);
		} else {
			nxe.setNhaxehs(Integer.parseInt(nhaxetg.getNhaxehs()));
		}
		if (nhaxetg.getSgv() == "") {
			nxe.setSgv(0);
		} else {
			nxe.setSgv(Double.parseDouble(nhaxetg.getSgv()));
		}
		if (nhaxetg.getShs() == "") {
			nxe.setShs(0);
		} else {
			nxe.setShs(Double.parseDouble(nhaxetg.getShs()));
		}
		nxeser.SaveOrUpdate(nxe);
		return "redirect: nhaxe";
	}

	@RequestMapping(value = "cosovatchat/khuonvien", method = RequestMethod.POST)
	public String EditKv(@ModelAttribute("khuonvientemp") Khuonvienform khuonvienform) {
		Khuonvien kv = khuonvienser.FindById(khuonvienform.getMakhuonvien());
		if(khuonvienform.getDieukienngoaitroi().equals("x")==true||khuonvienform.getDieukienngoaitroi().equals("X")==true )
		{
			kv.setDieukienngoaitroi(true);
			System.out.println("X");
		}
		else kv.setDieukienngoaitroi(false);
		System.out.println(kv.isDieukienngoaitroi());
		kv.setDithue(khuonvienform.getDithue());
		kv.setDuoccap(khuonvienform.getDuoccap());
		kv.setSanchoi(khuonvienform.getSanchoi());
		kv.setSoluonvuon(khuonvienform.getSoluonvuon());
		kv.setSantap(khuonvienform.getSantap());
		khuonvienser.SaveOrUpdate(kv);
		return "redirect: khuonvien";
	}

	@RequestMapping(value = "cosovatchat/phonghoc", method = RequestMethod.POST)
	public String Editph(@ModelAttribute("phonghoctemp") phonghocform phonghocform) {
		Phonghoc ph = phonghocser.FindById(phonghocform.getMaP());
		if(phonghocform.getXaymoi().equals("x")==true||phonghocform.getXaymoi().equals("X")==true )
		{
			ph.setXaymoi(true);
			System.out.println("X");
		}
		else ph.setXaymoi(false);
		ph.setCapdoxd(phonghocform.getCapdoxd());
		ph.setDientich(phonghocform.getDientich());
		ph.setTenPhong(phonghocform.getTenPhong());
		phonghocser.SaveOrUpdate(ph);
		return "redirect: phonghoc";
	}

	@RequestMapping(value = "cosovatchat/banghe", method = RequestMethod.POST)
	public String Editbg(@ModelAttribute("banghetemp") bangheform bangheform) {
		Banghe bg = bangheservice.FindById(bangheform.getMaBanGhe());
		bg.setBanBon(bangheform.getBanBon());
		bg.setBanHai(bangheform.getBanHai());
		bg.setGheBon(bangheform.getGheBon());
		bg.setGheHai(bangheform.getGheHai());
		bangheservice.SaveOrUpdate(bg);
		return "redirect:banghe";
	}

	@RequestMapping(value = "cosovatchat/thietbi", method = RequestMethod.POST)
	public String Edittb(@ModelAttribute("thietbitemp") Thietbiform thietbiform) {
		Thietbi thietbi = thietbiser.FindById(thietbiform.getMaTbi());
		if(thietbiform.getInternet().equals("x")||thietbiform.equals("x")){
			thietbi.setInternet(true);
		}
		else thietbi.setInternet(false);
		thietbi.setMaygv(thietbiform.getMaygv());
		thietbi.setMayhs(thietbiform.getMayhs());
		thietbi.setMaychieu(thietbiform.getMaychieu());
		thietbiser.SaveOrUpdate(thietbi);
		return "redirect:thietbi";
	}

}
