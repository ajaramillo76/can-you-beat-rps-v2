package edu.cnm.deepdive.canyoubeatrps;

import android.app.Application;

public class CanYouBeatRpsApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    edu.cnm.deepdive.canyoubeatrps.service.GoogleSignInRepository.setContext(this);
    CanYouBeatRpsDatabase.setContext(this);
    CanYouBeatRpsDatabase.getInstance().getGameDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();

  }
}
