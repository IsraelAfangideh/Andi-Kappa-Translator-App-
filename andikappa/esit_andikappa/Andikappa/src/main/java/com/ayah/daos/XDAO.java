package com.ayah.daos;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;



@Repository
@EnableJpaRepositories
public interface XDAO extends JpaRepository <X, Integer>{

	public Optional<List<X>> findByEfikwordOrEnglishword(String englishword, String efikword);

	public Optional <List<X>> findByEnglishword(String englishword);

	public Optional <List<X>> findByEfikword(String efikword);
////	
////	public Optional<List<X>>findbyenglishword(String englishword);

	// public Optional<List<X>>findById();
}
