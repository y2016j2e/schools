package vn.com.imic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cosovatchat")
public class Cosovatchat {
	@Id
	private int macosovatchat;
	
	@Column(name="ten",nullable=false)
	private String ten;
	
	@Column(name="soluong",nullable=false)
	private int soluong;
	
	@Column(name="dongia",nullable=false)
	private int dongia;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="diemtruong")
	private Diemtruong diemtruong;

	public int getMacosovatchat() {
		return macosovatchat;
	}

	public void setMacosovatchat(int macosovatchat) {
		this.macosovatchat = macosovatchat;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getDongia() {
		return dongia;
	}

	public void setDongia(int dongia) {
		this.dongia = dongia;
	}

	public Diemtruong getDiemtruong() {
		return diemtruong;
	}

	public void setDiemtruong(Diemtruong diemtruong) {
		this.diemtruong = diemtruong;
	}
	
	
}
