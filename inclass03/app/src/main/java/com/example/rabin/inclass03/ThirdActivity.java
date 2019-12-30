package com.example.rabin.inclass03;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
TextView name1;
TextView studentid1;
TextView department1;
Button edit;
int img;
ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setTitle("Display My Profile");
        Intent i = getIntent();
        img = i.getIntExtra("img",0);
        final String name = i.getStringExtra("name");
        final int studentid = i.getIntExtra("studentid",0);
        final String department = i.getStringExtra("department");
        edit=(Button)findViewById(R.id.b_edit);
        name1=(TextView)findViewById(R.id.tv_name);
        studentid1=(TextView)findViewById(R.id.tv_studentid);
        department1=(TextView)findViewById(R.id.tv_department);
        img1=(ImageView)findViewById(R.id.iv_2);
        name1.setText("Name: "+ name);
        studentid1.setText("Student Id: "+ studentid);
        department1.setText("Department: "+ department);
        img1.setImageResource(img);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ThirdActivity.this, MainActivity.class);
                finish();
            }
        });


    }
}
