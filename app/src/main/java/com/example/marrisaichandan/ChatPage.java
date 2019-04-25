package com.example.marrisaichandan;

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
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.harjot.longshadows.LongShadowsImageView;

import java.util.ArrayList;
import java.util.List;


public class ChatPage extends AppCompatActivity {

    Button b1,b2;
    EditText e;
    String img,imgsub;
    ConstraintLayout rl;
    SharedPreferences sp;
    LongShadowsImageView shadow;
    ListView listView;
    int select = 0;
    ViewPager viewPager;
    ConstraintLayout cl;
    TextView rece,send;
    int count = 0;
    String[] common = {"the","of","and","a","to","in","is","you","that","it","he","was","for","on","are","as","with","his","they","I","at","be","this","have","from","or","one","had","by","word","but","not","what","all","were","we","when","your","can","said","there","use","an","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them","these","so","some","her","would","make","like","him","into","time","has","look","two","more","write","go","see","number","no","way","could","people","my","than","first","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part"};


    List<ChatBubble> chatBubbles;
    ArrayAdapter<ChatBubble> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);
        rl = findViewById(R.id.layout);
        rece = findViewById(R.id.receiver);
        send = findViewById(R.id.sender);



        showdialogbox();
        listView = findViewById(R.id.listview);
        listView.setSmoothScrollbarEnabled(true);

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"list",Toast.LENGTH_SHORT).show();
                if (!isNetworkConnected()){
                    showdialogbox();
                }
                else {
                    loopchater();
                }
            }
        });

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"layout",Toast.LENGTH_SHORT).show();
                if (!isNetworkConnected()){
                    showdialogbox();
                }
                else {
                        loopchater();
                    }
            }
        });



    }


    public void loopchater(){
        if (select == 0)
            select = 0;
        else if (select == 1)
            select = 1;
        else if (select == 2)
            select = 2;
        else if (select == 3)
            select = 3;
        else
            select = 4;
        ChatBubble Chatbubble = new ChatBubble(common[count],select);
        chatBubbles.add(Chatbubble);
        adapter.notifyDataSetChanged();
        e.setText("");
        count++;
        if (select == 4)
            select = 0;
        else
            select++;
    }


    public void imageretrive(){
        if (imgsub.equals("a")){
            if (img.equals("1")){
                shadow.setImageResource(R.drawable.cat11);
                rl.setBackgroundResource(R.drawable.emo1);
                rece.setText("Sonia");
                send.setText("Mum");
            }
            else if (img.equals("2")){
                shadow.setImageResource(R.drawable.cat21);
                rl.setBackgroundResource(R.drawable.fun);
                rece.setText("Sunidhi");
                send.setText("Aashi");
            }
            else if (img.equals("3")){
                shadow.setImageResource(R.drawable.cat31);
                rl.setBackgroundResource(R.drawable.anna);
                rece.setText("Vijay");
                send.setText("Doctor");
            }
            else{
                shadow.setImageResource(R.drawable.cat41);
                rl.setBackgroundResource(R.drawable.romance);
                rece.setText("Sameer");
                send.setText("Simran");
            }
        }
        else{
            if (img.equals("1")){
                shadow.setImageResource(R.drawable.cat12);
                rl.setBackgroundResource(R.drawable.emo2);
                rece.setText("Mahira");
                send.setText("Rehan");
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
