package com.example.marrisaichandan;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.sdsmdg.harjot.longshadows.LongShadowsImageView;

public class Main3Activity extends AppCompatActivity {

    TextView t;
    Button b1;
    String img;
    LongShadowsImageView shadow;
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
        Bundle b = getIntent().getExtras();
        img = b.getString("img");
        b1 = findViewById(R.id.button);
        shadow = findViewById(R.id.shadow);

        if (b.getString("img").equals("1")){
            shadow.setImageResource(R.drawable.toolbar1);
        }
        else if (b.getString("img").equals("2")){
            shadow.setImageResource(R.drawable.toolbar2);
        }
        else if (b.getString("img").equals("3")){
            shadow.setImageResource(R.drawable.toolbar3);
        }
        else{
            shadow.setImageResource(R.drawable.toolbar4);
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
