package android.nanodegree.portofolio;

import android.app.Application;

public class App extends Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    initiateInjector();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  private void initiateInjector() {
    applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }
}
