package nonandroid.nanodegree.portfolio.ui.main;

import nonandroid.nanodegree.portfolio.ApplicationComponent;
import nonandroid.nanodegree.portfolio.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = MainModule.class)
public interface MainComponent {
  void inject(MainView view);
  MainPresenter presenter();
}
