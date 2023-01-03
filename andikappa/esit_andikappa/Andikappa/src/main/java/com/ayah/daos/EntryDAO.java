package com.ayah.daos;

import java.util.List;

import java.util.Optional;

import com.ayah.models.Entry;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface EntryDAO extends JpaRepository <Entry, Integer>{

	@Override
	List<Entry> findAll();


	@Override
	<S extends Entry> boolean exists(Example<S> example);

	@Override
	Optional<Entry> findById(Integer integer);

	public Optional <List<Entry>> findByEnglishwordIgnoreCase(String englishword);

	public Optional <List<Entry>> findByEfikwordIgnoreCase(String efikword);


	Optional<List<Entry>> findByAuthorid(Integer integer);

	//ILIKE here is like contains and is also case insensitive
	@Query(value = "SELECT * FROM entry WHERE context ILIKE %?1%", nativeQuery = true)
	public Optional <List<Entry>> findByAyeneContextKeEsit(String context);

	@Query(value = "SELECT * FROM entry WHERE efikword ILIKE %?1%", nativeQuery = true)
	public Optional <List<Entry>> findByAyeneIkohEfikKeEsit(String efikword);

	
	@Query(value = "SELECT * FROM entry WHERE englishword ILIKE %?1%", nativeQuery = true)
	public Optional <List<Entry>> findByAyeneIkohMbakaraKeEsit(String englishword);



	// Note Spring JPA does not allow you to reuse a parameter within the same class
	//Note, its a little bit dumb



	
}
