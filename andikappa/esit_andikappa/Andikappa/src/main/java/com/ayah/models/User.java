package com.ayah.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.ayah.enums.Sex;
import com.sun.istack.NotNull;
import jdk.vm.ci.meta.Local;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
@Table(name = "author")
@JsonFormat(shape = JsonFormat.Shape.STRING)
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int userid;

   @Column
   private String firstname;

   @Column 
   private String surname;

   @Column
   @NotNull
   private String email;

   @Column
   private String phonenumber;

   @Column
   @NotNull
   @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
   private LocalDate DOB;

   @Column
   @Enumerated(EnumType.STRING)
   private Sex sex;

    @Column
    @NotNull
    private String password;

   @Column
   @NotNull
   private String username;

   @Column
   private double cred;

   @Column
   @OneToMany
   private List<Term> termList;


    public User() {
    }

    public User(int userid, String firstname, String surname, String email, String phonenumber, LocalDate DOB, Sex sex, String password, String username, double cred, List<Term> termList) {
        this.userid = userid;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.DOB = DOB;
        this.sex = sex;
        this.password = password;
        this.username = username;
        this.cred = cred;
        this.termList = termList;
    }

    public int getUserid() {
        return userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCred(double cred) {
        this.cred = cred;
    }

    public void setTermList(List<Term> termList) {
        this.termList = termList;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public Sex getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public double getCred() {
        return cred;
    }

    public List<Term> getTermList() {
        return termList;
    }

    public User(String firstname, String surname, String email, String phonenumber, LocalDate DOB, Sex sex, String password, String username, double cred, List<Term> termList) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.DOB = DOB;
        this.sex = sex;
        this.password = password;
        this.username = username;
        this.cred = cred;
        this.termList = termList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserid() == user.getUserid() && Double.compare(user.getCred(), getCred()) == 0 && Objects.equals(getFirstname(), user.getFirstname()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPhonenumber(), user.getPhonenumber()) && Objects.equals(getDOB(), user.getDOB()) && getSex() == user.getSex() && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getTermList(), user.getTermList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getFirstname(), getSurname(), getEmail(), getPhonenumber(), getDOB(), getSex(), getPassword(), getUsername(), getCred(), getTermList());
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", DOB=" + DOB +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", cred=" + cred +
                ", termList=" + termList +
                '}';
    }
}
