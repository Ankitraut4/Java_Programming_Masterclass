package com.company;

import javax.xml.validation.Validator;
import java.util.Locale;

public class Car {

    private String model;
    private int door;
    private int wheels;
    private String color;

    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if (validModel.equals("aventador") || validModel.equals("seian")) {
            this.model = model;
        }else {
            this.model="UNKNOWN";
        }
    }

    public String getModel(){
        return this.model;
    }
}
