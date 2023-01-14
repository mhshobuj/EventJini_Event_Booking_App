package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventjinni.R;
import com.example.eventjinni.view.View.db.DataBaseHelper;

public class CustomerOrderInfo extends AppCompatActivity {
    Button conform_bt;
    TextView service_name_tv, provider_name_tv;
    EditText customer_name_tv, customer_phone_tv, customer_address_tv, customer_date_time_tv;
    String service_name, provider_name;

    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order_info);

        conform_bt = findViewById(R.id.conform_bt);

        service_name_tv = findViewById(R.id.service_name_tv);
        provider_name_tv = findViewById(R.id.provider_name_tv);

        customer_name_tv = findViewById(R.id.customer_name_tv);
        customer_phone_tv = findViewById(R.id.customer_phone_tv);
        customer_address_tv = findViewById(R.id.customer_address_tv);
        customer_date_time_tv = findViewById(R.id.customer_date_time_tv);

        dataBaseHelper = new DataBaseHelper(this);

        service_name = getIntent().getStringExtra("SERVICE_NAME");
        provider_name = getIntent().getStringExtra("PROVIDER_NAME");

        service_name_tv.setText("Service Name: " + service_name);
        provider_name_tv.setText("Provider Name: " +provider_name);

        conform_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(CustomerOrderInfo.this)
                        .setTitle("Submit Request")
                        .setMessage("Are you sure you want to submit?")
                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, (dialog, which) -> {

                            String customer_name = customer_name_tv.getText().toString();
                            String customer_phone = customer_phone_tv.getText().toString();
                            String customer_address = customer_address_tv.getText().toString();
                            String date = customer_date_time_tv.getText().toString();

                            if (customer_name.equals("") || customer_phone.equals("") || customer_address.equals("") || date.equals("")){
                                Toast.makeText(CustomerOrderInfo.this, "Please enter all field", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Boolean checkInsertData = dataBaseHelper.insertOrderInfo(service_name, provider_name, customer_name, customer_phone, customer_address, date);
                                if (checkInsertData){
                                    Toast.makeText(CustomerOrderInfo.this, "Successfully Submit", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(CustomerOrderInfo.this, UserDashboard.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(CustomerOrderInfo.this, "Not Submitted", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }
}