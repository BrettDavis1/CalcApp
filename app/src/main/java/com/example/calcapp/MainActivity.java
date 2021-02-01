package com.example.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView tvDisplay;
    public double num1 = 0;
    public double num2 = 0;
    public double total;
    public String op;
    public String nums = "";

    private int[] btnIds = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_period,
            R.id.btn_c, R.id.btn_divide, R.id.btn_minus, R.id.btn_plus, R.id.btn_percent, R.id.btn_equal, R.id.btn_x};
    String getEqual(String oper, double num) {
        switch (oper) {
            case "+":
                total = num1 + num;
                nums = String.valueOf(total);
                break;
            case "-":
                total = num1 - num;
                nums = String.valueOf(total);
                break;
            case "/":
                total = num1 / num;
                nums = String.valueOf(total);
                break;
            case "X":
                total = num1 * num;
                nums = String.valueOf(total);
                break;
            default:
                break;
        }
        return nums;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.tv_display);
        for(int id: btnIds ) {
            MaterialButton btnClick;
            btnClick = findViewById(id);
            btnClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(btnClick.getText().toString()) {
                        case "C":
                            nums = "";
                            total = 0;
                            num1 = 0;
                            num2 = 0;
                            op = "";
                            break;
                        case "+":
                            num1 = Double.parseDouble(tvDisplay.getText().toString());
                            nums = "";
                            op = "+";
                            break;
                        case "-":
                            num1 = Double.parseDouble(tvDisplay.getText().toString());
                            nums = "";
                            op = "-";
                            break;
                        case "/":
                            num1 = Double.parseDouble(tvDisplay.getText().toString());
                            nums = "";
                            op = "/";
                            break;
                        case "x":
                            num1 = Double.parseDouble(tvDisplay.getText().toString());
                            nums = "";
                            op = "X";
                            break;
                        case "=":
                            nums = getEqual(op, Double.parseDouble(tvDisplay.getText().toString()));
                            break;
                        default:
                            nums += btnClick.getText().toString();
                            break;
                    }
                    tvDisplay.setText(nums);
                }
            });
        }
    }
}
