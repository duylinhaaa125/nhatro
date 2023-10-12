package com.tranduylinh.NhaTro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranduylinh.NhaTro.models.KhachThue;

@Repository
public interface KhachThueRepository extends JpaRepository<KhachThue, Long> {
	
	List<KhachThue> findByTen(String ten);


}
