package com.example.hw03_wk05_gymlog.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.hw03_wk05_gymlog.database.entities.GymLog;
import com.example.hw03_wk05_gymlog.database.entities.User;
import java.util.List;

/**
* Name: Rose Arias-Aceves
* Date: 12/1/25
* Explanation: What is this class?
*/

@Dao
public interface UserDAO {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(User... user);

  @Delete
  void delete(User user);

  @Query("SELECT * FROM " + GymLogDatabase.USER_TABLE + " order by username DESC")
  List<User> getAllRecords();

  @Query("DELETE from " + GymLogDatabase.USER_TABLE)
  void deleteAll();
}
