package com.tranduylinh.NhaTro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tranduylinh.NhaTro.api.ChiTietPhongTroAPI;
import com.tranduylinh.NhaTro.models.ChiTietPhongTro;
import com.tranduylinh.NhaTro.service.ChiTietNhaTroService;

@Service
public class ChiTietNhaTroServiceImpl implements ChiTietNhaTroService {

	@Autowired
	private ChiTietPhongTroAPI chiTietPhongTroAPI;
	
	@Override
	public List<ChiTietPhongTro> getPhongTro() {
		return chiTietPhongTroAPI.getAllPhongTro();
	}

	@Override
	public ResponseEntity<ChiTietPhongTro> getPhongTroByID(Long id) {
		return chiTietPhongTroAPI.findPhongTroById(id);
	}

	@Override
	public ResponseEntity<ChiTietPhongTro> insertPhongMoi(ChiTietPhongTro phongMoi) {
		return chiTietPhongTroAPI.insertPhongTro(phongMoi);
	}

	@Override
	public ChiTietPhongTro updatePhongMoi(ChiTietPhongTro phongMoi, Long id) {
		return chiTietPhongTroAPI.updatePhongTro(phongMoi, id);
	}

	@Override
	public ChiTietPhongTro deletePhongMoi(Long id) {
		return chiTietPhongTroAPI.deletePhongTro(id);
	}

}
