package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){

            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Random r = new Random();
                String num = Integer.toString(r.nextInt());

                Intent Main = new Intent(ListActivity.this, MainActivity.class);
                Main.putExtra("num", num);
                startActivity(Main);
            }
        });

        ImageView icon = (ImageView) this.findViewById(R.id.imgIcon);
        icon.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }
}