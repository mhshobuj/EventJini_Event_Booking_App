package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.eventjinni.R;

public class ConventionCenterProviderList extends AppCompatActivity {
    RelativeLayout bongabundhu_rl, community_rl, spectra_rl;
    String provider_name, provider_address, provider_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convention_center_provider_list);

        bongabundhu_rl = findViewById(R.id.bongabundhu_rl);
        community_rl = findViewById(R.id.community_rl);
        spectra_rl = findViewById(R.id.spectra_rl);

        bongabundhu_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Bangabandhu Convention Center";
                provider_address = "Address: Begum Rokeya Avenue, Dhaka 1207";
                provider_details =  "Packages- \n" +
                        "  1.Economy for 100 people accommodation- 15000 bdt\n" +
                        "  2.Premium for 100 people accommodation-25000 bdt";

                Intent intent = new Intent(ConventionCenterProviderList.this, ConventionCenterProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);
            }
        });

        community_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Community Center BD";
                provider_address = "Address: 23/C Zigatola, Main Rd, Dhaka 1209";
                provider_details = "Packages- \n" +
                        "  1.Economy for 300 people accommodation- 25000 bdt\n" +
                        "  2.Premium for 300 people accommodation-40000 bdt";

                Intent intent = new Intent(ConventionCenterProviderList.this, ConventionCenterProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);

            }
        });

        spectra_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Spectra Convention Centre";
                provider_address = "Address: House # 19 Road-7, Dhaka 1212";
                provider_details = "Packages- \n" +
                        "  1.Economy for 500 people accommodation- 60000 bdt\n" +
                        "  2.Premium for 100 people accommodation-20000 bdt";

                Intent intent = new Intent(ConventionCenterProviderList.this, ConventionCenterProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);
            }
        });
    }
}