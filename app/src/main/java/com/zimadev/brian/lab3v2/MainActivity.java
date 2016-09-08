package com.zimadev.brian.lab3v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_calc;
    private Button btn_clr;
    private EditText edt_loanAmount;
    private EditText edt_termYears;
    private EditText edt_yearlyInterest;
    private TextView txt_monthlyPayment;
    private TextView txt_totalPayment;
    private TextView txt_totalInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_calc = (Button)findViewById(R.id.btn_calculate);
        btn_clr = (Button)findViewById(R.id.btn_clr);
        edt_loanAmount = (EditText)findViewById(R.id.loanAmountInput);
        edt_termYears = (EditText)findViewById(R.id.termYearInput);
        edt_yearlyInterest = (EditText)findViewById(R.id.yearlyInterestInput);
        txt_monthlyPayment = (TextView)findViewById(R.id.monthlyPaymentOutput);
        txt_totalPayment = (TextView)findViewById(R.id.totalPaymentOutput);
        txt_totalInterest = (TextView)findViewById(R.id.totalInterstOutput);
    }

    public void calc(View view)
    {
        LoanCalculator lCalc = new LoanCalculator();

        lCalc.setLoanAmount(Double.parseDouble(edt_loanAmount.getText().toString()));
        lCalc.setNumberOfYears(Integer.parseInt(edt_termYears.getText().toString()));
        lCalc.setYearlyInterestRate(Double.parseDouble(edt_yearlyInterest.getText().toString()));

        txt_monthlyPayment.setText(Double.toString(lCalc.getMonthlyPayment()));
        txt_totalInterest.setText(Double.toString(lCalc.getTotalInterest()));
        txt_totalPayment.setText(Double.toString(lCalc.getTotalCostOfLoan()));
    }
}
