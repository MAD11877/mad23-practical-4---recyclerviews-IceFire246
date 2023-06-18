package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
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

        ArrayList<User> userList = new ArrayList<>();


        for (int i = 0; i < 20; i++) {
            Random r = new Random();
            String numName = "Name" + r.nextInt();
            String numDesc = "Description "+ r.nextInt();
            boolean follow = r.nextBoolean();

            User u = new User(numName, numDesc, follow);
            userList.add(u);
        }

        class UserViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            TextView desc;
            ImageView img;
            public UserViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(android.R.id.text1);
                desc = itemView.findViewById(android.R.id.text2);
                img = itemView.findViewById(android.R.id.icon);
            }
        }

        class UserAdapter extends
                RecyclerView.Adapter<UserViewHolder>{
            ArrayList<User> data;
            public UserAdapter(ArrayList<User> input) {
                data = input;
            }
            public UserViewHolder onCreateViewHolder(
                    ViewGroup parent,
                    int viewType) {
                View item = LayoutInflater.from(parent.getContext()).inflate(
                        android.R.layout.simple_list_item_1,
                        parent,
                        false);
                return new UserViewHolder(item);
            }
            public void onBindViewHolder(
                    UserViewHolder holder,
                    int position) {
                User u = data.get(position);
                holder.name.setText(u.name);
                holder.desc.setText(u.description);
                holder.itemView.findViewById(R.id.mipmap_ic_launcher_round);
            }
            public int getItemCount() {
                return data.size();
            }
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        UserAdapter mAdapter = new UserAdapter(userList);
        LinearLayoutManager mLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        recyclerView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }
}