package com.example.hw03_wk05_gymlog.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.hw03_wk05_gymlog.database.entities.GymLog;
import java.util.List;


/**
* Name: Rose Arias-Aceves
* Date: 12/1/25
* Explanation: What is this class?
*/

@Dao
public interface GymLogDAO {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(GymLog gymlog);

  @Query("SELECT * FROM " + GymLogDatabase.GYM_LOG_TABLE + " order by date DESC")
  List<GymLog> getAllRecords();

  @Query("SELECT * FROM " + GymLogDatabase.GYM_LOG_TABLE + " WHERE userID = :userId order by date DESC")
  LiveData<List<GymLog>> getAllRecords(int userId);

  @Query("SELECT * FROM " + GymLogDatabase.GYM_LOG_TABLE + " WHERE userID = :loggedInUserId order by date DESC")
  List<GymLog> getRecordsbyUserId(int loggedInUserId);

  @Query("SELECT * FROM " + GymLogDatabase.GYM_LOG_TABLE + " WHERE userID = :loggedInUserId order by date DESC")
  LiveData<List<GymLog>> getRecordsbyUserIdLiveData(int loggedInUserId);
}
