package edu.cnm.deepdive.canyoubeatrps.viewmodel.history;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import edu.cnm.deepdive.canyoubeatrps.model.pojo.UserSummary;
import edu.cnm.deepdive.canyoubeatrps.model.repository.GameRepository;
import edu.cnm.deepdive.canyoubeatrps.service.CanYouBeatRpsService;
import io.reactivex.disposables.CompositeDisposable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class HistoryViewModel extends AndroidViewModel {

  private final MutableLiveData<Game> game;
  private final GameRepository repository;

  public HistoryViewModel(@NonNull Application application) {
    super(application);
    repository = GameRepository.getInstance();
    game = new MutableLiveData<>();
    Date today = new Date();
    String formattedDate = CanYouBeatRpsService.DATE_FORMATTER.format(today);
  }

  public LiveData<List<UserSummary>> getAllSummaries() {
    return repository.get();
  }

  public LiveData<Game> getGame() {
    return game;
  }
}