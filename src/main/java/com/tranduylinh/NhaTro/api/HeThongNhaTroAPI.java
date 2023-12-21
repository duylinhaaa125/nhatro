package com.tranduylinh.NhaTro.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tranduylinh.NhaTro.models.HeThongNhaTro;
import com.tranduylinh.NhaTro.repository.HeThongNhaTroRepository;

public class HeThongNhaTroAPI {
	@Autowired
	private HeThongNhaTroRepository heThongNhaTroRepository;

	public List<HeThongNhaTro> getAllNhaTro() {
		return heThongNhaTroRepository.findAll();
	}

	public Optional<HeThongNhaTro> findNhaTroById(@PathVariable Long id) {
		Optional<HeThongNhaTro> foundNhaTro = heThongNhaTroRepository.findById(id);
		if (foundNhaTro.isPresent()) {
			return foundNhaTro;
		} else {
			return null;
		}

	}

	public ResponseEntity<HeThongNhaTro> insertNhaTro(@RequestBody HeThongNhaTro nhaTroMoi) {
		return ResponseEntity.status(HttpStatus.CREATED).body(heThongNhaTroRepository.save(nhaTroMoi));
	}

	public HeThongNhaTro updateNhaTro(@RequestBody HeThongNhaTro nhaTroMoi, @PathVariable Long id) {
		Optional<HeThongNhaTro> findChiTietPhongTro = heThongNhaTroRepository.findById(id);
		if (findChiTietPhongTro.isPresent()) {
			HeThongNhaTro nhaTro = findChiTietPhongTro.get();
			nhaTro.setTenHeThong(nhaTroMoi.getTenHeThong());
			nhaTro.setSoPhong(nhaTroMoi.getSoPhong());
			nhaTro.setDiaChi(nhaTroMoi.getDiaChi());
			return heThongNhaTroRepository.save(nhaTro);
		} else {
			nhaTroMoi.setId(id);
			return heThongNhaTroRepository.save(nhaTroMoi);
		}
	}

	public HeThongNhaTro deleteNhaTro(@PathVariable Long id) {
		Optional<HeThongNhaTro> findHeThongNhaTro = heThongNhaTroRepository.findById(id);
		if (findHeThongNhaTro.isPresent()) {
			HeThongNhaTro nhaTro = findHeThongNhaTro.get();
			heThongNhaTroRepository.delete(nhaTro);
			return nhaTro;
		}
		return null;

	}
}
