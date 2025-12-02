package com.example.hw03_wk05_gymlog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.example.hw03_wk05_gymlog.databinding.ActivityLoginBinding;
import com.example.hw03_wk05_gymlog.databinding.ActivityMainBinding;


public class LoginActivity extends AppCompatActivity {

  private ActivityLoginBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityLoginBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    binding.loginButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = MainActivity.mainActivityIntentFactory(getApplicationContext(),0);
        startActivity(intent);
      }
    });
  }
  static Intent logIntentFactory(Context context){
    return new Intent(context,LoginActivity.class);
  }
}