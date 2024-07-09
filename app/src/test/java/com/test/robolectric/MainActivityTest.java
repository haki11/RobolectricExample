package com.test.robolectric;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {
        Activity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.btnUpdateText);
        TextView results = (TextView) activity.findViewById(R.id.tvField);
        assertEquals("Hello World!", results.getText().toString());

        button.performClick();
        assertEquals("Testing Android Rocks1!", results.getText().toString());
    }

    @Test
    public void clickingButton2_shouldStartMainActivity2WithIntent() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);

        Button button2 = activity.findViewById(R.id.button2);
        button2.performClick();

        Intent expectedIntent = new Intent(activity, MainActivity2.class);
        expectedIntent.putExtra("key", "value");

        /* shadowOf(RuntimeEnvironment.application).getNextStartedActivity()
        is used to retrieve the next Intent that was started from the application context.
        This requires the use of ShadowApplication from Robolectric to inspect and verify Intent operations.
         */
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
        assertEquals("value", actual.getStringExtra("key"));
    }
}