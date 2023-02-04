package com.ayah.controllers;

import java.util.List;
import java.util.Optional;

import com.ayah.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ayah.daos.AuthorDAO;

@RestController
@RequestMapping(value = "/author", produces = "application/json")
@CrossOrigin
public class AuthorController {
    private AuthorDAO authorDAO;

    @Autowired
    public AuthorController(AuthorDAO authorDAO) {
		super();
		this.authorDAO = authorDAO;
	}

    //Register Method
    @PostMapping(value = "/register")
    public ResponseEntity addUser(@RequestBody Author author){

        if(!authorDAO.findByusername(author.getUsername()).get().isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username is already Taken, try another one");
        }
        Author newAuthor = authorDAO.save(author);

        System.out.println(newAuthor);
        if(newAuthor.toString().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        System.out.println(authorDAO.findByusername(newAuthor.getUsername()).get());



        return ResponseEntity.accepted().body(author);
    }

// Login Method
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody Author author){

  Optional<List<Author>> possibleUser = authorDAO.findByUsernameAndPassword(author.getUsername(), author.getPassword());


        System.out.println(possibleUser);
        if(!possibleUser.get().isEmpty()){
    List<Author>  gooduser = possibleUser.get();

        return ResponseEntity.accepted().body(possibleUser);
                //("Welcome " + u.getFirstname() + u.getDOB()  + " you have: " +  u.getCred() + " cred");
        }
            return ResponseEntity.status(403).body("Incorrect Username || Password");

    }

    @GetMapping(value = "/fetch")
    public List<Author> findallbycred(){

        return authorDAO.findAllByOrderByCredDesc();
    }

    @GetMapping(value = "/fetch/{id}")
    public Optional<Author> getauthorbyid(@PathVariable Integer id){
        return authorDAO.findById(id);
    }

    @GetMapping(value = "/fetch/byid")
    List<Author>getauthor(){

        return authorDAO.findAll();
    }
    
    

}
