package com.example.helloworld;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button addBtn = (Button) findViewById(R.id.calculateBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText weightNumEditText = (EditText) findViewById(R.id.weightNumEditText);
                EditText heightNumEditText = (EditText) findViewById(R.id.heightNumEditText);
                EditText ageNumEditText = (EditText) findViewById(R.id.ageNumEditText);

                TextView resultNumTextView = (TextView) findViewById(R.id.resultNumTextView);
                TextView resultStringTextView = (TextView) findViewById(R.id.resultStringTextView);

                int weight = Integer.parseInt(weightNumEditText.getText().toString());
                int height = Integer.parseInt(heightNumEditText.getText().toString());
                int age = Integer.parseInt(ageNumEditText.getText().toString());
                String underweight = "Underweight"; //Niedowaga
                String correctWeight = "Correct weight"; //Prawidłowa waga
                String overweight = "Overweight"; //Nadwaga
                String obesity = "Obesity"; //Otyłość
                String extremeObesity = "Extreme obesity"; // Skrajna otyłość
                String resultName = "Error, propably wrong data.";


                double result =  weight / Math.pow((height/100.00), 2);
                result = Math.round(result);

                if(age <= 17){
                    resultName = "BMI index is only for adults, cannot be used for children!";
                }
                if(age >= 18 & age <= 24){
                    if(result < 19){ resultName = underweight; }
                    else if(result >= 19 & result < 24){ resultName = correctWeight; }
                    else if(result >= 24 & result < 29){ resultName = overweight; }
                    else if(result >= 29 & result <= 39){ resultName = obesity; }
                    else if(result > 39){ resultName = extremeObesity; }
                }
                else if(age >= 25 & age <= 34){
                    if(result < 20){ resultName = underweight; }
                    else if(result >= 20 & result < 25){ resultName = correctWeight; }
                    else if(result >= 25 & result < 30){ resultName = overweight; }
                    else if(result >= 30 & result <= 40){ resultName = obesity; }
                    else if(result > 40){ resultName = extremeObesity; }
                }
                else if(age >= 35 & age <= 44){
                    if(result < 21){ resultName = underweight; }
                    else if(result >= 21 & result < 26){ resultName = correctWeight; }
                    else if(result >= 26 & result < 31){ resultName = overweight; }
                    else if(result >= 31 & result <= 41){ resultName = obesity; }
                    else if(result > 41){ resultName = extremeObesity; }
                }
                else if(age >= 45 & age <= 54){
                    if(result < 22){ resultName = underweight; }
                    else if(result >= 22 & result < 27){ resultName = correctWeight; }
                    else if(result >= 27 & result < 32){ resultName = overweight; }
                    else if(result >= 32 & result <= 42){ resultName = obesity; }
                    else if(result > 42){ resultName = extremeObesity; }
                }

                else if(age >= 55 & age <= 64){
                    if(result < 23){ resultName = underweight; }
                    else if(result >= 23 & result < 28){ resultName = correctWeight; }
                    else if(result >= 28 & result < 33){ resultName = overweight; }
                    else if(result >= 33 & result <= 43){ resultName = obesity; }
                    else if(result > 43){ resultName = extremeObesity; }
                }

                else if(age >= 65){
                    if(result < 24){ resultName = underweight; }
                    else if(result >= 24 & result < 29){ resultName = correctWeight; }
                    else if(result >= 29 & result < 34){ resultName = overweight; }
                    else if(result >= 34 & result <= 44){ resultName = obesity; }
                    else if(result > 44){ resultName = extremeObesity; }
                }

                resultNumTextView.setText(result + "");
                resultStringTextView.setText(resultName);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
