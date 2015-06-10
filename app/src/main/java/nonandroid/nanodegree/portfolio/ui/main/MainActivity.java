package nonandroid.nanodegree.portfolio.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import nonandroid.nanodegree.portfolio.App;
import nonandroid.nanodegree.portfolio.ApplicationComponent;
import nonandroid.nanodegree.portfolio.Navigator;
import nonandroid.nanodegree.portfolio.R;

public class MainActivity extends AppCompatActivity implements MainView {

  private Toast toast;

  @Inject
  public Navigator navigator;

  public static Intent getIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setupComponent();

    ButterKnife.inject(this);

    toast = new Toast(this);
  }

  private void setupComponent() {
    ApplicationComponent applicationComponent = ((App) getApplication()).getApplicationComponent();
    DaggerMainComponent.builder()
        .applicationComponent(applicationComponent)
        .mainModule(new MainModule(this))
        .build()
        .inject(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @OnClick({R.id.spotify_streamer, R.id.scores_app, R.id.library_app, R.id.build_it_bigger, R.id.xyz_reader, R.id.capstone})
  public void onButtonClick(Button view) {
    toast.cancel();

    String text = String.format("This button will launch %s.", view.getText());

    toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
    toast.show();
  }
}
