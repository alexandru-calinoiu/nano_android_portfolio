package android.nanodegree.portofolio.ui.main;

import android.content.Context;
import android.content.Intent;
import android.nanodegree.portofolio.App;
import android.nanodegree.portofolio.ApplicationComponent;
import android.nanodegree.portofolio.Navigator;
import android.nanodegree.portofolio.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

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
}
