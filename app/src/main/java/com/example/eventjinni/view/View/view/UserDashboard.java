package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.eventjinni.R;
import com.example.eventjinni.view.View.prefs.SharedPreferencesHelper;

public class UserDashboard extends AppCompatActivity {

    RelativeLayout carService_item,convention_item, catering_item, decoration_item;
    ImageView logout_bt, profile_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        carService_item = findViewById(R.id.carService_item);
        convention_item = findViewById(R.id.convention_item);
        catering_item = findViewById(R.id.catering_item);
        decoration_item = findViewById(R.id.decoration_item);

        logout_bt = findViewById(R.id.logout_bt);
        profile_bt = findViewById(R.id.profile_bt);

        carService_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, CarServiceProviderList.class);
                startActivity(intent);
            }
        });

        convention_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, ConventionCenterProviderList.class);
                startActivity(intent);
            }
        });

        catering_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, CateringServiceProviderList.class);
                startActivity(intent);
            }
        });

        decoration_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, DecorationServiceProviderList.class);
                startActivity(intent);
            }
        });

        logout_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(UserDashboard.this)
                        .setTitle("Logout Request")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                            SharedPreferencesHelper.deleteData(UserDashboard.this,"isLoggedUser");
                            SharedPreferencesHelper.deleteData(UserDashboard.this,"UserEmail");
                            Intent intent = new Intent(UserDashboard.this, UserCategoryActivity.class);
                            startActivity(intent);
                            finish();

                        })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        profile_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, UserProfile.class);
                startActivity(intent);
            }
        });
    }
}