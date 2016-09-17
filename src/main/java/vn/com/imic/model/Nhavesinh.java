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
@Table(name="nhavesinh")
public class Nhavesinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNvs;

	@Column(name = "nvsdatchuan")
	private boolean nvsdatchuan;
	@Column(name = "soluong", nullable = true)
	private int soluong;

	@Column(name = "ofhsnam")
	private boolean ofhsnam;
	@Column(name = "ofhsnu")
	private boolean ofhsnu;

	@Column(name = "ofgvnam")
	private boolean ofgvnam;
	@Column(name = "ofgvnu")
	private boolean ofgvnu;

	@Column(name = "dientich")
	private double dientich;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cosovatchat")
	private Cosovatchat cosovatchat;

	public int getMaNvs() {
		return maNvs;
	}

	public void setMaNvs(int maNvs) {
		this.maNvs = maNvs;
	}

	public boolean isNvsdatchuan() {
		return nvsdatchuan;
	}

	public void setNvsdatchuan(boolean nvsdatchuan) {
		this.nvsdatchuan = nvsdatchuan;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public boolean isOfhsnam() {
		return ofhsnam;
	}

	public void setOfhsnam(boolean ofhsnam) {
		this.ofhsnam = ofhsnam;
	}

	public boolean isOfhsnu() {
		return ofhsnu;
	}

	public void setOfhsnu(boolean ofhsnu) {
		this.ofhsnu = ofhsnu;
	}

	public boolean isOfgvnam() {
		return ofgvnam;
	}

	public void setOfgvnam(boolean ofgvnam) {
		this.ofgvnam = ofgvnam;
	}

	public boolean isOfgvnu() {
		return ofgvnu;
	}

	public void setOfgvnu(boolean ofgvnu) {
		this.ofgvnu = ofgvnu;
	}

	public double getDientich() {
		return dientich;
	}

	public void setDientich(double dientich) {
		this.dientich = dientich;
	}

	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}

}
