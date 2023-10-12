package com.tranduylinh.NhaTro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class KhachThue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ten;
	private int tuoi;
	private String gioiTinh;
	private String soCCCD;
	private String matTruocCCCD;
	private String matSauCCCD;

	public KhachThue() {
		super();
	}

	public KhachThue(String ten, int tuoi, String gioiTinh, String soCCCD, String matTruocCCCD,
			String matSauCCCD) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.soCCCD = soCCCD;
		this.matTruocCCCD = matTruocCCCD;
		this.matSauCCCD = matSauCCCD;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoCCCD() {
		return soCCCD;
	}

	public void setSoCCCD(String soCCCD) {
		this.soCCCD = soCCCD;
	}

	public String getMatTruocCCCD() {
		return matTruocCCCD;
	}

	public void setMatTruocCCCD(String matTruocCCCD) {
		this.matTruocCCCD = matTruocCCCD;
	}

	public String getMatSauCCCD() {
		return matSauCCCD;
	}

	public void setMatSauCCCD(String matSauCCCD) {
		this.matSauCCCD = matSauCCCD;
	}

	@Override
	public String toString() {
		return "KhachThue [id=" + id + ", ten=" + ten + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", soCCCD="
				+ soCCCD + ", matTruocCCCD=" + matTruocCCCD + ", matSauCCCD=" + matSauCCCD + "]";
	}

}
