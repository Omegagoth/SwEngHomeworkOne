package ch.epfl.sweng.swenghomeworkone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String USER_NAME = "ch.epfl.sweng.swenghomeworkone.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Implements of the OnClickListener interface for the button
     * Called when the user click on the go Button, launch the greeting Activity
     * @param view The view that has been clicked (not used in this method)
     */
    public void greetUser(View view) {
        Intent greetingIntent = new Intent(this, GreetingActivity.class);
        EditText userNameEditText = (EditText) findViewById(R.id.mainUserName);

        if (userNameEditText == null) {
            throw new NullPointerException("There is no EditText to get the user name");
        }

        String userNameString = userNameEditText.getText().toString();

        if (userNameString.length() == 0) {
            userNameString = getString(R.string.anonymous_user);
        }

        greetingIntent.putExtra(USER_NAME, userNameString);
        startActivity(greetingIntent);
    }
}
