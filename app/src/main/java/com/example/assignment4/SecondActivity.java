package com.example.assignment4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondActivity extends Activity {

    double conversionAmount, cad, euro, gbp, chf, cny;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Bundle extras = getIntent().getExtras();
        conversionAmount = extras.getDouble("conversionAmount");
        cad = extras.getDouble("cad");
        euro = extras.getDouble("euro");
        gbp = extras.getDouble("gbp");
        chf = extras.getDouble("chf");
        cny = extras.getDouble("cny");
        super.onCreate(savedInstanceState);


        RelativeLayout relativeLayout = new RelativeLayout(this);


        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        TextView textView = new TextView(this);

        if (cad != 0 && euro == 0 && gbp == 0 && chf == 0 && cny == 0) {
            textView.setText("$USD " + conversionAmount + " is " + cad);
        } else if (cad == 0 && euro == 0 && gbp != 0 && chf == 0 && cny == 0) {
            textView.setText("$USD " + conversionAmount + " is " + gbp);
        } else if (cad == 0 && euro == 0 && gbp == 0 && chf != 0 && cny == 0) {
            textView.setText("$USD " + conversionAmount + " is " + chf);
        } else if (cad == 0 && euro == 0 && gbp == 0 && chf == 0 && cny != 0) {
            textView.setText("$USD " + conversionAmount + " is " + cny);
        } else
            textView.setText("$USD " + conversionAmount + " is " + euro);


        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
        textView.setLayoutParams(lp);
        relativeLayout.addView(textView);
        setContentView(relativeLayout, rlp);
    }
}