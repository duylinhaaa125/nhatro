package com.tranduylinh.NhaTro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tranduylinh.NhaTro.api.HeThongNhaTroAPI;
import com.tranduylinh.NhaTro.models.HeThongNhaTro;
import com.tranduylinh.NhaTro.service.HeThongNhaTroService;

@Service
public class HeThongNhaTroServiceImpl implements HeThongNhaTroService {

	@Autowired
	private HeThongNhaTroAPI heThongNhaTroAPI;
	
	@Override
	public List<HeThongNhaTro> getNhaTro() {
		return heThongNhaTroAPI.getAllNhaTro();
	}

	@Override
	public Optional<HeThongNhaTro> getNhaTroByID(Long id) {
		return heThongNhaTroAPI.findNhaTroById(id);
	}

	@Override
	public ResponseEntity<HeThongNhaTro> insertNhaTroMoi(HeThongNhaTro nhaMoi) {
		return heThongNhaTroAPI.insertNhaTro(nhaMoi);
	}

	@Override
	public HeThongNhaTro updateNhaTroMoi(HeThongNhaTro nhaMoi, Long id) {
		return heThongNhaTroAPI.updateNhaTro(nhaMoi, id);
	}

	@Override
	public HeThongNhaTro deleteNhaTro(Long id) {
		return heThongNhaTroAPI.deleteNhaTro(id);
	}

}
