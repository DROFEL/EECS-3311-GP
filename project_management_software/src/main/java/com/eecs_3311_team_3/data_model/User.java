package com.eecs_3311_team_3.data_model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USER")
public class User {

    @Id
    @Column(name="userID")
    public int userID;
    @Column(name="userName")
    public String userName;
    @Column(name="fullName")
    public String name;
    @Column(name="email")
    public String email;
    @Column(name="password")
    public String password;
    // a list for what team a person is on

    public User(){

    }
}