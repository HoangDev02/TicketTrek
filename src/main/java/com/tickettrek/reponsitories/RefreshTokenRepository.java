package com.tickettrek.reponsitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickettrek.module.RefreshToken;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
	Optional<RefreshToken> findByToken(String token);

	Optional<RefreshToken> findByUserId(Integer userId);

}