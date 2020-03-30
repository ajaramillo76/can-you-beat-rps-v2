package edu.cnm.deepdive.canyoubeatrps.controller;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.viewmodel.game.GameViewModel;

public class InfoFragment extends DialogFragment {

  private AlertDialog alert;
  private View dialogView;

  @SuppressLint("InflateParams")
  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    dialogView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_info, null);
    alert = new Builder(getContext())
        .setIcon(R.drawable.ic_info_alert)
        .setTitle(R.string.how_to)
        .setView(dialogView)
        .setNeutralButton(R.string.info_ok, (dlg, which) -> {
        })
        .create();
    return alert;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return dialogView;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    GameViewModel gameViewModel = new ViewModelProvider(getActivity()).get(GameViewModel.class);
    gameViewModel.getText().observe(getViewLifecycleOwner(), (game) -> {
      TextView description = dialogView.findViewById(R.id.description);
      alert.setTitle(R.string.how_to);
      description.setText(R.string.description);
    });
  }
}
