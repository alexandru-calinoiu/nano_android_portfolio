package android.nanodegree.portofolio.ui.main;

import android.nanodegree.portofolio.ApplicationComponent;
import android.nanodegree.portofolio.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = MainModule.class)
public interface MainComponent {
  void inject(MainView view);
  MainPresenter presenter();
}
