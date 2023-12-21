package com.tranduylinh.NhaTro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranduylinh.NhaTro.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findUserByUserName(String userName);

}
