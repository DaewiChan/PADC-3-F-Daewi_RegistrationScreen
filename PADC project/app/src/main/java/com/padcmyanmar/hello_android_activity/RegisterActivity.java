package com.padcmyanmar.hello_android_activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    public static Intent newIntent(Context context){
        Intent intent=new Intent(context,RegisterActivity.class);
        return intent;
    }

    private TextView tvRegisterToLogin;
    private EditText etRegisterName,etRegisterPhone,etRegisterEmail,etRegisterPassword,etRegisterConfirmPassword,etRegisterAddress;
    private Button btnRegister;
    private RadioGroup radioGroup;
    private CheckBox chkRegister;
    private RadioButton rb=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvRegisterToLogin=findViewById(R.id.tv_register_to_login);
        etRegisterName = findViewById(R.id.et_register_name);
        etRegisterPhone = findViewById(R.id.et_register_phone);
        etRegisterEmail=findViewById(R.id.et_register_email);
        etRegisterPassword=findViewById(R.id.et_register_password);
        etRegisterConfirmPassword=findViewById(R.id.et_register_confirm_password);
        etRegisterAddress=findViewById(R.id.et_register_address);


        tvRegisterToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=LoginActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              String registerName=etRegisterName.getText().toString();
              String registerPhone=etRegisterPhone.getText().toString();
              String registerEmail=etRegisterEmail.getText().toString();
              String registerPassword=etRegisterPassword.getText().toString();
              String registerConfirmPassword =etRegisterConfirmPassword.getText().toString();
              String registerAddress=etRegisterAddress.getText().toString();

              if(TextUtils.isEmpty(registerName)){
                  etRegisterName.setError("Name cannot be empty");
                  return;
              }

              if(TextUtils.isEmpty(registerPhone)){
                  etRegisterPhone.setError("Phone cannot be empty");
                  return;
              }

              if(TextUtils.isEmpty(registerEmail)){
                  etRegisterEmail.setError("Email cannot be empty");
                  return;
              }

              if(TextUtils.isEmpty(registerPassword)){
                  etRegisterPassword.setError("Password cannot be empty");
                  return;
              }

              if(TextUtils.isEmpty(registerConfirmPassword)){
                  etRegisterConfirmPassword.setError("Confirm password cannot be empty");
                  return;
              }
              if(TextUtils.isEmpty(registerAddress)){
                  etRegisterAddress.setError("Address cannot be empty");
                  return;
              }

                if(rb == null){
                    Toast.makeText(getApplicationContext(),"Please choose gender !!",Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(getApplicationContext(),"Registration Success",Toast.LENGTH_SHORT).show();
                //Snackbar.make(view,"Registration Success",Snackbar.LENGTH_INDEFINITE).show();

                //Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                //startActivity(intent);

                finish();//close current screen
            }
        });





        radioGroup=findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {

                 rb= radioGroup.findViewById(checkId);

                if(null !=rb && checkId>-1){
                    Toast.makeText(getApplicationContext(),rb.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        chkRegister=findViewById(R.id.chk_register);
        chkRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(((CheckBox) view).isChecked()){
                    String msg = getResources().getString(R.string.check_register);
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
