package android.nanodegree.portofolio;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
  private final App application;

  public ApplicationModule(App application) {
    this.application = application;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
    return application;
  }

  @Provides
  @Singleton
  Navigator provideNavigator() {
    return new Navigator();
  }
}
