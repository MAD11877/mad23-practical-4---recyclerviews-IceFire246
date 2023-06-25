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

    private String numName;
    private String numDesc;
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
                String num = numName;

                Intent Main = new Intent(ListActivity.this, MainActivity.class);
                Main.putExtra("num", num);
                startActivity(Main);
            }
        });

        ArrayList<User> userList = new ArrayList<>();


        for (int i = 0; i < 20; i++) {
            Random r = new Random();
            numName = Integer.toString(r.nextInt());
            numDesc = Integer.toString(r.nextInt());
            boolean follow = r.nextBoolean();

            User u = new User(numName, numDesc, follow);
            userList.add(u);
        }

        class UserViewHolder extends RecyclerView.ViewHolder {
            View view;
            public UserViewHolder(View itemView) {
                super(itemView);
                view = itemView;
            }

            public void setName(String name){
                TextView mName = view.findViewById(R.id.name);
                mName.setText("Name" + name);
            }

            public void setDesc(String desc){
                TextView mDesc = view.findViewById(R.id.description);
                mDesc.setText("Description " + desc);
            }
        }

        class UserAdapter extends
                RecyclerView.Adapter<UserViewHolder>{
            ArrayList<User> data;
            public UserAdapter(ArrayList<User> input) {
                data = input;
            }
            public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View item = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_layout,
                        parent,
                        false);
                return new UserViewHolder(item);
            }
            public void onBindViewHolder(UserViewHolder holder, int position) {
                User u = data.get(position);
                holder.setName(u.name);
                holder.setDesc(u.description);

                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                });
            }
            public int getItemCount() {
                return data.size();
            }
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserAdapter mAdapter = new UserAdapter(userList);
        LinearLayoutManager mLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



    }
}