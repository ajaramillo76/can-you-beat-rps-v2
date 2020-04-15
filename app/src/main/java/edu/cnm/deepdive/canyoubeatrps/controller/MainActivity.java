package edu.cnm.deepdive.canyoubeatrps.controller;

import static edu.cnm.deepdive.canyoubeatrps.model.repository.GameRepository.getContext;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.service.GoogleSignInRepository;

public class MainActivity extends AppCompatActivity {

  Button Rock, Paper, Scissors;
  TextView Player, Computer;
  TextView PlayerAction, ComputerAction;
  TextView Winrate, Loss;


  private AlertDialog alert;
  private View dialogView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BottomNavigationView navView = findViewById(R.id.navigator);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
        R.id.navigation_game, R.id.navigation_history)
        .build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(navView, navController);
    Rock = findViewById(R.id.rock);
    Paper = findViewById(R.id.paper);
    Scissors = findViewById(R.id.scissors);

    Player = findViewById(R.id.player);
    Computer = findViewById(R.id.computer);

    PlayerAction = findViewById(R.id.player_action_1);
    ComputerAction = findViewById(R.id.robot_action_1);

    Winrate = findViewById(R.id.win_rate);
    Loss = findViewById(R.id.loss);

    Rock.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Player.setText("Rock");
      }
    });
    Paper.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Player.setText("Paper");
      }
    });
    Scissors.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Player.setText("Scissors");
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.main_options, menu);
    return true;
  }

  @SuppressWarnings("SwitchStatementsWithTooFewBranches")
  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled = true;
    //noinspection SwitchStatementWithTooFewBranches
    switch (item.getItemId()) {
      case R.id.sign_out:
        GoogleSignInRepository.getInstance().signOut()
            .addOnCompleteListener((task) -> {
              Intent intent = new Intent(this, LoginActivity.class);
              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
            });
        break;
      case R.id.settings:
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        break;
      default:
          handled = super.onOptionsItemSelected(item);
      }
    return handled;
  }

  @SuppressLint("InflateParams")
  @NonNull
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
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return dialogView;
  }


  @Override
  public void onBackPressed() {
    new AlertDialog.Builder(this)
        .setTitle("Leaving the game?")
        .setMessage("Are you sure you want to exit?")
        .setNegativeButton(android.R.string.no, null)
        .setPositiveButton(android.R.string.yes, new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            MainActivity.super.onBackPressed();
          }
        }).create().show();
  }
}
