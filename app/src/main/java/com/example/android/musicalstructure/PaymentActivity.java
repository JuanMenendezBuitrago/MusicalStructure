package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    /** Activity's Label **/
    String mLabel = "Payment screen";

    /** Activity's description **/
    String mDescription = "Here's a brief description about how to implement Stripe payment in " +
            "the app.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // set the required texts
        ((TextView)findViewById(R.id.labelText)).setText(mLabel);
        ((TextView)findViewById(R.id.descriptionText)).setText(mDescription);

        // add home button
        insertHomeButton();
    }

    /**
     * Inserts the play/pause ImageButton and attach the click event handler.
     */
    private void insertHomeButton() {

        // create Button element
        Button homeButton = new Button(this);
        homeButton.setText("home");
        homeButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });

        LinearLayout list = (LinearLayout) findViewById(R.id.paymentLayout);
        list.addView(homeButton);
    }
}
