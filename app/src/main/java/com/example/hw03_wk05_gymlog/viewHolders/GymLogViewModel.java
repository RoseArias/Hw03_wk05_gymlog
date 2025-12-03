package com.example.hw03_wk05_gymlog.viewHolders;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.hw03_wk05_gymlog.database.GymLogRepository;
import com.example.hw03_wk05_gymlog.database.entities.GymLog;
import java.util.List;

/**
* Name: Rose Arias-Aceves
* Date: 12/2/25
* Explanation: What is this class?
*/
public class GymLogViewModel extends AndroidViewModel {

  private GymLogRepository repository;


  public GymLogViewModel(Application application){
    super(application);
    repository = GymLogRepository.getRepository(application);
  }

  public  LiveData<List<GymLog>> getAllLogsById(int userId){
    return repository.getAllLogsByUserIdLiveData(userId);
  }

  public void insert(GymLog log){
    repository.insertGymLog(log);
  }



}
