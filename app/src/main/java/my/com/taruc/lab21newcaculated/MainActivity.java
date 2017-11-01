package my.com.taruc.lab21newcaculated;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";

    private EditText editTextCarPrice,editTextDownPayment,editTextLoadPeriod,editTextInterestRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCarPrice = (EditText)findViewById(R.id.editTextCarPrice);
        editTextDownPayment = (EditText)findViewById(R.id.editTextDownPayment);
        editTextLoadPeriod = (EditText)findViewById(R.id.editTextLoadPeriod);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
    }

    public void calculateLoan(View view){
        Intent intent = new Intent(this, ResultActivity.class);

        double monthlyPayment, Totalinterest, Totalloan;
        String status;
        double VP = Double.parseDouble(editTextCarPrice.getText().toString());
        double DP = Double.parseDouble(editTextDownPayment .getText().toString());
        double Interestrate = Double.parseDouble(editTextInterestRate.getText().toString());
        Interestrate = Interestrate/100;
        double Repayment = Double.parseDouble(editTextLoadPeriod.getText().toString());

        Totalinterest = (VP-DP)*Interestrate*(Repayment/12);
        Totalloan = (VP-DP)+Totalinterest;
        monthlyPayment = Totalloan/Totalinterest;



        intent.putExtra(MONTHLY_PAYMENT, monthlyPayment);
        intent.putExtra(LOAN_STATUS, status);

        startActivity(intent);
    }
}
