package com.ldxx.gmvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ldxx.gmvvm.app.GMVVMApplication;
import com.ldxx.gmvvm.bean.User;
import com.ldxx.gmvvm.db.UserDao;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etAge;
    private TextView tvTotal;
    //private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        UserDao dao = GMVVMApplication.getContext().getUserDao();
        tvTotal.setText("共：" + dao.queryBuilder().build().list().size() + "人");

    }

    private void initView() {
        etUserName = findViewById(R.id.et_user_name);
        etAge = findViewById(R.id.et_age);
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDao dao = GMVVMApplication.getContext().getUserDao();
                User user = new User();
                user.setId(UUID.randomUUID().toString());
                user.setName(etUserName.getText().toString());
                user.setAge(etAge.getText().toString());

                dao.insert(user);

            }
        });
        tvTotal = (TextView) findViewById(R.id.tv_total);
    }
}
