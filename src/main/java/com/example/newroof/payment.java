package com.example.newroof;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class payment extends AppCompatActivity implements PaymentResultListener {
    public TextView paytxt,msgtxt;
    public EditText amount;
    Button paybtn;
    int amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        msgtxt = (TextView) findViewById(R.id.msgtxt);
        amount = (EditText) findViewById(R.id.amount);
        paybtn = (Button) findViewById(R.id.paybtn);
//        int amt = Integer.parseInt(amount.getText().toString().trim());
//        amt = amt * 100;
        Checkout.preload(getApplicationContext());
        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makepayment();
            }
        });
    }
    public void makepayment(){
        amt = Integer.parseInt(amount.getText().toString().trim());
        amt = amt * 100;
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_hheknDgRhJJd3T");
        /**
         * Instantiate Checkout
         */


        /**
         * Set your logo here
         */
        //checkout.setImage(R.drawable.viridiancaymen);

        /**
         * Reference to current activity
         */
//        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        JSONObject options = new JSONObject();
        try {


            options.put("name", "Roof");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#d1627e");
            options.put("currency", "INR");
            options.put("amount", amt);//pass amount in currency subunits
            options.put("prefill.email", "support.roof@gmail.com");
            options.put("prefill.contact","8928178181");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(payment.this, options);

        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }
    public void back(View v){
        Intent i = new Intent(payment.this,Dashboard.class);
        startActivity(i);
    }

    @Override
    public void onPaymentSuccess(String s) {
        msgtxt.setText("Successful Payment ID: "+s);
    }

    @Override
    public void onPaymentError(int i, String s) {
        msgtxt.setText("Failed and cause is "+s);
    }
}