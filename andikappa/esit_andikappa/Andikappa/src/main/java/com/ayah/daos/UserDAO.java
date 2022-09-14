package com.ayah.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ayah.models.Users;

@Repository
@EnableJpaRepositories
public interface UserDAO extends JpaRepository <Users, Integer> {
    
   public Optional<List<Users>> findByUsernameAndPin(String username, int pin);

}
