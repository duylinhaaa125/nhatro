package com.tranduylinh.NhaTro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranduylinh.NhaTro.models.KhachThue;
import com.tranduylinh.NhaTro.models.ResponseObject;
import com.tranduylinh.NhaTro.repository.KhachThueRepository;

@RestController
@RequestMapping(path = "/api/v1/KhachThue")
public class KhachThueController {

	@Autowired
	private KhachThueRepository khachThueRepository;

	@GetMapping("")
	List<KhachThue> getAllKhachThue(){
		return khachThueRepository.findAll();
	}
	
	@GetMapping("/{id}")
	ResponseEntity<ResponseObject> findById(@PathVariable Long id){
		Optional<KhachThue> foundKhachThue = khachThueRepository.findById(id);
		
		return foundKhachThue.isPresent() ?
				ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("OK", "Query product succesfully", foundKhachThue)
					// you can replace "OK" with your defiend "error code"
				):
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new ResponseObject("false", "cannot find product with id = " + id, " ")
				);
	}
	
//	@GetMapping("/{ten}")
//	ResponseEntity<ResponseObject> findByTen(@PathVariable String ten){
//		List<KhachThue> foundKhachThue = repository.findByTen(ten);
//		
//		return foundKhachThue.isEmpty() ?
//				ResponseEntity.status(HttpStatus.OK).body(
//						new ResponseObject("OK", "Query khach moi succesfully", foundKhachThue)
//						// you can replace "OK" with your defiend "error code"
//					):
//					ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//							new ResponseObject("false", "cannot find product with ten = " + ten, " ")
//					);
//	}	
//	
	@PostMapping("/insert")
	ResponseEntity<ResponseObject> insertKhachThue(@RequestBody KhachThue khachMoi){
		
		return	ResponseEntity.status(HttpStatus.CREATED).body(
					new ResponseObject("OK", "Insert Khach Moi successfully", khachThueRepository.save(khachMoi))
					);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<ResponseObject> updateKhachThue(@RequestBody KhachThue khachMoi, @PathVariable Long id){
		KhachThue updateKhachThue = khachThueRepository.findById(id)
											.map(khachthue -> {
												khachthue.setTen(khachMoi.getTen());
												khachthue.setTuoi(khachMoi.getTuoi());
												khachthue.setGioiTinh(khachMoi.getGioiTinh());
												khachthue.setSoCCCD(khachMoi.getSoCCCD());
												khachthue.setMatTruocCCCD(khachMoi.getMatTruocCCCD());
												khachthue.setMatSauCCCD(khachMoi.getMatSauCCCD());
												return khachThueRepository.save(khachthue);
											}).orElseGet(() -> {
												khachMoi.setId(id);
												return khachThueRepository.save(khachMoi);

											});
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("OK", "Update khach thue thanh cong",updateKhachThue)
				);
	}
	
	// delete a Product => DELETE method
	@DeleteMapping("/{id}")
	ResponseEntity<ResponseObject> deleteKhachThue(@PathVariable Long id){
		boolean exists = khachThueRepository.existsById(id); 
		if (exists) {
			khachThueRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("OK", "Delete khach thue successfully", "")
					);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new ResponseObject("false", "cannot find khach thue to delete " , " ")
					);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
