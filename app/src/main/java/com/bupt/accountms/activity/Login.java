package com.bupt.accountms.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bupt.accountms.R;
import com.bupt.accountms.dao.PwdDAO;

/**
 * Created by ZhaoJie1234 on 2016/7/31.
 */
public class Login extends Activity {
    private EditText txtlogin;
    private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        txtlogin =(EditText)findViewById(R.id.txtLogin);
        btnlogin =(Button)findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                PwdDAO pwdDAO = new PwdDAO(Login.this);
            }
        });
    }
}
