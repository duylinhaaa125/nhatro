package com.tranduylinh.NhaTro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranduylinh.NhaTro.models.ChiTietPhongTro;
import com.tranduylinh.NhaTro.models.ResponseObject;
import com.tranduylinh.NhaTro.repository.ChiTietPhongTroRepository;

@RestController
@RequestMapping(path = "/api/v1/ChiTietPhongTro")
public class ChiTietPhongTroController {
	
	@Autowired
	private ChiTietPhongTroRepository chiTietPhongTroRepository;
	
	@GetMapping("")
	List<ChiTietPhongTro> getAllPhongTro(){
		return chiTietPhongTroRepository.findAll();
	}
	
	@GetMapping("/{id}")
	ResponseEntity<ResponseObject> findPhongTroById(@PathVariable Long id){
		Optional<ChiTietPhongTro> foundPhongTro = chiTietPhongTroRepository.findById(id);
		
		return foundPhongTro.isPresent() ?
				ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("OK", "Query Phong Tro succesfully", foundPhongTro)
					// you can replace "OK" with your defiend "error code"
				):
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new ResponseObject("false", "cannot find Phong tro with id = " + id, " ")
				);
	}
	
	@PostMapping("/insert")
	ResponseEntity<ResponseObject> insertPhongTro(@RequestBody ChiTietPhongTro phongMoi){
		
		return	ResponseEntity.status(HttpStatus.CREATED).body(
					new ResponseObject("OK", "Insert Phong Moi successfully", chiTietPhongTroRepository.save(phongMoi))
					);
	}
	
	@PutMapping("/update/{id}")
	ResponseEntity<ResponseObject> updatePhongTro(@RequestBody ChiTietPhongTro phongMoi, @PathVariable Long id){
		ChiTietPhongTro updatePhongTro = chiTietPhongTroRepository.findById(id)
											.map(phongTro -> {
												phongTro.setGia(phongMoi.getGia());
												phongTro.setHinhAnh(phongMoi.getHinhAnh());
												phongTro.setDien(phongMoi.getDien());
												phongTro.setNuoc(phongMoi.getNuoc());
												phongTro.setDienTich(phongMoi.getDienTich());
												phongTro.setStatus(phongMoi.isStatus());
												return chiTietPhongTroRepository.save(phongTro);
											}).orElseGet(() -> {
												phongMoi.setId(id);
												return chiTietPhongTroRepository.save(phongMoi);

											});
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("OK", "Update Phong Tro thanh cong",updatePhongTro)
				);
	}
	
	// delete a Product => DELETE method
	@DeleteMapping("/delete/{id}")
	ResponseEntity<ResponseObject> deletePhongTro(@PathVariable Long id){
		boolean exists = chiTietPhongTroRepository.existsById(id); 
		if (exists) {
			chiTietPhongTroRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("OK", "Delete phong tro successfully", "")
					);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new ResponseObject("false", "cannot find phong tro to delete " , " ")
					);
		
	}

	
}
