package com.ofal.ihsan.absensiegs.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ofal.ihsan.absensiegs.R;
import com.ofal.ihsan.absensiegs.view.base.NormalActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends NormalActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;

    @Override
    protected int getActivityView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @OnClick({R.id.btn_login, R.id.btn_createpass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_createpass:
                startActivity(new Intent(getApplicationContext(), CreatePasswordActivity.class));
                break;
        }
    }

    private void login() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
