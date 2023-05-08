package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnFollow = (Button)this.findViewById(R.id.btnFollow);
        btnFollow.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                if (User.followed) {
                    User.followed = false;
                    btnFollow.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                else {
                    User.followed = true;
                    btnFollow.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent receive = getIntent();
        String message = receive.getStringExtra("num");
        TextView name = (TextView)this.findViewById(R.id.editTextPersonName);
        name.setText("MAD " + message);
    }


}