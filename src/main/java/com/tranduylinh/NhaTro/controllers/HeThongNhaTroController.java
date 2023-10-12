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

import com.tranduylinh.NhaTro.models.HeThongNhaTro;
import com.tranduylinh.NhaTro.models.ResponseObject;
import com.tranduylinh.NhaTro.repository.HeThongNhaTroRepository;

@RestController
@RequestMapping(path = "/api/v1/HeThongNhaTro")
public class HeThongNhaTroController {
	
	@Autowired
	private HeThongNhaTroRepository heThongNhaTroRepository;
	
	@GetMapping("")
	 ResponseEntity<List<HeThongNhaTro>> getAllNhaTro(){
		
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				heThongNhaTroRepository.findAll()
		);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<ResponseObject> findNhaTroById(@PathVariable Long id){
		Optional<HeThongNhaTro> foundNhaTro = heThongNhaTroRepository.findById(id);
		
		return foundNhaTro.isPresent() ?
				ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("OK", "Query Nha Tro succesfully", foundNhaTro)
					// you can replace "OK" with your defiend "error code"
				):
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new ResponseObject("false", "cannot find Nha Tro with id = " + id, " ")
				);
	}
	
	@PostMapping("/insert")
	ResponseEntity<ResponseObject> insertNhaTro(@RequestBody HeThongNhaTro nhaTroMoi){
		return	ResponseEntity.status(HttpStatus.CREATED).body(
					new ResponseObject("OK", "Insert Nha Tro successfully", heThongNhaTroRepository.save(nhaTroMoi))
					);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<ResponseObject> updateNhaTro(@RequestBody HeThongNhaTro nhaTroMoi, @PathVariable Long id){
		HeThongNhaTro updateNhaTro = heThongNhaTroRepository.findById(id)
											.map(nhaTro -> {
												nhaTro.setTenHeThong(nhaTroMoi.getTenHeThong());
												nhaTro.setSoPhong(nhaTroMoi.getSoPhong());
												nhaTro.setDiaChi(nhaTroMoi.getDiaChi());
												return heThongNhaTroRepository.save(nhaTro);
											}).orElseGet(() -> {
												nhaTroMoi.setId(id);
												return heThongNhaTroRepository.save(nhaTroMoi);

											});
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("OK", "Update Nha Tro thanh cong",updateNhaTro)
				);
	}
	
	
	
	@DeleteMapping("/{id}")
	ResponseEntity<ResponseObject> deleteNhaTro(@PathVariable Long id){
		boolean exists = heThongNhaTroRepository.existsById(id); 
		if (exists) {
			heThongNhaTroRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("OK", "Delete Nha Tro successfully", "")
					);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new ResponseObject("false", "cannot find Nha Tro to delete " , " ")
					);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
