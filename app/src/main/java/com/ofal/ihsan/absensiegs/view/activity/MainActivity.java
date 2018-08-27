package com.ofal.ihsan.absensiegs.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.ofal.ihsan.absensiegs.R;
import com.ofal.ihsan.absensiegs.view.activity.barcode.BarcodeCaptureActivity;
import com.ofal.ihsan.absensiegs.view.base.NormalActivity;

import javax.sql.CommonDataSource;

import butterknife.BindView;
import butterknife.OnClick;
import lombok.val;

public class MainActivity extends NormalActivity {

    @BindView(R.id.txt_nama)
    TextView txtNama;
    @BindView(R.id.txt_jabatan)
    TextView txtJabatan;
    @BindView(R.id.txt_logout)
    TextView txtLogout;
    @BindView(R.id.result)
    TextView result;
    private int BARCODE_READER_REQUEST_CODE = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected int getActivityView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @OnClick({R.id.cv_profile, R.id.cv_history, R.id.cv_absen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cv_profile:
                break;
            case R.id.cv_history:
                break;
            case R.id.cv_absen:
                Intent intent = new Intent(getApplicationContext(), BarcodeCaptureActivity.class);
                startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BARCODE_READER_REQUEST_CODE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    result.setText(barcode.displayValue);
                } else {
                    result.setText(R.string.no_barcode_captured);
                }
            } else {
                Log.e(LOG_TAG, String.format(getString(R.string.barcode_error_format),
                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
