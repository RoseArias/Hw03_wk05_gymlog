package com.example.hw03_wk05_gymlog;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hw03_wk05_gymlog.databinding.ActivityMainBinding;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

  public static final String TAG = "DAC_GYMLOG";
  String mExercise = "";
  double mWeight = 0.0;
  int mReps = 0;


  ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    binding.logButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        updateDisplay();
      }
    });
  }

  private void updateDisplay() {
    String currentInfo = binding.logDisplayTextView.toString();
    String newDisplay = String.format(Locale.ENGLISH,mExercise,mWeight,mReps);
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