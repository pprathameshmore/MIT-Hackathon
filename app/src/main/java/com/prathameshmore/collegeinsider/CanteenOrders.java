package com.prathameshmore.collegeinsider;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CanteenOrders extends AppCompatActivity {

    private EditText editTextStudentName;
    private EditText editTextOrderName;
    private EditText editTextOrderQuantity;
    private Button buttonSubmitOrder;
    private DatabaseReference orderDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_orders);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Canteen Order");

        editTextStudentName = (EditText) findViewById(R.id.edittext_name);
        editTextOrderName = (EditText) findViewById(R.id.edittext_order_name);
        editTextOrderQuantity = (EditText) findViewById(R.id.edittext_quantity);
        buttonSubmitOrder = (Button) findViewById(R.id.buttonOrderSubmit);

        orderDatabase = FirebaseDatabase.getInstance().getReference("Canteen_Orders");

        buttonSubmitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String studentName = editTextStudentName.getText().toString();
                String orderName = editTextOrderName.getText().toString();
                String orderQuantity = editTextOrderQuantity.getText().toString();


                if (studentName.length() == 0 && orderName.length() == 0 && orderQuantity.length() == 0) {

                    Toast.makeText(CanteenOrders.this, "Fill your complete order", Toast.LENGTH_SHORT).show();

                } else {

                    String id = orderDatabase.push().getKey();

                    Orders odOrders = new Orders(studentName, orderName, orderQuantity);
                    orderDatabase.child(id).setValue(odOrders);
                    Toast.makeText(CanteenOrders.this, "Order is submitted, Wait...", Toast.LENGTH_SHORT).show();

                    editTextStudentName.setText("");
                    editTextOrderName.setText("");
                    editTextOrderQuantity.setText("");


                }


            }
        });


    }


}
