package com.tranduylinh.NhaTro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.tranduylinh.NhaTro.service.HeThongNhaTroService;

@RestController
@RequestMapping(path = "/api/v1/HeThongNhaTro")
public class HeThongNhaTroController {
	
	@Autowired
	private HeThongNhaTroService heThongNhaTroService;
	
	@GetMapping("")
	 List<HeThongNhaTro> getAllNhaTro(){
		return heThongNhaTroService.getNhaTro();
	}
	
	@GetMapping("/{id}")
	Optional<HeThongNhaTro> findNhaTroById(@PathVariable Long id){
		return heThongNhaTroService.getNhaTroByID(id);
	}
	
	@PostMapping("/insert")
	ResponseEntity<HeThongNhaTro> insertNhaTro(@RequestBody HeThongNhaTro nhaTroMoi){
		return heThongNhaTroService.insertNhaTroMoi(nhaTroMoi);
	}
	
	@PutMapping("/update/{id}")
	HeThongNhaTro updateNhaTro(@RequestBody HeThongNhaTro nhaTroMoi, @PathVariable Long id){
		return heThongNhaTroService.updateNhaTroMoi(nhaTroMoi, id);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	HeThongNhaTro deleteNhaTro(@PathVariable Long id){
		return heThongNhaTroService.deleteNhaTro(id);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
