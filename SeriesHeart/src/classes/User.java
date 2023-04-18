/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author yasmi
 */
public class User {

    public int id;
    public String username;
    public String password;
    public String email;
    public String fullName;
    public Date birth;
    public String descri;
    public String city;
    public String state;
    public InputStream picture;

    public User(String username, String password, String email, String fullName, Date birth, String descri, String city, String state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.birth = birth;
        this.descri = descri;
        this.city = city;
        this.state = state;
    }

    public User(int id, String username, String password, String email, String fullName, Date birth, String descri, String city, String state, InputStream picture) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.birth = birth;
        this.descri = descri;
        this.city = city;
        this.state = state;
        this.picture = picture;
    }

    public User(int id, String username, String password, String email, String fullName, Date birth, String descri, String city, String state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.birth = birth;
        this.descri = descri;
        this.city = city;
        this.state = state;
    }

    public void printUser() {
        System.out.println("nome: " + username);
        System.out.println("password: " + password);
        System.out.println("email: " + email);
        System.out.println("fullName: " + fullName);
        System.out.println("birth: " + birth.toString());
        System.out.println("descri: " + descri);
        System.out.println("city: " + city);
        System.out.println("state: " + state);
        // System.out.println("picture: "+picture.toString());
    }

}
