package com.example.room_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.room_sqlite.Adapter.UserAdapter;
import com.example.room_sqlite.Database.UserDatabase;
import com.example.room_sqlite.Model.User;

import java.util.List;


public class    MainActivity extends AppCompatActivity {
    
    //jay ghori

    String TAG="MY TAGAR";
    RecyclerView recyclerView;
    EditText edtName,edtSalary,edtComapny;
    Button btnAdd,btnGet;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.btnAdd);
        edtSalary=findViewById(R.id.edtsalary);
        edtName=findViewById(R.id.edtName);
        edtComapny=findViewById(R.id.edtCompany);
        btnGet=findViewById(R.id.btnGet);

        recyclerView=findViewById(R.id.recyclerView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=edtName.getText().toString();
                String salary=edtSalary.getText().toString();
                String company=edtComapny.getText().toString();

               User user=new  User(name,salary,company);

                   Thread thread=new Thread(){
                       @Override
                       public void run() {
                           super.run();
//                           UserDatabase.getInstance(MainActivity.this).userDao().deleteUserById(3);
                           UserDatabase.getInstance(MainActivity.this).userDao().insertData(user);


                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   Toast.makeText(MainActivity.this, "Inserted succesfully", Toast.LENGTH_SHORT).show();

                               }
                           });
                       }
                   };
                   thread.start();


            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread thread=new Thread(){
                    @Override
                    public void run() {
                        super.run();

                       List<User> userList= UserDatabase.getInstance(MainActivity.this).userDao().getAllUser();

                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {

                               UserAdapter userAdapter=new UserAdapter(userList, MainActivity.this);
                               recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                               recyclerView.setAdapter(userAdapter);
                           }
                       });


                    }
                };
                thread.start();
            }
        });

    }
}