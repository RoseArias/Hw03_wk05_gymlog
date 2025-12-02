package com.example.hw03_wk05_gymlog.database.typeConverters;

import androidx.room.TypeConverter;

import androidx.room.TypeConverters;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
* Name: Rose Arias-Aceves
* Date: 12/1/25
* Explanation: What is this class?
*/


public class LocalDateTypeConverter {

  @TypeConverter
  public long convertDateToLong(LocalDateTime date){
    ZonedDateTime zdt = ZonedDateTime.of(date, ZoneId.systemDefault());
    return zdt.toInstant().toEpochMilli();
  }

  @TypeConverter
  public LocalDateTime convertLongToDate(Long epochMilli){
    Instant instant = Instant.ofEpochMilli(epochMilli);
    return LocalDateTime.ofInstant(instant,ZoneId.systemDefault());
  }

}
