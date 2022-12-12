package com.ayah.daos;

import java.util.List;

import java.util.Optional;

import com.ayah.models.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface TermDAO extends JpaRepository <Term, Integer>{

	// public Optional<List<Term>> findByEfikwordOrEnglishwordIgonoreCase(String englishword, String efikword);

	public Optional <List<Term>> findByEnglishwordIgnoreCase(String englishword);

	public Optional <List<Term>> findByEfikwordIgnoreCase(String efikword);

	//ILIKE here is like contains and is also case insensitive
	@Query(value = "SELECT * FROM X WHERE context ILIKE %?1%", nativeQuery = true)
	public Optional <List<Term>> findByAyeneContextKeEsit(String context);

	@Query(value = "SELECT * FROM X WHERE efikword ILIKE %?1%", nativeQuery = true)
	public Optional <List<Term>> findByAyeneIkohEfikKeEsit(String efikword);

	
	@Query(value = "SELECT * FROM X WHERE englishword ILIKE %?1%", nativeQuery = true)
	public Optional <List<Term>> findByAyeneIkohMbakaraKeEsit(String englishword);

	// Note Spring JPA does not allow you to reuse a parameter within the same class
	//Note, its a little bit dumb



	
}
