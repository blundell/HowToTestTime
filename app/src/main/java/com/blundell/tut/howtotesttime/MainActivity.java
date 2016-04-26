package com.blundell.tut.howtotesttime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        InformationCalculator informationCalculator = new InformationCalculator();
        Information information = informationCalculator.calculate();
        TextView informationView = (TextView) findViewById(R.id.main_text_view);
        informationView.setText(information.getTextResId());
        informationView.setBackgroundResource(information.getColorResId());
    }
}
