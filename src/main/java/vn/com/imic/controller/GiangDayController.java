package vn.com.imic.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String xemDanhSachGiangDay(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			Model model, HttpSession session) {
		Integer record = (Integer) session.getAttribute("record");
		if (record == null) {
			record = 5;
		}
		int totalRecord = giangDayService.countGiaoVien();
		int totalPage = 0;
		if (totalRecord % record == 0) {
			totalPage = totalRecord / record;
		} else {
			totalPage = (totalRecord / record) + 1;
		}
		int first = (page - 1) * record;
		List<Giaovien> giaoViens = giangDayService.getGiaoVienLimit(first, record);
		// System.out.println("ListGiaoVien: " + giaoViens.size());
		List<Monhoc> monHocs = giangDayService.getMonHoc();
		// System.out.println("ListMonHoc: " + monHocs.size());
		model.addAttribute("giaoViens", giaoViens);
		model.addAttribute("monHocs", monHocs);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalRecord", totalRecord);
		return "giangday/phancong";

	}

	@RequestMapping(value = "/pagesize", method = RequestMethod.GET)
	public String selectRecord(@RequestParam("record") int record, HttpSession session) {
		session.setAttribute("record", record);
		return "redirect:/phancong";
	}

	@RequestMapping(value = "/phancong/confirmUpdate", method = RequestMethod.POST)
	public String conFirmupdate(@ModelAttribute("giaoVien") Giaovien giaoVien, RedirectAttributes redirectAttributes) {
		// System.out.println("Size KhoaHoc: " + giaoVien.getKhoahoc().size());
		// System.out.println("Khoa Hoc Chua Tim Kiem: " +
		// giaoVien.getKhoahoc());
		// System.out.println("MaKhoaHocChuNhiem: " +
		// giaoVien.getKhoahoc().get(0).getMakhoahoc());
		int i = 1;
		Map<Integer, String> erros = new HashMap<>();
		int maKhoaHoc = giaoVien.getKhoahoc().get(0).getMakhoahoc();
		Khoahoc khoahoc = giangDayService.findKhoaHoc(maKhoaHoc);
		System.out.println("KhoaHocChuNhiem: " + khoahoc);
		if (khoahoc != null) {
			Giaovien giaoVienChuNhiem = khoahoc.getChunhiem();
			if (giaoVienChuNhiem != null && giaoVien.getMagiaovien() != giaoVienChuNhiem.getMagiaovien()) {
				erros.put(i, "Lớp " + khoahoc.getLop().getTenlop() + " đã được phân công cho giáo viên "
						+ giaoVienChuNhiem.getTen() + " chủ nhiệm");
			}
		}
		if (giaoVien.getGiangday() != null) {

			List<Giangday> listGiangDay = giaoVien.getGiangday();

			// System.out.println("Truoc luc remove: " + listGiangDay.size());

			Iterator<Giangday> iteratorListGiangDay = listGiangDay.iterator();

			while (iteratorListGiangDay.hasNext()) {
				Giangday giangday = iteratorListGiangDay.next();
				if (giangday.getKhoahoc() == null) {
					iteratorListGiangDay.remove();
				}
			}

			// System.out.println("Sau Khi remove: " + listGiangDay.size());
			// System.out.println("SizeGiangDay cua GiaoVien Ma: " +
			// giaoVien.getMagiaovien() + "La: "
			// + giaoVien.getGiangday().size());
			// for (Giangday giangday : giaoVien.getGiangday()) {
			// System.out.println("KhoaHoc: " +
			// giangday.getKhoahoc().getMakhoahoc() + " MonHoc: "
			// + giangday.getMonhoc().getMamonhoc());
			// }

			List<Giangday> giangdays = giangDayService.getAll(1);
			for (Giangday giangday : giangdays) {
				if (giangDayService.checkPhanCong(listGiangDay, giangday) == true) {
					Giaovien giaovienGiangDay = giangday.getGiaovien();
					if (giangday.getGiaovien().getMagiaovien() != giaoVien.getMagiaovien()) {
						i++;
						erros.put(i, "Môn " + giangday.getMonhoc().getTenmonhoc() + " đã được phân công cho giáo viên "
								+ giangday.getGiaovien().getTen());
					}
				}
			}
		}
		if (!erros.isEmpty()) {
			redirectAttributes.addFlashAttribute("erros", erros);
			return "redirect:/phancong/" + giaoVien.getMagiaovien() + "/update";
		}
		giangDayService.updatePhanCong(giaoVien);
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
