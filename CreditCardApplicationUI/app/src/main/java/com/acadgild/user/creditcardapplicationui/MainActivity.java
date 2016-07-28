package com.acadgild.user.creditcardapplicationui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etCardBalance, etInterestRate, etMinPayment, etFinalCardBal, etMonthsRemaining, etInterestPaid;
    Button bCompute, bClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCardBalance=(EditText)findViewById(R.id.et_card_balance);
        etInterestRate=(EditText)findViewById(R.id.et_interest_rate);
        etMinPayment=(EditText)findViewById(R.id.et_min_payment);
        etFinalCardBal=(EditText)findViewById(R.id.et_final_card_bal);
        etMonthsRemaining=(EditText)findViewById(R.id.et_months_remaining);
        etInterestPaid=(EditText)findViewById(R.id.et_interest_paid);

        bCompute=(Button)findViewById(R.id.b_compute);
        bClear=(Button)findViewById(R.id.b_clear);
        String principal=  etCardBalance.getText().toString();
        int intPrincipal = Integer.parseInt(principal);
        String rate = etInterestRate.getText().toString();
        int intRate = Integer.parseInt(rate);
        String minPayment = etMinPayment.getText().toString();
        int intMinPayment  = Integer.parseInt(minPayment);

        final int monthlyFloatInterestPaid =Math.round((intPrincipal * (intRate / (100 * 12))));
        int monthlyPrinciple= intMinPayment - monthlyFloatInterestPaid;
        final int monthlyBalance=intPrincipal - monthlyPrinciple;


        bCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCardBalance.setText(monthlyBalance);
                etFinalCardBal.setText(monthlyBalance);
                etInterestPaid.setText(monthlyFloatInterestPaid);
            }
        });

    }
}
