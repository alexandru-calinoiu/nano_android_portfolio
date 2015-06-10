package android.nanodegree.portofolio.ui.main;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

  private MainActivity subject;

  public MainActivityTest() {
    super(MainActivity.class);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.setActivityIntent(MainActivity.getIntent(getInstrumentation().getContext()));
    subject = getActivity();
  }

  public void testContainsProperTitle() throws Exception {
    assertThat(subject.getTitle().toString(), is("Portfolio"));
  }

  public void testContainsLabel() throws Exception {
    onView(withText("Nanodegree apps")).check(doesExist());
  }

  public void testContainsButtonForSpotifyStreamer() throws Exception {
    onView(button(withText("Spotify Streamer"))).check(doesExist());
  }

  public void testContainsButtonForScoresApp() throws Exception {
    onView(button(withText("Scores App"))).check(doesExist());
  }

  public void testContainsLibraryApp() throws Exception {
    onView(button(withText("Library App"))).check(doesExist());
  }

  public void testContainsBuildItBigger() throws Exception {
    onView(button(withText("Build it bigger"))).check(doesExist());
  }

  public void testContainsXYZReader() throws Exception {
    onView(button(withText("XYZ reader"))).check(doesExist());
  }

  public void testContainsCapstone() throws Exception {
    onView(button(withText("Capstone: my own app"))).check(doesExist());
  }

  @SuppressWarnings("Convert2Lambda")
  private static ViewAssertion doesExist() {
    return new ViewAssertion() {
      public void check(View view, NoMatchingViewException noView) {
        if(view == null) {
          ViewMatchers.assertThat("View is not present in the hierarchy", false, is(true));
        }

      }
    };
  }

  private static Matcher<View> button(final Matcher<View> textMatcher) {
    return allOf(withClassName(endsWith("AppCompatButton")), textMatcher);
  }
}
