package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.eventjinni.R;

public class CarServiceProviderList extends AppCompatActivity {
    RelativeLayout toyota_car_rl, top_gear_car_rl, multibrand_car_rl;
    String provider_name, provider_address, provider_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_service_provider_list);

        toyota_car_rl = findViewById(R.id.toyota_car_rl);
        top_gear_car_rl = findViewById(R.id.top_gear_car_rl);
        multibrand_car_rl = findViewById(R.id.multibrand_car_rl);

        toyota_car_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Toyota Car Service";
                provider_address = "Address: New lake road, gulshan , south badda, holding no. B 117/4 Jhil park, Dhaka 1212";
                provider_details = "Car Service Package- \n" +
                        "  1.Toyota corrola-2500 bdt\n" +
                        "  2.Toyota allion- 3000 bdt\n" +
                        "  3.Toyota Hi ace-4000";

                Intent intent = new Intent(CarServiceProviderList.this, CarServiceProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);
            }
        });

        top_gear_car_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Top Gear Auto Service";
                provider_address = "Address: Madani Ave, Dhaka 1212";
                provider_details = "Car Service Package- \n" +
                        "  1.Toyota corrola-1200 bdt\n" +
                        "  2.Toyota allion- 1500 bdt\n" +
                        "  3.Toyota Hi ace-2000";

                Intent intent = new Intent(CarServiceProviderList.this, CarServiceProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);
            }
        });

        multibrand_car_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Multibrand Car Service";
                provider_address = "Address: 417-418, Tejgaon I/A, Dhaka, 1208";
                provider_details = "Car Service Package- \n" +
                        "  1.Premio-3500 bdt \n" +
                        "  2.BMW- 7000 bdt\n" +
                        "  3.Mercedes- 8000 bdt";

                Intent intent = new Intent(CarServiceProviderList.this, CarServiceProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);
            }
        });
    }
}