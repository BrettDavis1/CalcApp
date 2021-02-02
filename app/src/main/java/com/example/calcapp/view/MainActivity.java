package com.example.calcapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.calcapp.R;
import com.example.calcapp.viewmodel.MainViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView tvDisplay;
    public double num1 = 0;
    public double num2 = 0;
    public double total;
    public String op;
    public String nums = "";

    private MainViewModel viewModel;

    private int[] btnIds = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_period,
            R.id.btn_c, R.id.btn_divide, R.id.btn_minus, R.id.btn_plus, R.id.btn_percent, R.id.btn_equal, R.id.btn_x};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getTotal().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double total) {
                String totalString = total.toString();
                tvDisplay.setText(totalString);
            }
        });
    }

    private void initViews() {
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
                            tvDisplay.setText(nums);
                            break;
                        case "+":
                            num1 = Double.parseDouble(tvDisplay.getText().toString());
                            nums = "";
                            op = "+";
                            tvDisplay.setText(nums);
                            break;
                        case "-":
                            num1 = Double.parseDouble(tvDisplay.getText().toString());
                            nums = "";
                            op = "-";
                            tvDisplay.setText(nums);
                            break;
                        case "/":
                            num1 = Double.parseDouble(tvDisplay.getText().toString());
                            nums = "";
                            op = "/";
                            tvDisplay.setText(nums);
                            break;
                        case "x":
                            num1 = Double.parseDouble(tvDisplay.getText().toString());
                            nums = "";
                            op = "X";
                            tvDisplay.setText(nums);
                            break;
                        case "=":
                            num2 = Double.parseDouble(tvDisplay.getText().toString());
                            viewModel.calculateSum(num1, num2, op);
                            break;
                        default:
                            nums += btnClick.getText().toString();
                            tvDisplay.setText(nums);
                            break;
                    }
                }
            });
        }
    }
}
