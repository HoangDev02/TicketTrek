package com.tickettrek.module;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;

	@Column(name = "email")
	private String email;
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	@Column(name = "enabled")

	private boolean enabled;
	@Column(name = "join_date")

	@CreationTimestamp
	private Date joinDate;

	@Column(name = "role")
	private String role;

	@OneToMany(mappedBy = "user")
	private Set<RoleDetail> userDetail;
	
	@JsonBackReference
	@OneToMany(mappedBy = "user")
	private List<Booking> booking;
}
