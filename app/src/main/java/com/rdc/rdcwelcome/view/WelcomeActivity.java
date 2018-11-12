package com.rdc.rdcwelcome.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.rdc.rdcwelcome.R;
import com.rdc.rdcwelcome.utils.CommonUtil;
import com.rdc.rdcwelcome.utils.Typefaces;
import com.rdc.rdcwelcome.widget.Titanic;
import com.rdc.rdcwelcome.widget.TitanicTextView;

/**
 * 引导界面
 */
public class WelcomeActivity extends AppCompatActivity {
    private TitanicTextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonUtil.hideStatusBar(this, this, true);
        setContentView(R.layout.activity_welcome);
        initView();
    }

    private void initView() {
        tv = findViewById(R.id.my_text_view);
        tv.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));

        // 动画开始
        final Titanic titanic = new Titanic();
        titanic.start(tv);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        }, 7000);

    }
}
