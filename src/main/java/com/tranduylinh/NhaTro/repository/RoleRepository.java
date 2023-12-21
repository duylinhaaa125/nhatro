package com.tranduylinh.NhaTro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranduylinh.NhaTro.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
