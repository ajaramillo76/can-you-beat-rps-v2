package edu.cnm.deepdive.canyoubeatrps.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.viewmodel.game.GameViewModel;

public class GameFragment extends Fragment {

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    GameViewModel gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
    View root = inflater.inflate(R.layout.fragment_game, container, false);
     return root;
  }
}