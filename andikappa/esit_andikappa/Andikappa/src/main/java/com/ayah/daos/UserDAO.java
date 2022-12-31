package com.ayah.daos;

import java.util.List;
import java.util.Optional;

import com.ayah.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;




@Repository
@EnableJpaRepositories
public interface UserDAO extends JpaRepository <User, Integer> {
    
   public Optional<List<User>> findByUsernameAndPassword(String username, String password);

}
