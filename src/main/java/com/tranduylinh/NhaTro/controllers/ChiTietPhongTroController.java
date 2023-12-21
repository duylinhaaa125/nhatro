package com.tranduylinh.NhaTro.controllers;

import java.util.List;

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

import com.tranduylinh.NhaTro.models.ChiTietPhongTro;
import com.tranduylinh.NhaTro.service.ChiTietNhaTroService;

@RestController
@RequestMapping(path = "/api/v1/ChiTietPhongTro")
public class ChiTietPhongTroController {
	
	@Autowired
	private ChiTietNhaTroService chiTietNhaTroService;
	
	@GetMapping("")
	List<ChiTietPhongTro> getAllPhongTro(){
		return chiTietNhaTroService.getPhongTro();
	}
	
	@GetMapping("/{id}")
	ResponseEntity<ChiTietPhongTro> findPhongTroById(@PathVariable Long id){
		return chiTietNhaTroService.getPhongTroByID(id);
	}
	
	@PostMapping("/insert")
	ResponseEntity<ChiTietPhongTro> insertPhongTro(@RequestBody ChiTietPhongTro phongMoi){
		return chiTietNhaTroService.insertPhongMoi(phongMoi);
	}
	
	@PutMapping("/update/{id}")
	ChiTietPhongTro updatePhongTro(@RequestBody ChiTietPhongTro phongMoi, @PathVariable Long id){
		return chiTietNhaTroService.updatePhongMoi(phongMoi, id);
	}
	
	@DeleteMapping("/delete/{id}")
	ChiTietPhongTro deletePhongTro(@PathVariable Long id){
		return chiTietNhaTroService.deletePhongMoi(id);
		
	}

	
}
