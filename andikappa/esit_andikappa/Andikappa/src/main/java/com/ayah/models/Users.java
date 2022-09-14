package com.ayah.models;

import java.util.List;
import java.util.Objects;

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
   private String surname;

   @Column
   private String email;

   
   @Column 
   private String username;

   @Column
   private int pin;

   @Column
   private String community;

   @Column
   private int cred;

  

   @OneToMany(mappedBy = "user")
   private List<X> x;

    public Users() {
    }

    public Users(int userid, String firstname, String surname, String email, String username, int pin, String community, int cred, List<X> x) {
        this.userid = userid;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.pin = pin;
        this.community = community;
        this.cred = cred;
        this.x = x;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPin() {
        return this.pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getCommunity() {
        return this.community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public int getCred() {
        return this.cred;
    }

    public void setCred(int cred) {
        this.cred = cred;
    }

    public List<X> getX() {
        return this.x;
    }

    public void setX(List<X> x) {
        this.x = x;
    }

    public Users userid(int userid) {
        setUserid(userid);
        return this;
    }

    public Users firstname(String firstname) {
        setFirstname(firstname);
        return this;
    }

    public Users surname(String surname) {
        setSurname(surname);
        return this;
    }

    public Users email(String email) {
        setEmail(email);
        return this;
    }

    public Users username(String username) {
        setUsername(username);
        return this;
    }

    public Users pin(int pin) {
        setPin(pin);
        return this;
    }

    public Users community(String community) {
        setCommunity(community);
        return this;
    }

    public Users cred(int cred) {
        setCred(cred);
        return this;
    }

    public Users x(List<X> x) {
        setX(x);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Users)) {
            return false;
        }
        Users users = (Users) o;
        return userid == users.userid && Objects.equals(firstname, users.firstname) && Objects.equals(surname, users.surname) && Objects.equals(email, users.email) && Objects.equals(username, users.username) && pin == users.pin && Objects.equals(community, users.community) && cred == users.cred && Objects.equals(x, users.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, firstname, surname, email, username, pin, community, cred, x);
    }

    @Override
    public String toString() {
        return "{" +
            " userid='" + getUserid() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", surname='" + getSurname() + "'" +
            ", email='" + getEmail() + "'" +
            ", username='" + getUsername() + "'" +
            ", pin='" + getPin() + "'" +
            ", community='" + getCommunity() + "'" +
            ", cred='" + getCred() + "'" +
            ", x='" + getX() + "'" +
            "}";
    }


}
