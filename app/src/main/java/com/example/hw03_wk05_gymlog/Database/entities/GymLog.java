package com.example.hw03_wk05_gymlog.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.hw03_wk05_gymlog.Database.GymLogDatabase;
import java.time.LocalDate;

/**
* Name: Rose Arias-Aceves
* Date: 12/1/25
* Explanation: What is this class?
*/

@Entity(tableName = GymLogDatabase.GYM_LOG_TABLE)
public class GymLog {

  @PrimaryKey(autoGenerate = true)
  private int id;

  private String exercise;
  private double weight;
  private int reps;
  private LocalDate date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getExercise() {
    return exercise;
  }

  public void setExercise(String exercise) {
    this.exercise = exercise;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getReps() {
    return reps;
  }

  public void setReps(int reps) {
    this.reps = reps;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public GymLog(String exercise, double weight, int reps) {
    this.exercise = exercise;
    this.weight = weight;
    this.reps = reps;
    date = LocalDate.now();
  }
}
