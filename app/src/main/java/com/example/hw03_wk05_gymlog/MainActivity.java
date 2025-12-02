package com.example.hw03_wk05_gymlog;

import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hw03_wk05_gymlog.database.GymLogRepository;
import com.example.hw03_wk05_gymlog.database.entities.GymLog;
import com.example.hw03_wk05_gymlog.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

  public static final String TAG = "DAC_GYMLOG";
  String mExercise = "";
  double mWeight = 0.0;
  int mReps = 0;

  //TODO: Add login information.
  int loggedInUserId = -1;


  private ActivityMainBinding binding;
  private GymLogRepository repository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    repository = GymLogRepository.getRepository(getApplication());

    binding.logDisplayTextView.setMovementMethod(new ScrollingMovementMethod());

    updateDisplay();
    binding.logButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        getInformationFromDisplay();
        insertGymlogRecord();
        updateDisplay();
      }
    });
  }

  private void insertGymlogRecord(){
    if(mExercise.isEmpty()){
      return;
    }
    GymLog log = new GymLog(mExercise,mWeight,mReps,loggedInUserId);
    repository.insertGymLog(log);

  }


  private void updateDisplay() {
    ArrayList<GymLog> allLogs = repository.getAllLogs();
    if(allLogs.isEmpty()){
      binding.logDisplayTextView.setText(R.string.nothing_to_show_time_to_hit_the_gym);
    }

    StringBuilder sb = new StringBuilder();
    for(GymLog log : allLogs){
      sb.append(log);
    }

    binding.logDisplayTextView.setText(sb.toString());

  }

  private void getInformationFromDisplay() {
    mExercise = binding.exerciseInputTextEditText.getText().toString();

    //the following has to go into a try catch because it will try to parse an empty
    //string otherwise, causing the application to fail

    try {
      mWeight = Double.parseDouble(binding.weightInputEditText.getText().toString());
    } catch (NumberFormatException e) {
      Log.d(TAG, "Error reading value from Weight edit text.");
    }
    try {
      mReps = Integer.parseInt(binding.repInputEditText.getText().toString());
    } catch (NumberFormatException e) {
      Log.d(TAG, "Error reading value from reps edit text.");
    }
  }
}