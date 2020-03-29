package edu.cnm.deepdive.canyoubeatrps;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.canyoubeatrps.service.CanYouBeatRpsDatabase;
import edu.cnm.deepdive.canyoubeatrps.service.GoogleSignInRepository;
import io.reactivex.schedulers.Schedulers;


public class CanYouBeatRpsApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    GoogleSignInRepository.setContext(this);
    CanYouBeatRpsDatabase.setContext(this);
    CanYouBeatRpsDatabase.getInstance().getGameDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }
}
