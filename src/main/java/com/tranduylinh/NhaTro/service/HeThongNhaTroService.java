package com.tranduylinh.NhaTro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tranduylinh.NhaTro.models.HeThongNhaTro;

@Service
public interface HeThongNhaTroService {
	public List<HeThongNhaTro> getNhaTro();

	public Optional<HeThongNhaTro> getNhaTroByID(Long id);
	public ResponseEntity<HeThongNhaTro>  insertNhaTroMoi(HeThongNhaTro nhaMoi);
	public HeThongNhaTro updateNhaTroMoi(HeThongNhaTro nhaMoi,Long id);
	public HeThongNhaTro deleteNhaTro(Long id);


}
