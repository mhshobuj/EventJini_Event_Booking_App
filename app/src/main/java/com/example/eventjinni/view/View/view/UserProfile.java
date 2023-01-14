package com.example.eventjinni.view.View.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventjinni.R;
import com.example.eventjinni.view.View.db.DataBaseHelper;
import com.example.eventjinni.view.View.prefs.SharedPreferencesHelper;

public class UserProfile extends AppCompatActivity {

    Button edit_profile_bt;
    TextView name_et, number_et, email_et, password_et;
    String email = null, name, number, email_u, password;
    String id;

    DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        dbHelper = new DataBaseHelper(this);

        edit_profile_bt = findViewById(R.id.edit_profile_bt);

        name_et = findViewById(R.id.name_et);
        number_et = findViewById(R.id.number_et);
        email_et = findViewById(R.id.email_et);
        password_et = findViewById(R.id.password_et);

        email = SharedPreferencesHelper.retriveData(this,"UserEmail");

        if (email != null){
            setDataInUserProfile(email);
        }
        else {
            Toast.makeText(UserProfile.this, "User not found", Toast.LENGTH_LONG).show();
        }

        edit_profile_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = name_et.getText().toString();
                number = number_et.getText().toString();
                email_u = email_et.getText().toString();
                password = password_et.getText().toString();
                popupWindow();
            }
        });
    }

    private void popupWindow() {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.edit_user_profile, null);

        Button update_profile_bt;
        EditText up_name_et, up_number_et, up_email_et, up_password_et;

        update_profile_bt = popupView.findViewById(R.id.update_profile_bt);

        up_name_et = popupView.findViewById(R.id.up_name_et);
        up_number_et = popupView.findViewById(R.id.up_number_et);
        up_email_et = popupView.findViewById(R.id.up_email_et);
        up_password_et = popupView.findViewById(R.id.up_password_et);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        up_name_et.setText(name);
        up_number_et.setText(number);
        up_email_et.setText(email_u);
        up_password_et.setText(password);

        update_profile_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_et_u = up_name_et.getText().toString();
                String number_et_u = up_number_et.getText().toString();
                String email_et_u = up_email_et.getText().toString();
                String pass_et_u = up_password_et.getText().toString();

                Boolean updateDate = dbHelper.updateUserRegistrationData(id,name_et_u, number_et_u, email_et_u,pass_et_u);
                if (updateDate){
                    SharedPreferencesHelper.deleteData(UserProfile.this,"UserEmail");
                    SharedPreferencesHelper.insertData(UserProfile.this,"UserEmail", email_et_u);
                    Toast.makeText(UserProfile.this, "User data updated", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(UserProfile.this, "User data not updated", Toast.LENGTH_LONG).show();
                }

                if (email != null){
                    setDataInUserProfile(email_et_u);
                }
                popupWindow.dismiss();
            }
        });
    }

    public void setDataInUserProfile(String new_email){
        Cursor cursor = dbHelper.getDataByEmail(new_email);
        if (cursor.getCount() == 0){
            Toast.makeText(UserProfile.this, "Data Not Found", Toast.LENGTH_LONG).show();
            return;
        }

        else {
            while (cursor.moveToNext()){
                id = cursor.getString(0);
                name_et.setText(new StringBuilder().append(cursor.getString(1)));
                number_et.setText(new StringBuilder().append(cursor.getString(2)));
                email_et.setText(new StringBuilder().append(cursor.getString(3)));
                password_et.setText(new StringBuilder().append(cursor.getString(4)));
            }
        }
    }
}