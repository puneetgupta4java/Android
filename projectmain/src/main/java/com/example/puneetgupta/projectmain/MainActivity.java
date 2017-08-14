package com.example.puneetgupta.projectmain;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(MainActivity.this, "Fill All", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data = openOrCreateDatabase("login",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists student(name varchar,password varchar,email varchar)");
                    String s4 = "select * from student where name='"+s1+"' and password='"+s2+"'";
                    Cursor cursor = data.rawQuery(s4,null);
                    if(cursor.getCount()>0){
                        Toast.makeText(MainActivity.this, "User Exists", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        data.execSQL("insert into student values('"+s1+"','"+s2+"','"+s3+"')");
                        Toast.makeText(MainActivity.this, "database updated", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this,Second.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this,Second.class);
                startActivity(i2);
                finish();
            }
        });
    }
}
