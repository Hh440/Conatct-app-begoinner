package com.company.contact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btncreate;
    ImageView ivphone,ivloc,ivmood,ivweb;
    final int ACTIVITY=1;
    String name="",number="",map="",web="",mood="";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ACTIVITY){
            if (resultCode==RESULT_OK){
                ivphone.setVisibility(View.VISIBLE);
            ivmood.setVisibility(View.VISIBLE);
            ivloc.setVisibility(View.VISIBLE);
            ivweb.setVisibility(View.VISIBLE);
            name=data.getStringExtra("name");
            number=data.getStringExtra("number");
            web=data.getStringExtra("website");
            map=data.getStringExtra("location");
            mood=data.getStringExtra("mood");
            if(mood.equals("happy")){
                ivmood.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_24);
            }else if(mood.equals("ok")){
                ivmood.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24);
            }
            else{
                ivmood.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
            }

        }else{
                Toast.makeText(this, "No data passed through", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivphone=findViewById(R.id.ivphone);
        ivmood=findViewById(R.id.ivmood);
        ivweb=findViewById(R.id.ivwebsite);
        ivloc=findViewById(R.id.ivloc);
        btncreate=findViewById(R.id.btncreate);
        ivphone.setVisibility(View.GONE);
        ivmood.setVisibility(View.GONE);
        ivloc.setVisibility(View.GONE);
        ivweb.setVisibility(View.GONE);
        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,com.company.contact.Activity2.class);
                startActivityForResult(intent,ACTIVITY);

            }
        });
        ivphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);

            }
        });

        ivloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+map));
                startActivity(intent);
            }
        });
        ivweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent);
            }
        });


    }
}