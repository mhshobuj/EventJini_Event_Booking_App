package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.eventjinni.R;

public class CateringServiceProviderList extends AppCompatActivity {
    RelativeLayout aplha_rl, iqbal_rl, desh_rl;
    String provider_name, provider_address, provider_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catering_service_provider_list);

        aplha_rl = findViewById(R.id.aplha_rl);
        iqbal_rl = findViewById(R.id.iqbal_rl);
        desh_rl = findViewById(R.id.desh_rl);

        aplha_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Alpha Catering";
                provider_address = "Address: 786 Ibrahimpur Bazar Rd, Dhaka";
                provider_details ="Catering Packages- \n" +
                        "  1.Package 1(platter)- 180 bdt\n" +
                        "  2.Package 2(buffet)-500\n" +
                        "  3.Package 3(customised)- negotiable";

                Intent intent = new Intent(CateringServiceProviderList.this, CateringServiceProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);

            }
        });

        iqbal_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Iqbal Catering";
                provider_address = "Address: House#15/2, Road#6/A, Nobodoy Housing Society, Mohammadpur,, 1207 Dhaka";
                provider_details = "Catering Packages- \n" +
                        "  1.Package 1(platter)- 180 bdt\n" +
                        "  2.Package 2(buffet)-500\n" +
                        "  3.Package 3(customised)- negotiable";

                Intent intent = new Intent(CateringServiceProviderList.this, CateringServiceProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);

            }
        });

        desh_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Desh Catering";
                provider_address = "Address: North Matika, Dhaka 1206";
                provider_details =  "Catering Packages- \n" +
                        "  1.Package 1(platter)- 180 bdt\n" +
                        "  2.Package 2(buffet)-500\n" +
                        "  3.Package 3(customised)- negotiable";

                Intent intent = new Intent(CateringServiceProviderList.this, CateringServiceProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);

            }
        });
    }
}