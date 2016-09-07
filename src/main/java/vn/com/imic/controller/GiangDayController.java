package vn.com.imic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.imic.model.Giangday;
import vn.com.imic.service.IGiangDayService;

@Controller
public class GiangDayController {
	@Autowired
	private IGiangDayService giangDayService;

	@RequestMapping(value = "/phancong", method = RequestMethod.GET)
	public String xemDanhSachGiangDay(Model model) {
		List<Giangday> giangdays = giangDayService.getAll();
		model.addAttribute("giangdays", giangdays);
		return "giangday/phancong";
	}
}
