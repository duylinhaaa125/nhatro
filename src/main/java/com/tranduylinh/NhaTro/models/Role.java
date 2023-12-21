package com.tranduylinh.NhaTro.models;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Roles")
public class Role {

	@Id
	@SequenceGenerator(
			name = "roles_sequence",
			sequenceName = "roles_sequence",
			allocationSize = 1)
    @GeneratedValue(
    		strategy = GenerationType.IDENTITY,
    		generator = "roles_sequence")
    private Long id;

    private String name;
//    @ManyToMany(mappedBy = "roles")
//    @Fetch(value = FetchMode.SELECT)
//    @JsonIgnore
//    private Set<User> users = new HashSet<User>();
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    

}
