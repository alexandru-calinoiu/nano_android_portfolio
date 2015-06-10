package android.nanodegree.portofolio.ui.main;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
  private final MainView view;

  public MainModule(MainView mainView) {
    this.view = mainView;
  }

  @Provides
  MainView provideView() {
    return view;
  }

  @Provides
  MainPresenter providePresenter(MainView view) {
    return new MainPresenterImpl(view);
  }
}
