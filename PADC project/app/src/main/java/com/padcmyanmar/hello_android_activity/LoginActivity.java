package com.padcmyanmar.hello_android_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Daewi on 11/10/2017.
 */

public class LoginActivity extends AppCompatActivity {
    public static Intent newIntent(Context context){
        Intent intent=new Intent(context,LoginActivity.class);
        return intent;

    }

    private  static final  String CORRECT_EMAIL="abc@gmail.com";
    private static final  String CORRECT_PASSWORD="Abcdefg";//Constant Attributes

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgetPssword;
    private TextView btnToRegister;
//
//    String s = null;
//    String s1 = "" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        if ( s == null) {
//
//        }
//
//        if  (TextUtils.isEmpty(s)){
//
//        }

       btnLogin= findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailOrPhone=etEmailOrPhone.getText().toString();
                String password=etPassword.getText().toString();
                if(TextUtils.isEmpty(emailOrPhone)){
                    etEmailOrPhone.setError("Email or phone cannot be empty.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password cannot empty");
                    return;
                }

                if(TextUtils.equals(emailOrPhone,CORRECT_EMAIL)&& TextUtils.equals(password,CORRECT_PASSWORD)){
                   // Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();

                   Intent intent= HelloAndroidAcivity.newIntent(getApplicationContext());
                startActivity(intent);}
                    else{
                        Snackbar.make(view,"Incorrect Email Or Password Please Try Again",Snackbar.LENGTH_INDEFINITE).show();
                    }

                }

                //Snackbar.make(view, "button clicked",Snackbar.LENGTH_INDEFINITE).show();


        });

       etEmailOrPhone=findViewById(R.id.et_email_or_phone);
      etPassword=findViewById(R.id.et_password);

      btnForgetPssword=findViewById(R.id.btn_forget_password);
      btnForgetPssword.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Snackbar.make(view,"Forgot Password is coming soon",Snackbar.LENGTH_INDEFINITE).show();
          }
      });


        btnToRegister=findViewById(R.id.tv_new_seller_register);
        btnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = RegisterActivity.newIntent(getApplicationContext());
                startActivity(intent);

                //finish();
                //Snackbar.make(view,"Registration is coming soon",Snackbar.LENGTH_INDEFINITE).show();

            }
        });





    }

}

