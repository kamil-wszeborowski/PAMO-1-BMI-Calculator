package com.example.bmicalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CaloriesFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private String gender;
    private EditText caloriesWeightNumEditText;
    private EditText caloriesHeightNumEditText;
    private EditText caloreiesAgeNumEditText;
    private Spinner caloriesGenderSpinner;

    private Button caloriesCalculateBtn;
    private TextView caloriesResultNumTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calories, container, false);

        caloriesWeightNumEditText = view.findViewById(R.id.caloriesWeightNumEditText);
        caloriesHeightNumEditText = view.findViewById(R.id.caloriesHeightNumEditText);
        caloreiesAgeNumEditText = view.findViewById(R.id.caloriesAgeNumEditText);
        caloriesResultNumTextView = view.findViewById(R.id.caloriesResultNumTextView);
        caloriesGenderSpinner = view.findViewById(R.id.caloriesGenderSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.caloriesGenderList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        caloriesGenderSpinner.setAdapter(adapter);
        caloriesGenderSpinner.setOnItemSelectedListener(this);

        caloriesCalculateBtn = view.findViewById(R.id.caloriesCalculateBtn);
        caloriesCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatePpm();
            }
        });
        return view;
    }

    public void calculatePpm(){
        double result = 0;
        double weight = parseDoubleWithDefault(caloriesWeightNumEditText.getText().toString());
        double height = parseDoubleWithDefault(caloriesHeightNumEditText.getText().toString());
        double age = parseDoubleWithDefault(caloreiesAgeNumEditText.getText().toString());
        String condition = getString(R.string.caloriesMale);

        try {
            if( gender.equals(condition) ){
                result = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
            }else {
                result = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
            }
        }catch (ArithmeticException e){
            System.out.println(getString(R.string.arithmeticException) + e.getMessage());
        }

        result = Math.round(result);

        caloriesResultNumTextView.setText(result + "");
    }


    public static double parseDoubleWithDefault(String number) {
        double defaultVal = 0;
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        try {
            gender = parent.getItemAtPosition(position).toString();
        }catch(Exception e){
            gender = getString(R.string.unknownException) + e.getMessage();
        }

        Toast.makeText(parent.getContext(), gender, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
