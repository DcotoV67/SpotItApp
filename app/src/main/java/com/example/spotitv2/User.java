package com.example.spotitv2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;


    public String nombre;
    public String email;
    public String password;


    public User(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
}
