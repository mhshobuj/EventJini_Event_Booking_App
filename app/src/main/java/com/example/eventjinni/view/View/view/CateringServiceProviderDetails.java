package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventjinni.R;

public class CateringServiceProviderDetails extends AppCompatActivity {
    Button submit_request_bt;
    TextView provider_name_tv, provider_address_tv, provider_details_tv;
    private final String service_name = "Catering Service";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catering_service_provider_details);

        submit_request_bt = findViewById(R.id.submit_request_bt);

        provider_name_tv = findViewById(R.id.provider_name_tv);
        provider_address_tv = findViewById(R.id.provider_address_tv);
        provider_details_tv = findViewById(R.id.provider_details_tv);

        String provider_name = getIntent().getStringExtra("PROVIDER_NAME");
        String provider_address = getIntent().getStringExtra("PROVIDER_ADDRESS");
        String provider_details = getIntent().getStringExtra("PROVIDER_DETAILS");

        provider_name_tv.setText(provider_name);
        provider_address_tv.setText(provider_address);
        provider_details_tv.setText(provider_details);

        submit_request_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CateringServiceProviderDetails.this, CustomerOrderInfo.class);
                String provider_name = provider_name_tv.getText().toString();
                intent.putExtra("SERVICE_NAME", service_name);
                intent.putExtra("PROVIDER_NAME", provider_name);
                startActivity(intent);
                finish();
            }
        });
    }
}