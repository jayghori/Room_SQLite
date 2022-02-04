package com.example.room_sqlite.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.room_sqlite.Model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM userD ")
    List<User> getAllUser();

    @Query("DELETE FROM userD WHERE id=:id")
    void deleteUserById(int id);

    @Insert
    void insertData(User user);

}
