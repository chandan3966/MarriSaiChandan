package com.example.marrisaichandan;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {

    ImageView im1, im2, im3, im4;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

        sp = getSharedPreferences("mainselection", Context.MODE_PRIVATE);

        im1 = findViewById(R.id.imageView4);
        im2 = findViewById(R.id.imageView5);
        im3 = findViewById(R.id.imageView6);
        im4 = findViewById(R.id.imageView7);

        showdialogbox();

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNetworkConnected()){
                    showdialogbox();
                }
                else{
                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("img", "1");
                    edit.commit();
                    startActivity(i);
                }

            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNetworkConnected()){
                    showdialogbox();
                }
                else{
                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("img", "2");
                    edit.commit();
                    startActivity(i);
                }
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNetworkConnected()){
                    showdialogbox();
                }
                else{
                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("img", "3");
                    edit.commit();
                    startActivity(i);
                }

            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNetworkConnected()){
                    showdialogbox();
                }
                else{
                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("img", "4");
                    edit.commit();
                    startActivity(i);
                }

            }
        });
    }

    public void showdialogbox() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.dialog, null);
        Button confirmed = view.findViewById(R.id.button3);
        final AlertDialog alertDialog = new AlertDialog.Builder(this).setView(view).create();
        if (!isNetworkConnected()){
            alertDialog.show();
        }
        else {
            alertDialog.dismiss();
        }

        confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNetworkConnected()){
                    alertDialog.show();
                }
                else {
                    alertDialog.dismiss();
                }
            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
