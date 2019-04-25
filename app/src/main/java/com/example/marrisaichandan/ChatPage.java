package com.example.marrisaichandan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.sdsmdg.harjot.longshadows.LongShadowsImageView;

import java.util.ArrayList;
import java.util.List;

public class ChatPage extends AppCompatActivity {

    Button b1,b2;
    EditText e;
    String img,imgsub;
    SharedPreferences sp;
    LongShadowsImageView shadow;
    ListView listView;
    int select = 0;
    ViewPager viewPager;
    ConstraintLayout cl;


    List<ChatBubble> chatBubbles;
    ArrayAdapter<ChatBubble> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);

        showdialogbox();
        listView = findViewById(R.id.listview);

        cl = findViewById(R.id.constraintLayout);

        e = findViewById(R.id.editText);
        b2 = findViewById(R.id.button2);
        chatBubbles = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
            listView.setDividerHeight(-1);
        }
        adapter = new MessageAdapter(this,R.layout.leftchat,chatBubbles);
        listView.setAdapter(adapter);

        sp = getSharedPreferences("mainselection", Context.MODE_PRIVATE);
        img = sp.getString("img","NA");
        imgsub = sp.getString("imgsub","NA");
        b1 = findViewById(R.id.button);
        shadow = findViewById(R.id.shadow);

       imageretrive();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(ChatPage.this,Main3Activity.class);
                startActivity(i);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!isNetworkConnected()){
                    showdialogbox();
                }
                else {
                    if(e.getText().toString().length()<1){
                        Toast.makeText(getApplicationContext(),"please enter",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (select == 0)
                            select++;
                        else
                            select--;
                        ChatBubble Chatbubble = new ChatBubble(e.getText().toString(),select);
                        chatBubbles.add(Chatbubble);
                        adapter.notifyDataSetChanged();
                        e.setText("");
                    }
                }
                return true;
            }
        });

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNetworkConnected()){
                    showdialogbox();
                }
                else {
                    if(e.getText().toString().length()<1){
                        Toast.makeText(getApplicationContext(),"please enter",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (select == 0)
                            select++;
                        else
                            select--;
                        ChatBubble Chatbubble = new ChatBubble(e.getText().toString(),select);
                        chatBubbles.add(Chatbubble);
                        adapter.notifyDataSetChanged();
                        e.setText("");
                    }
                }
            }
        });



    }




    public void imageretrive(){
        if (imgsub.equals("a")){
            if (img.equals("1")){
                shadow.setImageResource(R.drawable.cat11);
            }
            else if (img.equals("2")){
                shadow.setImageResource(R.drawable.cat21);
            }
            else if (img.equals("3")){
                shadow.setImageResource(R.drawable.cat31);
            }
            else{
                shadow.setImageResource(R.drawable.cat41);
            }
        }
        else{
            if (img.equals("1")){
                shadow.setImageResource(R.drawable.cat21);
            }
            else if (img.equals("2")){
//            shadow.setImageResource(R.drawable.cat21);
            }
            else if (img.equals("3")){
//            shadow.setImageResource(R.drawable.cat31);
            }
            else{
//            shadow.setImageResource(R.drawable.cat41);
            }
        }
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
