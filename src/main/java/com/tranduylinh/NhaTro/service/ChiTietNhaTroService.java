package com.tranduylinh.NhaTro.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tranduylinh.NhaTro.models.ChiTietPhongTro;

@Service
public interface ChiTietNhaTroService {
	public List<ChiTietPhongTro> getPhongTro();
	public ResponseEntity<ChiTietPhongTro> getPhongTroByID(Long id);
	public ResponseEntity<ChiTietPhongTro> insertPhongMoi(ChiTietPhongTro phongMoi);
	public ChiTietPhongTro updatePhongMoi(ChiTietPhongTro phongMoi, Long id);
	public ChiTietPhongTro deletePhongMoi(Long id);
}
