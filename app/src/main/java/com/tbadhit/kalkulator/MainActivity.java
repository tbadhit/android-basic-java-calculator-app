package com.tbadhit.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.tbadhit.kalkulator.databinding.ActivityMainBinding;

// buat layout kalkulator
// buat logic di MainActivity
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        ini contoh pertama yang ribet
//        binding.btnPlus.setOnClickListener(v -> {
//
//            String firstNumber = binding.edtInitialInput.getText().toString();
//            String secondNumber = binding.edtSecondInput.getText().toString();
//
//            // Validasi
//            if (firstNumber.isEmpty()) {
//                binding.edtInitialInput.setError("Please enter first number");
//            }
//            if (secondNumber.isEmpty()) {
//                binding.edtSecondInput.setError("Please enter second number");
//            }
//
//            if (!firstNumber.isEmpty() && !secondNumber.isEmpty()) {
//                double result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
//                binding.tvResult.setText(String.valueOf(result));
//            }
//        });

        binding.btnPlus.setOnClickListener(v -> {
            validation(binding.edtInitialInput.getText().toString(), binding.edtSecondInput.getText().toString(), '+');
        });

        binding.btnMinus.setOnClickListener(v -> {
            validation(binding.edtInitialInput.getText().toString(), binding.edtSecondInput.getText().toString(), '-');
        });

        binding.btnTimes.setOnClickListener(v -> {
            validation(binding.edtInitialInput.getText().toString(), binding.edtSecondInput.getText().toString(), 'x');
        });

        binding.btnDivided.setOnClickListener(v -> {
            validation(binding.edtInitialInput.getText().toString(), binding.edtSecondInput.getText().toString(), '/');
        });
    }

    private void validation(String firstNumber, String secondNumber, char operator) {
        if (firstNumber.isEmpty()) {
            binding.edtInitialInput.setError("Please enter first number");
        }
        if (secondNumber.isEmpty()) {
            binding.edtSecondInput.setError("Please enter second number");
        }

        if (!firstNumber.isEmpty() && !secondNumber.isEmpty()) {
            calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), operator);
        }
    }

    private void calculate(double firstNumber, double secondNumber, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case 'x':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            default:
                result = 0.0;
                break;
        }
        binding.tvResult.setText(String.valueOf(result));
    }
}