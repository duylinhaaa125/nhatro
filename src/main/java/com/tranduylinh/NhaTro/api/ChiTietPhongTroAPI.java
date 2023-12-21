package com.tranduylinh.NhaTro.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tranduylinh.NhaTro.models.ChiTietPhongTro;
import com.tranduylinh.NhaTro.repository.ChiTietPhongTroRepository;

@Component
public class ChiTietPhongTroAPI {

	@Autowired
	private ChiTietPhongTroRepository chiTietPhongTroRepository;

	public List<ChiTietPhongTro> getAllPhongTro() {
		return chiTietPhongTroRepository.findAll();
	}

	public ResponseEntity<ChiTietPhongTro> findPhongTroById(@PathVariable Long id) {
		Optional<ChiTietPhongTro> foundPhongTro = chiTietPhongTroRepository.findById(id);
		return foundPhongTro.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(foundPhongTro.get())
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	public ResponseEntity<ChiTietPhongTro> insertPhongTro(@RequestBody ChiTietPhongTro phongMoi) {

//		return	ResponseEntity.status(HttpStatus.CREATED).body(
//					new ResponseObject("OK", "Insert Phong Moi successfully", chiTietPhongTroRepository.save(phongMoi))
//					);
		return ResponseEntity.status(HttpStatus.CREATED).body(chiTietPhongTroRepository.save(phongMoi));
	}

	public ChiTietPhongTro updatePhongTro(@RequestBody ChiTietPhongTro phongMoi, @PathVariable Long id) {
		Optional<ChiTietPhongTro> findChiTietPhongTro = chiTietPhongTroRepository.findById(id);
		if (findChiTietPhongTro.isPresent()) {
			ChiTietPhongTro phongTro = findChiTietPhongTro.get();
			phongTro.setGia(phongMoi.getGia());
			phongTro.setHinhAnh(phongMoi.getHinhAnh());
			phongTro.setDien(phongMoi.getDien());
			phongTro.setNuoc(phongMoi.getNuoc());
			phongTro.setDienTich(phongMoi.getDienTich());
			phongTro.setStatus(phongMoi.isStatus());
			return chiTietPhongTroRepository.save(phongTro);
		} else {
			phongMoi.setId(id);
			return chiTietPhongTroRepository.save(phongMoi);
		}

	}

	public ChiTietPhongTro deletePhongTro(@PathVariable Long id) {
		Optional<ChiTietPhongTro> findChiTietPhongTro = chiTietPhongTroRepository.findById(id);
		if (findChiTietPhongTro.isPresent()) {
			ChiTietPhongTro phongTro = findChiTietPhongTro.get();
			chiTietPhongTroRepository.delete(phongTro);
			return phongTro;
		}

		return null;

	}

}
