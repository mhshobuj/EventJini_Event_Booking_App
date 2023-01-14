package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventjinni.R;
import com.example.eventjinni.view.View.db.DataBaseHelper;

import java.util.Random;

public class OrderDetails extends AppCompatActivity {

    int id;
    DataBaseHelper dbHelper;
    TextView order_id_tv, service_name_tv, provider_name_tv, customer_name_tv, customer_phone_tv, address_tv, customer_date_time_tv;
    ImageView cancel_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        dbHelper = new DataBaseHelper(this);

        order_id_tv = findViewById(R.id.order_id_tv);
        service_name_tv = findViewById(R.id.service_name_tv);
        provider_name_tv = findViewById(R.id.provider_name_tv);
        customer_name_tv = findViewById(R.id.customer_name_tv);
        customer_phone_tv = findViewById(R.id.customer_phone_tv);
        address_tv = findViewById(R.id.address_tv);
        customer_date_time_tv = findViewById(R.id.customer_date_time_tv);

        cancel_img = findViewById(R.id.cancel_img);

        if (getIntent() != null){
            id = getIntent().getIntExtra("ID", 0);
            Cursor cursor = dbHelper.getDataByID(String.valueOf(id));

            if (cursor.getCount() == 0){
                Toast.makeText(OrderDetails.this, "Data Not Found", Toast.LENGTH_LONG).show();
                return;
            }
            else {
                while (cursor.moveToNext()){
                    order_id_tv.setText(new StringBuilder().append(cursor.getString(0)));
                    service_name_tv.setText(new StringBuilder().append(cursor.getString(1)));
                    provider_name_tv.setText(new StringBuilder().append(cursor.getString(2)));
                    customer_name_tv.setText(new StringBuilder().append(cursor.getString(3)));
                    customer_phone_tv.setText(new StringBuilder().append(cursor.getString(4)));
                    address_tv.setText(new StringBuilder().append(cursor.getString(5)));
                    customer_date_time_tv.setText(new StringBuilder().append(cursor.getString(6)));
                }
            }
        }
        else {
            Toast.makeText(OrderDetails.this, "Order ID not found", Toast.LENGTH_LONG).show();
        }

        cancel_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}