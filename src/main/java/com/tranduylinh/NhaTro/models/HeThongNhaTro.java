package com.tranduylinh.NhaTro.models;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class HeThongNhaTro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tenHeThong;
	private String diaChi;
	private Long soPhong;
	

	public HeThongNhaTro() {
		super();
	}

//	public HeThongNhaTro(String tenHeThong, String diaChi, Long soPhong,
//			Set<ChiTietPhongTro> chiTietPhongTro) {
//		super();
//		this.tenHeThong = tenHeThong;
//		this.diaChi = diaChi;
//		this.soPhong = soPhong;
//		this.chiTietPhongTro = chiTietPhongTro;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenHeThong() {
		return tenHeThong;
	}

	public void setTenHeThong(String tenHeThong) {
		this.tenHeThong = tenHeThong;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Long getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(Long soPhong) {
		this.soPhong = soPhong;
	}

	

}
