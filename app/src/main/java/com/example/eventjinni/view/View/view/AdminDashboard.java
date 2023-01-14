package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.eventjinni.R;
import com.example.eventjinni.view.View.adapter.MyAdapter;
import com.example.eventjinni.view.View.db.DataBaseHelper;
import com.example.eventjinni.view.View.model.OrderInfoModel;
import com.example.eventjinni.view.View.prefs.SharedPreferencesHelper;

import java.util.ArrayList;

public class AdminDashboard extends AppCompatActivity {

    ArrayList<OrderInfoModel> arrayList;
    RecyclerView recyclerView;
    DataBaseHelper dbHelper;

    ImageView logout_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        logout_bt = findViewById(R.id.logout_bt);

        dbHelper = new DataBaseHelper(this);
        arrayList = new ArrayList<>();

        Cursor cursor = dbHelper.getData();
        if (cursor.getCount() == 0){
            Toast.makeText(AdminDashboard.this, "Data Not Found", Toast.LENGTH_LONG).show();
        }
        while (cursor.moveToNext()){
            OrderInfoModel model = new OrderInfoModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
            arrayList.add(model);
        }

        MyAdapter myAdapter = new MyAdapter(arrayList,this);
        recyclerView.setAdapter(myAdapter);

        logout_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(AdminDashboard.this)
                        .setTitle("Logout Request")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                            SharedPreferencesHelper.deleteData(AdminDashboard.this,"isLoggedAdmin");
                            Intent intent = new Intent(AdminDashboard.this, UserCategoryActivity.class);
                            startActivity(intent);
                            finish();

                        })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

    }
}