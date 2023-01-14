package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.eventjinni.R;

public class DecorationServiceProviderList extends AppCompatActivity {

    RelativeLayout concept_rl, balloons_rl, imagine_rl;
    String provider_name, provider_address, provider_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration_service_provider_list);

        concept_rl = findViewById(R.id.concept_rl);
        balloons_rl = findViewById(R.id.balloons_rl);
        imagine_rl = findViewById(R.id.imagine_rl);

        concept_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Interior Concepts BD";
                provider_address = "Address: 323, Aftab Tower , 1st Floor, *Near Bangladesh Television, Dhaka 1219";
                provider_details = "Decoration service- \n" +
                        "  1.Wedding hall and stage- 10000 bdt\n" +
                        "  2.Pre wedding decorations - 5000 bdt";

                Intent intent = new Intent(DecorationServiceProviderList.this, DecorationServiceProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);
            }
        });

        balloons_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Balloons decoration in bd";
                provider_address = "Address: 16, 30 Azam Rd, Dhaka 1207";
                provider_details =  "Decoration service- \n" +
                        "  1.Wedding hall and stage- 10000 bdt\n" +
                        "  2.Pre wedding decorations - 5000 bdt";

                Intent intent = new Intent(DecorationServiceProviderList.this, DecorationServiceProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);
            }
        });

        imagine_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provider_name = "Imagine Interiors";
                provider_address = "Address: SEL Rose-N-Dale, 116 Kazi Nazrul Islam Ave, Dhaka 1205";
                provider_details = "Decoration service- \n" +
                        "  1.Wedding hall and stage- 10000 bdt\n" +
                        "  2.Pre wedding decorations - 5000 bdt";

                Intent intent = new Intent(DecorationServiceProviderList.this, DecorationServiceProviderDetails.class);
                intent.putExtra("PROVIDER_NAME", provider_name);
                intent.putExtra("PROVIDER_ADDRESS", provider_address);
                intent.putExtra("PROVIDER_DETAILS", provider_details);
                startActivity(intent);
            }
        });
    }
}