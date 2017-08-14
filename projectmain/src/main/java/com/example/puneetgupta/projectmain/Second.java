package com.example.puneetgupta.projectmain;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    Button b3,b4;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b3 = (Button)findViewById(R.id.button4);
        b4 = (Button)findViewById(R.id.button5);
        e1 = (EditText)findViewById(R.id.editText4);
        e2 = (EditText)findViewById(R.id.editText5);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.equals("")||s2.equals("")){
                    Toast.makeText(Second.this, "Fill All", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data = openOrCreateDatabase("login",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists student (name varchar,password varchar,email varchar)");
                    String s3 = "select * from student where name = '"+s1+"' and password ='"+s2+"'";
                    Cursor curs = data.rawQuery(s3,null);
                    if(curs.getCount()>0){
                        Toast.makeText(Second.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent i3 = new Intent(Second.this,Third.class);
                        startActivity(i3);
                        finish();
                    }
                    else{
                        Toast.makeText(Second.this, "Invalid User", Toast.LENGTH_SHORT).show();
                        e2.setText("");
                    }
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Second.this,MainActivity.class);
                startActivity(i2);
                finish();
            }
        });
    }
}
