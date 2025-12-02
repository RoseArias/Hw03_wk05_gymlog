package com.example.hw03_wk05_gymlog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import com.example.hw03_wk05_gymlog.database.GymLogRepository;
import com.example.hw03_wk05_gymlog.database.entities.User;
import com.example.hw03_wk05_gymlog.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

  private ActivityLoginBinding binding;

  private GymLogRepository repository;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityLoginBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    repository = GymLogRepository.getRepository(getApplication());

    binding.loginButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        verifyUser();
      }
    });
  }

  private void verifyUser() {

    String username = binding.userNameLoginEditText.getText().toString();

    if (username.isEmpty()) {
      toastMaker("Username may not be blank");
      return;
    }

    LiveData<User> userObserver = repository.getUserByUserName(username);
    userObserver.observe(this, user -> {
      if (user != null) {
        String password = binding.passwordLoginEditText.getText().toString();
        if (password.equals(user.getPassword())) {
          startActivity(MainActivity.mainActivityIntentFactory(getApplicationContext(), user.getId()));
        } else {
          toastMaker("Invalid password");
          binding.passwordLoginEditText.setSelection(0);
        }
      }
    });
  }

  private void toastMaker(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  static Intent logIntentFactory(Context context) {
    return new Intent(context, LoginActivity.class);
  }
}