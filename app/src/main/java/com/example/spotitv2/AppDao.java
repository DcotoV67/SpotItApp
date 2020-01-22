package com.example.spotitv2;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public abstract class AppDao {


    @Query("SELECT * FROM User WHERE email = :email")
    abstract User comprobarEmailDisponible(String email);

    @Insert
    abstract void insertarUsuario(User user);


}
