package edu.cnm.deepdive.canyoubeatrps.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.viewmodel.history.HistoryViewModel;

public class HistoryFragment extends Fragment {

  private ListView historyList;
  private HistoryViewModel historyViewModel;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View layout = inflater.inflate(R.layout.fragment_history, container, false);
    historyList = layout.findViewById(R.id.history_list);
     return layout;
  }
}