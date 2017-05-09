package com.example.administrator.ying.Fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.ying.R;
import com.example.administrator.ying.zxing.app.CaptureActivity;

/**
 * Created by Administrator on 2017/5/6.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener{

    private static final int REQUEST_QRCODE = 0x01;
    protected Activity mContext;
    private TextView mQRCodeView;
    private View mContentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_home_layout, container, false);
        initView();
        return mContentView;
    }
    private void initView() {
        mQRCodeView = (TextView) mContentView.findViewById(R.id.qrcode_view);
        mQRCodeView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qrcode_view:
                Intent inter = new Intent(mContext, CaptureActivity.class);
                startActivityForResult(inter, REQUEST_QRCODE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            //扫码处理逻辑
            case REQUEST_QRCODE:
                if (resultCode == Activity.RESULT_OK) {
                    String code = data.getStringExtra("SCAN_RESULT");
                }
                break;
        }
    }
}


