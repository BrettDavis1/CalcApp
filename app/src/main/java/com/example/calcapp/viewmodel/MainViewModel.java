package com.example.calcapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Double> _total = new MutableLiveData();

    public LiveData<Double> getTotal() {
        return _total;
    }
    public void calculateSum(Double num1, Double num2, String op) {
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
