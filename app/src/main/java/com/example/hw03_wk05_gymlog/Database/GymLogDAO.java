package com.example.hw03_wk05_gymlog.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.hw03_wk05_gymlog.Database.entities.GymLog;
import java.util.ArrayList;


/**
* Name: Rose Arias-Aceves
* Date: 12/1/25
* Explanation: What is this class?
*/

@Dao
public interface GymLogDAO {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(GymLog gymlog);

  @Query("Select * from " + GymLogDatabase.GYM_LOG_TABLE)
  ArrayList<GymLog> getAllRecords();


}
