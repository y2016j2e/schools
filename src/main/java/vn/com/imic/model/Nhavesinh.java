package vn.com.imic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nhavesinh")
public class Nhavesinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNvs;

	@Column(name = "gvnamdatchuan")
	private int gvnamdatchuan;
	@Column(name = "gvnudatchuan")
	private int gvnudatchuan;
	@Column(name = "hsnamdatchuan")
	private int hsnamdatchuan;
	@Column(name = "hsnudatchuan")
	private int hsnudatchuan;
	@Column(name = "gvnamchuadatchuan")
	private int gvnamchuadatchuan;
	@Column(name = "gvnuchuadatchuan")
	private int gvnuchuadatchuan;
	@Column(name = "hsnamchuadatchuan")
	private int hsnamchuadatchuan;
	@Column(name = "hsnuchuadatchuan")
	private int hsnuchuadatchuan;

	@Column(name = "dtgvnamchuan")
	private double Sgvnamchuan;
	@Column(name = "dtgvnnuchuan")
	private double Sgvnnuchuan;
	@Column(name = "dtgvnamchuachuan")
	private double Sgvnamchuachuan;
	@Column(name = "dtgvnuchuachuan")
	private double Sgvnuchuachuan;
	@Column(name = "dthsnamchuan")
	private double Shsnamchuan;
	@Column(name = "dthsnuchuan")
	private double Shsnuchuan;
	public int getGvnamdatchuan() {
		return gvnamdatchuan;
	}

	public void setGvnamdatchuan(int gvnamdatchuan) {
		this.gvnamdatchuan = gvnamdatchuan;
	}

	public int getGvnudatchuan() {
		return gvnudatchuan;
	}

	public void setGvnudatchuan(int gvnudatchuan) {
		this.gvnudatchuan = gvnudatchuan;
	}

	public int getHsnamdatchuan() {
		return hsnamdatchuan;
	}

	public void setHsnamdatchuan(int hsnamdatchuan) {
		this.hsnamdatchuan = hsnamdatchuan;
	}

	public int getHsnudatchuan() {
		return hsnudatchuan;
	}

	public void setHsnudatchuan(int hsnudatchuan) {
		this.hsnudatchuan = hsnudatchuan;
	}

	public int getGvnamchuadatchuan() {
		return gvnamchuadatchuan;
	}

	public void setGvnamchuadatchuan(int gvnamchuadatchuan) {
		this.gvnamchuadatchuan = gvnamchuadatchuan;
	}

	public int getGvnuchuadatchuan() {
		return gvnuchuadatchuan;
	}

	public void setGvnuchuadatchuan(int gvnuchuadatchuan) {
		this.gvnuchuadatchuan = gvnuchuadatchuan;
	}

	public int getHsnamchuadatchuan() {
		return hsnamchuadatchuan;
	}

	public void setHsnamchuadatchuan(int hsnamchuadatchuan) {
		this.hsnamchuadatchuan = hsnamchuadatchuan;
	}

	public int getHsnuchuadatchuan() {
		return hsnuchuadatchuan;
	}

	public void setHsnuchuadatchuan(int hsnuchuadatchuan) {
		this.hsnuchuadatchuan = hsnuchuadatchuan;
	}

	public double getSgvnamchuan() {
		return Sgvnamchuan;
	}

	public void setSgvnamchuan(double sgvnamchuan) {
		Sgvnamchuan = sgvnamchuan;
	}

	public double getSgvnnuchuan() {
		return Sgvnnuchuan;
	}

	public void setSgvnnuchuan(double sgvnnuchuan) {
		Sgvnnuchuan = sgvnnuchuan;
	}

	public double getSgvnamchuachuan() {
		return Sgvnamchuachuan;
	}

	public void setSgvnamchuachuan(double sgvnamchuachuan) {
		Sgvnamchuachuan = sgvnamchuachuan;
	}

	public double getSgvnuchuachuan() {
		return Sgvnuchuachuan;
	}

	public void setSgvnuchuachuan(double sgvnuchuachuan) {
		Sgvnuchuachuan = sgvnuchuachuan;
	}

	public double getShsnamchuan() {
		return Shsnamchuan;
	}

	public void setShsnamchuan(double shsnamchuan) {
		Shsnamchuan = shsnamchuan;
	}

	public double getShsnuchuan() {
		return Shsnuchuan;
	}

	public void setShsnuchuan(double shsnuchuan) {
		Shsnuchuan = shsnuchuan;
	}

	public double getShsnamchuachuan() {
		return Shsnamchuachuan;
	}

	public void setShsnamchuachuan(double shsnamchuachuan) {
		Shsnamchuachuan = shsnamchuachuan;
	}

	public double getShsnuchuachuan() {
		return Shsnuchuachuan;
	}

	public void setShsnuchuachuan(double shsnuchuachuan) {
		Shsnuchuachuan = shsnuchuachuan;
	}

	@Column(name = "dthsnamchuachuan")
	private double Shsnamchuachuan;
	@Column(name = "dthsnuchuachuan")
	private double Shsnuchuachuan;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cosovatchat")
	private Cosovatchat cosovatchat;

	public int getMaNvs() {
		return maNvs;
	}

	public void setMaNvs(int maNvs) {
		this.maNvs = maNvs;
	}

	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}

}
