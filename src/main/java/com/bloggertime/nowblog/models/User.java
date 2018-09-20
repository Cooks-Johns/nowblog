package com.bloggertime.nowblog.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue
    private long id;

    @Column   // (nullable = false)   ----- > set to false when html tymelyfe has the input
    private String firstName;

    @Column     // (nullable = false)   ----- > set to false when html tymelyfe has the input
    private String lastName;



    @Column(nullable = false , unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;




    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

//  editing password
//    private transient String confirmPassword;
//    private transient String newPassword;
//    private transient String confirmNewPassword;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(User copy) {
        id = copy.id;
        firstName = copy.firstName;
        lastName = copy.lastName;
        username = copy.username;
        password = copy.password;
        email = copy.email;


    }


    public User(String firstName, String lastName, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // copy constructor for authentication


    public User(){};

}
