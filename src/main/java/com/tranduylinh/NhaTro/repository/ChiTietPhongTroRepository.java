package com.tranduylinh.NhaTro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranduylinh.NhaTro.models.ChiTietPhongTro;

@Repository
public interface ChiTietPhongTroRepository extends JpaRepository<ChiTietPhongTro, Long>{
	
	List<ChiTietPhongTro> findChiTietPhongTroByNhaTroId(Long nhaTroId);
	
}
