package edu.cnm.deepdive.canyoubeatrps;

import android.app.Application;
import edu.cnm.deepdive.canyoubeatrps.service.GoogleSignInRepository;


public class CanYouBeatRpsApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    GoogleSignInRepository.setContext(this);
    Stetho.initializeWithDefaults(this);
  }
}
