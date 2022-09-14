package com.ayah.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayah.daos.UserDAO;
import com.ayah.models.Users;

@RestController
@RequestMapping(value = "/agwo", produces = "application/json")
@CrossOrigin
public class UserController {
    private UserDAO ud;

    @Autowired
    public UserController(UserDAO ud) {
		super();
		this.ud = ud;
	}

    @PostMapping(value = "/register")
    public ResponseEntity addUser(@RequestBody Users u){

        Users newUser = ud.save(u);
        System.out.println(newUser);
        System.out.println(newUser);
        
        if(newUser == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.accepted().body("Welcome:" + u);
    }


    

}
