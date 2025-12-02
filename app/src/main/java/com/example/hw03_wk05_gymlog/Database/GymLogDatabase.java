package com.example.hw03_wk05_gymlog.Database;

import android.content.Context;
import android.util.Log;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.hw03_wk05_gymlog.Database.entities.GymLog;
import com.example.hw03_wk05_gymlog.MainActivity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.NotNull;

/**
* Name: Rose Arias-Aceves
* Date: 12/1/25
* Explanation: What is this class?
*/

@Database(entities = {GymLog.class}, version = 1, exportSchema = false)
public abstract class GymLogDatabase extends RoomDatabase {

  public static final String DATABASE_NAME = "GymLog_database";
  public static final String GYM_LOG_TABLE = "gymLogTable";

  private static volatile GymLogDatabase INSTANCE;
  private static final int NUMBER_OF_THREADS = 4;

  static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
  static GymLogDatabase getDatabase(final Context context){
    if(INSTANCE == null){
      synchronized (GymLogDatabase.class){
        if(INSTANCE == null){
          INSTANCE = Room.databaseBuilder(
              context.getApplicationContext(),
              GymLogDatabase.class,
                  DATABASE_NAME
              )
              .fallbackToDestructiveMigration()
              .addCallback(addDefaultValues)
              .build();

        }
      }
    }
    return INSTANCE;
  }

  private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback(){
    @Override
    public void onCreate(@NotNull SupportSQLiteDatabase db){
      super.onCreate(db);
      Log.i(MainActivity.TAG,"DATABASE CREATED!");
          //TODO: Add database write executor
    }
  };

  public abstract GymLogDAO gymLogDAO();
}
