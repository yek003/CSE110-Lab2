package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity((activity -> {
            //click 1
            final Button buttonOne = activity.findViewById(R.id.btn_one);
            buttonOne.performClick();

            //click +
            final Button buttonPlus = activity.findViewById(R.id.btn_plus);
            buttonPlus.performClick();

            //click 1
            buttonOne.performClick();

            //click =
            final Button buttonEquals = activity.findViewById(R.id.btn_equals);
            buttonEquals.performClick();

            //assert value of TextView is 2
            TextView view = activity.findViewById(R.id.display);
            assertEquals("2", view.getText());
        }));
    }
}
