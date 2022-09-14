package com.ayah.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayah.daos.UserDAO;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {
    private UserDAO uDAO;

    @Autowired
    public UserController(UserDAO ud) {
		super();
		this.uDAO = ud;
	}

    
}
