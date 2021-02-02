package com.example.calcapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Double> _total = new MutableLiveData();

    public LiveData<Double> getTotal() {
        return _total;
    }
    public void calculateSum(String stringNum1, String stringNum2, String op) {
        Double num1 = Double.parseDouble(stringNum1);
        Double num2 = Double.parseDouble(stringNum2);

        switch(op) {
            case "+":
                _total.setValue(num1 + num2);
                break;
            case "-":
                _total.setValue(num1- num2);
                break;
            case "X":
                _total.setValue(num1 * num2);
                break;
            case "/":
                _total.setValue(num1 / num2);
                break;
        }
    }
}
