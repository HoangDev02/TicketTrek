package com.tickettrek.dtos;



import java.sql.Date;

import lombok.Data;

@Data
public class UserDTO {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Date joinDate;
	private boolean enabled;
	private String role;
	private boolean isOwner;
	private boolean isVip;
}