package com.rdc.rdcwelcome.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rdc.rdcwelcome.R;
import com.rdc.rdcwelcome.utils.CommonUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonUtil.hideStatusBar(this,this,true);
        setContentView(R.layout.activity_main);
    }
}
