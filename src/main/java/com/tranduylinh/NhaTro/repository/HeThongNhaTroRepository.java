package com.tranduylinh.NhaTro.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranduylinh.NhaTro.models.HeThongNhaTro;

@Repository
public interface HeThongNhaTroRepository extends JpaRepository<HeThongNhaTro, Long>{
	
	
}
