package com.blundell.tut.howtotesttime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        WelcomeMessageGenerator generator = new WelcomeMessageGenerator(new Clock());
        WelcomeMessage welcomeMessage = generator.generate();
        TextView textView = (TextView) findViewById(R.id.main_text_view);
        textView.setText(welcomeMessage.getTextResId());
        textView.setBackgroundResource(welcomeMessage.getColorResId());
    }
}
