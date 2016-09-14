package vn.com.imic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Monhoc;
import vn.com.imic.service.IGiangDayService;

@Controller
public class GiangDayController {
	@Autowired
	private IGiangDayService giangDayService;

	@ModelAttribute("monHocs")
	public List<Monhoc> getAllMonHoc() {
		List<Monhoc> listMonHoc = giangDayService.getMonHocs();
		return listMonHoc;
	}

	@ModelAttribute("khoaHocs")
	public List<Khoahoc> getAllKhoaHoc() {
		System.out.println("Run khoaHocModelAtrribute:");
		List<Khoahoc> khoaHocs = giangDayService.getKhoaHocs(1);
		// for (Khoahoc khoahoc : khoaHocs) {
		// System.out.println("KhoaHoc Du Dieu Kien: " +
		// khoahoc.getMakhoahoc());
		// }
		return khoaHocs;
	}

	@RequestMapping(value = "/phancong", method = RequestMethod.GET)
	public String xemDanhSachGiangDay(Model model) {
		List<Giaovien> giaoViens = giangDayService.getGiaoVien();
		System.out.println("ListGiaoVien: " + giaoViens.size());
		List<Monhoc> monHocs = giangDayService.getMonHoc();
		System.out.println("ListMonHoc: " + monHocs.size());
		model.addAttribute("giaoViens", giaoViens);
		model.addAttribute("monHocs", monHocs);
		return "giangday/phancong";
	}

	@RequestMapping(value = "/phancong/confirmUpdate", method = RequestMethod.POST)
	public String conFirmupdate(@ModelAttribute("giaoVien") Giaovien giaoVien1) {
//		giangDayService.updatePhanCong(giaoVien1);
		System.out.println("Zooooo");
		return "redirect:/phancong";
	}

	@RequestMapping(value = "/phancong/{maGiaoVien}/update", method = RequestMethod.GET)
	public String updatePhanCong(@PathVariable("maGiaoVien") int maGiaoVien, Model model) {
		System.out.println("Begin UpdatePhanCong");
		Giaovien giaovien = giangDayService.getGiaoVien(maGiaoVien, 1);
		System.out.println("GiaoVien: " + giaovien.getMagiaovien() + " - " + giaovien.getTen());
		List<Giangday> giangdays = giaovien.getGiangday();
		System.out.println("Size GiaoVien Day Nam 1: " + giangdays.size());
		System.out.println("Danh Sach Giang Day Nam 1: ");
		for (Giangday giangday : giangdays) {
			System.out.println("KhoaHoc: " + giangday.getKhoahoc().getMakhoahoc() + "- LopHoc: "
					+ giangday.getKhoahoc().getLop().getTenlop() + "- MonHoc: " + giangday.getMonhoc().getTenmonhoc());
		}
		for (Khoahoc khoahoc : giaovien.getKhoahoc()) {
			System.out.println("Khoa Hoc Chu Nhiem: " + khoahoc.getMakhoahoc());
		}
		model.addAttribute("giaoVien", giaovien);
		return "giangday/phancong_update";
	}
}
