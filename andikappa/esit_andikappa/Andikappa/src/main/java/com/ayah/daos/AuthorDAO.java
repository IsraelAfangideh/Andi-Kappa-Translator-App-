package com.ayah.daos;

import java.util.List;
import java.util.Optional;

import com.ayah.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;




@Repository
@EnableJpaRepositories
public interface AuthorDAO extends JpaRepository <Author, Integer> {
    
   public Optional<List<Author>> findByUsernameAndPassword(String username, String password);

   Optional<List<Author>> findByusername(String Username);



   @Override
   Optional<Author> findById(Integer integer);

   @Override
   List<Author> findAll();


}
