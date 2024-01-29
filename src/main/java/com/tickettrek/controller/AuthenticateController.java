package com.tickettrek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tickettrek.dtos.AuthRequest;
import com.tickettrek.dtos.JwtResponse;
import com.tickettrek.dtos.RefreshTokenRequest;
import com.tickettrek.dtos.UserBasicInfor;
import com.tickettrek.dtos.UserDTO;
import com.tickettrek.jwt.JwtService;
import com.tickettrek.jwt.RefreshTokenService;
import com.tickettrek.mapper.UserMapper;
import com.tickettrek.module.RefreshToken;
import com.tickettrek.module.User;
import com.tickettrek.services.UserService;



@RestController
@RequestMapping("/auth")
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private RefreshTokenService refreshTokenService;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userService;
	

//	@GetMapping
//	public String login() {
//		return "auth";
//	}
	 @PostMapping("/login")
	    public JwtResponse authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	        if (authentication.isAuthenticated()) {
	            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequest.getUsername());
	            return JwtResponse.builder()
	            		.username(authRequest.getUsername())
	            		.userId(userService.getIdUserByUsername(authRequest.getUsername()))
	                    .accessToken(jwtService.generateToken(authRequest.getUsername()))
	                    .token(refreshToken.getToken()).build();
	        } else {
	            throw new UsernameNotFoundException("invalid user request !");
	        }
	    }
	 @PostMapping("/sign-up")
	 public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
	     try {

	         User user = userMapper.toModel(userDTO);
	         userService.createUser(user);

	 
	         UserBasicInfor createdUser = userMapper.toBasicDTO(user);

	         return ResponseEntity.ok(createdUser);

	     } catch (RuntimeException e) {

	         return ResponseEntity.badRequest().body(e.getMessage());

	     }

	 }
	 
	@PostMapping("/refreshToken")
	public JwtResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
		return refreshTokenService.findByToken(refreshTokenRequest.getToken())
				.map(refreshTokenService::verifyExpiration).map(RefreshToken::getUser).map(userInfo -> {
					String accessToken = jwtService.generateToken(userInfo.getUsername());
					return JwtResponse.builder().accessToken(accessToken).token(refreshTokenRequest.getToken()).build();
				}).orElseThrow(() -> new RuntimeException("Refresh token is not in database!"));
	}

}