package com.ofal.ihsan.absensiegs.view.activity;

import android.os.Bundle;
import com.ofal.ihsan.absensiegs.R;
import com.ofal.ihsan.absensiegs.view.base.NoActionBarConfig;
import com.ofal.ihsan.absensiegs.view.base.NormalActivity;

public class LoginActivity extends NormalActivity {

    @Override
    protected int getActivityView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NoActionBarConfig noActionBarConfig = new NoActionBarConfig();
        noActionBarConfig.fullScreen(this);
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }
}
