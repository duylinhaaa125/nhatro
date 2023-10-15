package com.tranduylinh.NhaTro.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class ChiTietPhongTro  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double gia;
	private String hinhAnh;
	private double dien;
	private double nuoc;
	private double dienTich;
	private boolean status;
	@Column(name = "nhatro_id")
	private Long nhaTroId;
	
	public ChiTietPhongTro() {
		super();
	}

	public ChiTietPhongTro(double gia, String hinhAnh, double dien, double nuoc,
			double dienTich, boolean status, Long nhaTroId) {
		super();
		this.gia = gia;
		this.hinhAnh = hinhAnh;
		this.dien = dien;
		this.nuoc = nuoc;
		this.dienTich = dienTich;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public double getDien() {
		return dien;
	}

	public void setDien(double dien) {
		this.dien = dien;
	}

	public double getNuoc() {
		return nuoc;
	}

	public void setNuoc(double nuoc) {
		this.nuoc = nuoc;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getNhaTroId() {
		return nhaTroId;
	}

	public void setNhaTroId(Long nhaTroId) {
		this.nhaTroId = nhaTroId;
	}

	@Override
	public String toString() {
		return "ChiTietPhongTro [id=" + id + ", nhaTroID=" + nhaTroId + ", gia=" + gia + ", hinhAnh=" + hinhAnh + ", dien="
				+ dien + ", nuoc=" + nuoc + ", dienTich=" + dienTich + ", status=" + status + "]";
	}

}
