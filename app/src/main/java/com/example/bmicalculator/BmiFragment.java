package com.example.bmicalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BmiFragment extends Fragment {

    private EditText weightNumEditText;
    private EditText heightNumEditText;
    private EditText ageNumEditText;

    private TextView resultNumTextView;
    private TextView resultStringTextView;

    private Button calculateBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi, container, false);

        weightNumEditText = (EditText) view.findViewById(R.id.weightNumEditText);
        heightNumEditText = (EditText) view.findViewById(R.id.heightNumEditText);
        ageNumEditText = (EditText) view.findViewById(R.id.ageNumEditText);
        resultNumTextView = (TextView) view.findViewById(R.id.resultNumTextView);
        resultStringTextView = (TextView) view.findViewById(R.id.resultStringTextView);
        calculateBtn = (Button) view.findViewById(R.id.calculateBtn);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi();
            }
        });

        return view;
    }

    public void calculateBmi(){
        int weight = parseWithDefault(weightNumEditText.getText().toString());
        int height = parseWithDefault(heightNumEditText.getText().toString());

        double result =  weight / Math.pow((height/100.00), 2);
        result = Math.round(result);

        showBmiResult(result);
    }

    public void showBmiResult(double bmiValue){
        int age = parseWithDefault(ageNumEditText.getText().toString());

        String underweight = getString(R.string.descriptionUnderweight);
        String correctWeight = getString(R.string.descriptionCorrectWeight);
        String overweight = getString(R.string.descriptionOverweight);
        String obesity = getString(R.string.descriptionObesity);
        String extremeObesity = getString(R.string.descriptionExtremeObesity);
        String resultUnderEighteen = getString(R.string.descriptionResultUnderEighteen);
        String resultName = getString(R.string.descriptionResultName);

        if(age <= 17){ resultName = resultUnderEighteen; }
        if(age >= 18 & age <= 24){
            if(bmiValue < 19){ resultName = underweight; }
            else if(bmiValue >= 19 & bmiValue < 24){ resultName = correctWeight; }
            else if(bmiValue >= 24 & bmiValue < 29){ resultName = overweight; }
            else if(bmiValue >= 29 & bmiValue <= 39){ resultName = obesity; }
            else if(bmiValue > 39){ resultName = extremeObesity; }
        }
        else if(age >= 25 & age <= 34){
            if(bmiValue < 20){ resultName = underweight; }
            else if(bmiValue >= 20 & bmiValue < 25){ resultName = correctWeight; }
            else if(bmiValue >= 25 & bmiValue < 30){ resultName = overweight; }
            else if(bmiValue >= 30 & bmiValue <= 40){ resultName = obesity; }
            else if(bmiValue > 40){ resultName = extremeObesity; }
        }
        else if(age >= 35 & age <= 44){
            if(bmiValue < 21){ resultName = underweight; }
            else if(bmiValue >= 21 & bmiValue < 26){ resultName = correctWeight; }
            else if(bmiValue >= 26 & bmiValue < 31){ resultName = overweight; }
            else if(bmiValue >= 31 & bmiValue <= 41){ resultName = obesity; }
            else if(bmiValue > 41){ resultName = extremeObesity; }
        }
        else if(age >= 45 & age <= 54){
            if(bmiValue < 22){ resultName = underweight; }
            else if(bmiValue >= 22 & bmiValue < 27){ resultName = correctWeight; }
            else if(bmiValue >= 27 & bmiValue < 32){ resultName = overweight; }
            else if(bmiValue >= 32 & bmiValue <= 42){ resultName = obesity; }
            else if(bmiValue > 42){ resultName = extremeObesity; }
        }
        else if(age >= 55 & age <= 64){
            if(bmiValue < 23){ resultName = underweight; }
            else if(bmiValue >= 23 & bmiValue < 28){ resultName = correctWeight; }
            else if(bmiValue >= 28 & bmiValue < 33){ resultName = overweight; }
            else if(bmiValue >= 33 & bmiValue <= 43){ resultName = obesity; }
            else if(bmiValue > 43){ resultName = extremeObesity; }
        }
        else if(age >= 65){
            if(bmiValue < 24){ resultName = underweight; }
            else if(bmiValue >= 24 & bmiValue < 29){ resultName = correctWeight; }
            else if(bmiValue >= 29 & bmiValue < 34){ resultName = overweight; }
            else if(bmiValue >= 34 & bmiValue <= 44){ resultName = obesity; }
            else if(bmiValue > 44){ resultName = extremeObesity; }
        }

        resultNumTextView.setText(bmiValue + "");
        resultStringTextView.setText(resultName);
    }

    public static int parseWithDefault(String number) {
        int defaultVal = 0;
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

}
