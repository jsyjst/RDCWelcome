package com.rdc.rdcwelcome.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
    private  TitanicTextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonUtil.hideStatusBar(this,this,true);
        setContentView(R.layout.activity_welcome);
        initView();
    }
    private void initView(){
        tv = findViewById(R.id.my_text_view);
        tv.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));

        // 动画开始
        final Titanic titanic = new Titanic();
        titanic.start(tv);
        //延迟7秒跳转到主活动
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        }, 7 * 1000);
    }
}
