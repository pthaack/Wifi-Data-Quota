package ca.philipyoung.wifidataquota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final Integer intMonthlyBudget = 5120;
    private static final Integer intEndOfFiscalMonth = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Determine the daily budget from the length of the fiscal month
        Date dteToday = new Date();
        Integer intDayOfMonth = dteToday.getDate();
        Integer intEndOfMonth, intThisMonth = (intDayOfMonth<=intEndOfFiscalMonth?dteToday.getMonth()-1:dteToday.getMonth());
        switch(intThisMonth+1) {
            case 2:
                intEndOfMonth=28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                intEndOfMonth=30;
                break;
            default:
                intEndOfMonth=31;
                break;
        }
        Integer intDailyBudget = 1000*intMonthlyBudget/intEndOfMonth*(-intEndOfFiscalMonth+intDayOfMonth+(intDayOfMonth>intEndOfFiscalMonth?0:intEndOfMonth))/1000;
        ((TextView)findViewById(R.id.hello_world)).setText(Integer.toString(intDailyBudget));
    }
}
