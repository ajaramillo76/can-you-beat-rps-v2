package edu.cnm.deepdive.canyoubeatrps.service;

import android.annotation.SuppressLint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface CanYouBeatRpsService {

  String DATE_FORMAT = "yyyy-MM-dd";

  @SuppressLint("SimpleDateFormat")
  DateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMAT);

}
