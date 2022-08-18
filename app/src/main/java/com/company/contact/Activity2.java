package com.company.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener
{
    EditText edtname,edtnum,edtweb,edtloc;
    ImageView picg,picm,pics;


    @Override
    public void onClick(View view) {
        if(edtnum.getText().toString().isEmpty()||edtname.getText().toString().isEmpty()||edtweb.getText().toString().isEmpty()||edtloc.getText().toString().isEmpty()){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent();
            intent.putExtra("name",edtname.getText().toString().trim());
            intent.putExtra("number",edtnum.getText().toString().trim());
            intent.putExtra("location",edtloc.getText().toString().trim());
            intent.putExtra("website",edtweb.getText().toString().trim());

        if(view.getId()==R.id.pichappy){
            intent.putExtra("mood","happy");

        }else if(view.getId()==R.id.picmoderate){
            intent.putExtra("mood","ok");

        }else{
            intent.putExtra("mood","sad");

        }
        setResult(RESULT_OK,intent);
        Activity2.this.finish();
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        edtname = findViewById(R.id.edtName);
        edtnum = findViewById(R.id.edtNumber);
        edtweb = findViewById(R.id.edtweb);
        edtloc = findViewById(R.id.editloaction);
        picg = findViewById(R.id.pichappy);
        picm = findViewById(R.id.picmoderate);
        pics = findViewById(R.id.picsad);
        pics.setOnClickListener(this);
        picm.setOnClickListener(this);
        pics.setOnClickListener(this);


    }

}