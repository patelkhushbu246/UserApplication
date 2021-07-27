package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText fname_edt, lname_edt, email_edt, uname_edt, pass_edt, cpass_edt;
    RadioGroup rbg;
    RadioButton malerb,femalerb;
    Spinner utype_spinner;
    TextView hobbies_tv;
    CheckBox movies_check,music_check,travelling_check;
    Button signupbtn;
    DBHelper db;

    String[] usertype={"Admin","User"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db=new DBHelper(this);
        fname_edt = (EditText) findViewById(R.id.et_fn);
        lname_edt = (EditText) findViewById(R.id.et_ln);
        email_edt = (EditText) findViewById(R.id.et_email);
        uname_edt = (EditText) findViewById(R.id.et_un);
        pass_edt = (EditText) findViewById(R.id.et_pass);
        cpass_edt = (EditText) findViewById(R.id.et_cpass);
        rbg = (RadioGroup) findViewById(R.id.rg_gender);
        utype_spinner = (Spinner) findViewById(R.id.sp_ut);
        hobbies_tv = (TextView) findViewById(R.id.tv_hobbies);
        movies_check = (CheckBox) findViewById(R.id.cb_movie);
        music_check = (CheckBox) findViewById(R.id.cb_music);
        travelling_check = (CheckBox) findViewById(R.id.cb_travel);
        signupbtn = (Button) findViewById(R.id.btn_signup_registration);

        malerb = (RadioButton) findViewById(R.id.rb_male);
        femalerb = (RadioButton) findViewById(R.id.rb_female);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, usertype);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        utype_spinner.setAdapter(adapter);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname=fname_edt.getText().toString().trim();
                String lname=lname_edt.getText().toString().trim();
                String email=email_edt.getText().toString().trim();
                String uname=uname_edt.getText().toString().trim();
                String pwd=pass_edt.getText().toString().trim();
                String cpwd=cpass_edt.getText().toString().trim();
                RadioButton checkid=findViewById(rbg.getCheckedRadioButtonId());
                String gender = checkid.getText().toString().trim();
                String usertype=utype_spinner.getItemAtPosition(utype_spinner.getSelectedItemPosition()).toString().trim();
                StringBuffer sb=new StringBuffer();
                String hobby1 = movies_check.getText().toString().trim();
                String hobby2 = music_check.getText().toString().trim();
                String hobby3=travelling_check.getText().toString().trim();
                if (movies_check.isSelected()) {
                    sb.append(hobby1);
                }
                if (music_check.isSelected()) {
                    sb.append(hobby2);
                }
                if (travelling_check.isSelected()) {
                    sb.append(hobby3);
                }

                if(pwd.equals(cpwd)){
                    db.adduser(fname,lname,email,uname,pwd,gender,usertype,hobby1,hobby2,hobby3);
                    Toast.makeText(RegistrationActivity.this, "You have signup", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(RegistrationActivity.this,LoginActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(RegistrationActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}