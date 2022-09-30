package com.ayah.daos;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ayah.models.X;



@Repository
@EnableJpaRepositories
public interface XDAO extends JpaRepository <X, Integer>{

	// public Optional<List<X>> findByEfikwordOrEnglishwordIgonoreCase(String englishword, String efikword);

	public Optional <List<X>> findByEnglishwordIgnoreCase(String englishword);

	public Optional <List<X>> findByEfikwordIgnoreCase(String efikword);

	//ILIKE here is like contains and is also case insensitive
	@Query(value = "SELECT * FROM andikappa.x WHERE context ILIKE %?1%", nativeQuery = true)
	public Optional <List<X>> findByAyeneContextKeEsit(String context);

	@Query(value = "SELECT * FROM andikappa.x WHERE efikword ILIKE %?1%", nativeQuery = true)
	public Optional <List<X>> findByAyeneIkohEfikKeEsit(String efikword);

	
	@Query(value = "SELECT * FROM andikappa.x WHERE englishword ILIKE %?1%", nativeQuery = true)
	public Optional <List<X>> findByAyeneIkohMbakaraKeEsit(String englishword);

	// Note Spring JPA does nopt allow you to reuse a parameter within the same class
	//Note, its a little bit dumb



	
}
