package com.ayah.daos;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ayah.models.X;



@Repository
@EnableJpaRepositories
public interface XDAO extends JpaRepository <X, Integer>{

	// public Optional<List<X>> findByEfikwordOrEnglishwordIgonoreCase(String englishword, String efikword);

	public Optional <List<X>> findByEnglishwordIgnoreCase(String englishword);

	public Optional <List<X>> findByEfikwordIgnoreCase(String efikword);
////	
////	public Optional<List<X>>findbyenglishword(String englishword);

	// public Optional<List<X>>findById();
}
