package com.prathameshmore.collegeinsider;

/**
 * Created by Prathamesh More on 16-02-2018.
 */

public class Orders {

    private String studentName;
    private String orderName;
    private String orderQuantity;

    public Orders() {

    }

    public Orders(String studentName, String orderName, String orderQuantity) {

        this.studentName = studentName;
        this.orderName = orderName;
        this.orderQuantity = orderQuantity;

    }

    public String getStudentName() {
        return studentName;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }
}
