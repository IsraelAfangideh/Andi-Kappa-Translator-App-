package com.ayah.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
@Table(name = "users")
@JsonFormat(shape = JsonFormat.Shape.STRING)
public class Users {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int userid;

   @Column
   private String firstname;

   @Column 
   private String familyname;

   @Column
   private String email;

   @Column
   private String community;

   @Column
   private int mannapoints;

   @OneToMany(mappedBy = "user")
   private List<X> x;
}
