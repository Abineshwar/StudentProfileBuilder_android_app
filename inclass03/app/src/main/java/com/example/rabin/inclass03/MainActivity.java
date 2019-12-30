

package com.example.rabin.inclass03;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int reqcode = 100;
    ImageView ivselect;
    String f1, l1, r1, nam;
    int sid, resid, flag = 0;
    EditText firstname, lastname, studentid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname = (EditText) findViewById(R.id.et_firstname);
        lastname = (EditText) findViewById(R.id.et_lastname);
        studentid = (EditText) findViewById(R.id.et_studentid);
        final RadioButton rbcs = (RadioButton) findViewById(R.id.rb_cs);
        final RadioButton rbsis = (RadioButton) findViewById(R.id.rb_sis);
        final RadioButton rbbio = (RadioButton) findViewById(R.id.rb_bio);
        final RadioButton rbother = (RadioButton) findViewById(R.id.rb_other);
        Button save = (Button) findViewById(R.id.b_save);

        setTitle("My Profile");
        ivselect = (ImageView) findViewById(R.id.iv_selectimage);
        ivselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, reqcode);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    f1 = firstname.getText().toString();
                    l1 = lastname.getText().toString();
                    sid = Integer.parseInt(studentid.getText().toString());
                    if (flag == 0 || f1.length() == 0 || l1.length() == 0 || studentid.length() < 9) {
                        throw new Exception();
                    }
                    if (rbcs.isChecked())
                        r1 = "CS";
                    else if (rbsis.isChecked())
                        r1 = "SIS";
                    else if (rbbio.isChecked())
                        r1 = "BIO";
                    else if (rbother.isChecked())
                        r1 = "Other";
                    else
                        throw new Exception();

                    Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                    i.putExtra("img", resid);
                    i.putExtra("name", f1 + " " + l1);
                    i.putExtra("studentid", sid);
                    i.putExtra("department", r1);
                    setResult(RESULT_OK, i);
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Enter Valid Input", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == reqcode)
            if (resultCode == RESULT_OK) {
                Bundle b = data.getExtras();
                if (b != null) {
                    resid = b.getInt("img");
                    ivselect.setImageResource(resid);
                    flag = 1;
                }
            }

    }

}
