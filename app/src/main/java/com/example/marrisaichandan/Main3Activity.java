package com.example.marrisaichandan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdsmdg.harjot.longshadows.LongShadowsImageView;

public class Main3Activity extends AppCompatActivity {

    TextView t;
    Button b1;
    String img;
    SharedPreferences sp,sp1;
    LongShadowsImageView shadow;
    ImageView im,im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        if (Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

        showdialogbox();
        sp = getSharedPreferences("mainselection", Context.MODE_PRIVATE);
        img = sp.getString("img","NA");


        im = findViewById(R.id.imageView8);
        im1 = findViewById(R.id.imageView9);
        b1 = findViewById(R.id.button);
        shadow = findViewById(R.id.shadow);

        if (img.equals("1")){
            shadow.setImageResource(R.drawable.toolbar1);
        }
        else if (img.equals("2")){
            shadow.setImageResource(R.drawable.toolbar2);
            im.setImageResource(R.drawable.sheet11);
            im1.setVisibility(View.GONE);
        }
        else if (img.equals("3")){
            shadow.setImageResource(R.drawable.toolbar3);
            im.setImageResource(R.drawable.sheet31);
            im1.setVisibility(View.GONE);
        }
        else{
            shadow.setImageResource(R.drawable.toolbar4);
            im.setImageResource(R.drawable.sheet21);
            im1.setVisibility(View.GONE);
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(i);
                finish();
            }
        });

        sp1 = getSharedPreferences("mainselection", Context.MODE_PRIVATE);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img.equals("1")){
                    if (!isNetworkConnected()){
                        showdialogbox();
                    }
                    else{
                        Intent i = new Intent(Main3Activity.this,ChatPage.class);
                        SharedPreferences.Editor edit = sp1.edit();
                        edit.putString("img","1");
                        edit.putString("imgsub","a");
                        edit.commit();
                        startActivity(i);
                    }

                }
                else if (img.equals("2")){
                    if (!isNetworkConnected()){
                        showdialogbox();
                    }
                    else{
                        Intent i = new Intent(Main3Activity.this,ChatPage.class);
                        SharedPreferences.Editor edit = sp1.edit();
                        edit.putString("img","2");
                        edit.putString("imgsub","a");
                        edit.commit();
                        startActivity(i);
                    }

                }
                else if (img.equals("3")){
                    if (!isNetworkConnected()){
                        showdialogbox();
                    }
                    else{
                        Intent i = new Intent(Main3Activity.this,ChatPage.class);
                        SharedPreferences.Editor edit = sp1.edit();
                        edit.putString("img","3");
                        edit.putString("imgsub","a");
                        edit.commit();
                        startActivity(i);
                    }

                }
                else {
                    if (!isNetworkConnected()){
                        showdialogbox();
                    }
                    else{
                        Intent i = new Intent(Main3Activity.this,ChatPage.class);
                        SharedPreferences.Editor edit = sp1.edit();
                        edit.putString("img","4");
                        edit.putString("imgsub","a");
                        edit.commit();
                        startActivity(i);
                    }

                }
            }
        });

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img.equals("1")){
                    if (!isNetworkConnected()){
                        showdialogbox();
                    }
                    else{
                        Intent i = new Intent(Main3Activity.this,ChatPage.class);
                        SharedPreferences.Editor edit = sp1.edit();
                        edit.putString("img","1");
                        edit.putString("imgsub","b");
                        edit.commit();
                        startActivity(i);
                    }

                }
                else if (img.equals("2")){
                    if (!isNetworkConnected()){
                        showdialogbox();
                    }
                    else{
                        Intent i = new Intent(Main3Activity.this,ChatPage.class);
                        SharedPreferences.Editor edit = sp1.edit();
                        edit.putString("img","2");
                        edit.putString("imgsub","b");
                        edit.commit();
                        startActivity(i);
                    }

                }
                else if (img.equals("3")){
                    if (!isNetworkConnected()){
                        showdialogbox();
                    }
                    else{
                        Intent i = new Intent(Main3Activity.this,ChatPage.class);
                        SharedPreferences.Editor edit = sp1.edit();
                        edit.putString("img","3");
                        edit.putString("imgsub","b");
                        edit.commit();
                        startActivity(i);
                    }

                }
                else {
                    if (!isNetworkConnected()){
                        showdialogbox();
                    }
                    else{
                        Intent i = new Intent(Main3Activity.this,ChatPage.class);
                        SharedPreferences.Editor edit = sp1.edit();
                        edit.putString("img","4");
                        edit.putString("imgsub","b");
                        edit.commit();
                        startActivity(i);
                    }

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
