package com.example.rabin.inclass03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivavf1;
    ImageView ivavf2;
    ImageView ivavf3;
    ImageView ivavm1;
    ImageView ivavm2;
    ImageView ivavm3;

    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Select Avatar");

        ivavf1=(ImageView)findViewById(R.id.iv_avatarf1);
        ivavf2=(ImageView)findViewById(R.id.iv_avatarf2);
        ivavf3=(ImageView)findViewById(R.id.iv_avatarf3);
        ivavm1=(ImageView)findViewById(R.id.iv_avatarm1);
        ivavm2=(ImageView)findViewById(R.id.iv_avatarm2);
        ivavm3=(ImageView)findViewById(R.id.iv_avatarm3);


        ivavf1.setOnClickListener(this);
        ivavf2.setOnClickListener(this);
        ivavf3.setOnClickListener(this);
        ivavm1.setOnClickListener(this);
        ivavm2.setOnClickListener(this);
        ivavm3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent();

        switch (v.getId())
        {

            case R.id.iv_avatarf1:
                i.putExtra("img",R.drawable.avatar_f_1);
                setResult(RESULT_OK,i);
                break;
            case R.id.iv_avatarm1:
                i.putExtra("img",R.drawable.avatar_m_1);
                setResult(RESULT_OK,i);
                break;
            case R.id.iv_avatarf2:
                i.putExtra("img",R.drawable.avatar_f_2);
                setResult(RESULT_OK,i);
                break;
            case R.id.iv_avatarm2:
                i.putExtra("img",R.drawable.avatar_m_2);
                setResult(RESULT_OK,i);
                break;
            case R.id.iv_avatarf3:
                i.putExtra("img",R.drawable.avatar_f_3);
                setResult(RESULT_OK,i);
                break;
            case R.id.iv_avatarm3:
                i.putExtra("img",R.drawable.avatar_m_3);
                setResult(RESULT_OK,i);
                break;


        }
        finish();

    }
}
