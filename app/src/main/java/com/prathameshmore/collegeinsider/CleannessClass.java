package com.prathameshmore.collegeinsider;

/**
 * Created by Prathamesh More on 16-02-2018.
 */

public class CleannessClass {

    private String name;
    private String email;
    private String roll;
    private String report;


    public CleannessClass() {

    }

    public CleannessClass(String name, String email, String roll, String report) {

        this.name = name;
        this.email = email;
        this.roll = roll;
        this.report = report;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRoll() {
        return roll;
    }

    public String getReport() {
        return report;
    }
}
