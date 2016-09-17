package vn.com.imic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="khuonvien")
public class Khuonvien {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int makhuonvien;
	@Column(name="duoccap",nullable= true)
	private boolean duoccap;
	@Column(name="dithue",nullable= true)
	private boolean dithue;
	@Column(name="sanchoi",nullable= true)
	private boolean sanchoi;
	@Column(name="santap",nullable= true)
	private boolean santap;
	@Column(name="dieukienngoaitroi",nullable= true)
	private boolean dieukienngoaitroi;
	@Column(name="dientich",nullable= true)
	private double dientich;
	@Column(name="soluonvuon",nullable= true)
	private int soluonvuon;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Cosovatchat cosovatchat;
	
	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}
	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}
	public int getMakhuonvien() {
		return makhuonvien;
	}
	public void setMakhuonvien(int makhuonvien) {
		this.makhuonvien = makhuonvien;
	}
	public boolean isDuoccap() {
		return duoccap;
	}
	public void setDuoccap(boolean duoccap) {
		this.duoccap = duoccap;
	}
	public boolean isDithue() {
		return dithue;
	}
	public void setDithue(boolean dithue) {
		this.dithue = dithue;
	}
	public boolean isSanchoi() {
		return sanchoi;
	}
	public void setSanchoi(boolean sanchoi) {
		this.sanchoi = sanchoi;
	}
	public boolean isSantap() {
		return santap;
	}
	public void setSantap(boolean santap) {
		this.santap = santap;
	}
	public boolean isDieukienngoaitroi() {
		return dieukienngoaitroi;
	}
	public void setDieukienngoaitroi(boolean dieukienngoaitroi) {
		this.dieukienngoaitroi = dieukienngoaitroi;
	}
	public double getDientich() {
		return dientich;
	}
	public void setDientich(double dientich) {
		this.dientich = dientich;
	}
	public int getSoluonvuon() {
		return soluonvuon;
	}
	public void setSoluonvuon(int soluonvuon) {
		this.soluonvuon = soluonvuon;
	}

}
