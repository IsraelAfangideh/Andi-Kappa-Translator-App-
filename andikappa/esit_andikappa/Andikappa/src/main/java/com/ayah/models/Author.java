package com.ayah.models;

import com.ayah.enums.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int userid;
   @Column(nullable = false)
   private String firstname;
   @Column(nullable = false)
   private String surname;

   @NotNull
   @Column(nullable = false)
   private String email;

   private String phonenumber;

   @NotNull
   @Column(nullable = false)
   @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
   private LocalDate DOB;

   @Enumerated(EnumType.STRING)

   private Sex sex;

    @NotNull
    @Column(nullable = false)
    private String password;

   @NotNull
   @Column(nullable = false)
   private String username;

   @Column(nullable = false)
   private double cred;
   @ElementCollection
   @Column(nullable = false)
   private List<Integer> entryids = new ArrayList<>();

//   @OneToMany(targetEntity = Entry.class, mappedBy = "termid",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//   private List<Entry> entryList = new ArrayList<>();



}
