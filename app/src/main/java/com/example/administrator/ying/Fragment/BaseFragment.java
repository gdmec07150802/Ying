package com.example.administrator.ying.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;


public class BaseFragment extends Fragment {

    protected Activity mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void doOpenCamera() {

    }

    public void doWriteSDCard() {

    }
}
