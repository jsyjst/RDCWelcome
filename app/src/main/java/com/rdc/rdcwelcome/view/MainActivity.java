package com.rdc.rdcwelcome.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Util;
import com.rdc.rdcwelcome.R;
import com.rdc.rdcwelcome.utils.CommonUtil;
import com.rdc.rdcwelcome.utils.Typefaces;

public class MainActivity extends AppCompatActivity {
    private TextView mWelcomeTv;
    private BoomMenuButton mBmb;
    private TextOutsideCircleButton.Builder mAndroidBuilder,mJavaBuilder,mWebBuilder,mDataBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonUtil.hideStatusBar(this, this, true);
        setContentView(R.layout.activity_main);

        initView();
        initBottom();
    }

    private void initView() {
        mWelcomeTv = findViewById(R.id.tv_welcome);
        mWelcomeTv.setTypeface(Typefaces.get(this, "chinese.ttf"));
        mBmb = findViewById(R.id.bmb);
    }

    private void initBottom() {
        mAndroidBuilder = new TextOutsideCircleButton.Builder();
        mJavaBuilder = new TextOutsideCircleButton.Builder();
        mWebBuilder = new TextOutsideCircleButton.Builder();
        mDataBuilder = new TextOutsideCircleButton.Builder();

        mJavaBuilder.normalImageRes(R.drawable.java)
                .normalText("后台")
                .typeface(Typefaces.get(this, "chinese.ttf"))
                .textSize(15)
                .normalColorRes(R.color.java)
                .listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Toast.makeText(MainActivity.this,"报名后台",Toast.LENGTH_SHORT).show();
            }
        });
        mWebBuilder.normalImageRes(R.drawable.web)
                .normalText("前端").normalColorRes(R.color.web)
                .typeface(Typefaces.get(this, "chinese.ttf"))
                .textSize(15)
                .listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Toast.makeText(MainActivity.this,"报名前端",Toast.LENGTH_SHORT).show();
            }
        });
        mAndroidBuilder.normalImageRes(R.drawable.android)
                .normalText("安卓")
                .typeface(Typefaces.get(this, "chinese.ttf"))
                .textSize(15)
                .normalColorRes(R.color.android)
                .listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Toast.makeText(MainActivity.this,"报名安卓",Toast.LENGTH_SHORT).show();
            }
        });
        mDataBuilder.normalImageRes(R.drawable.data)
                .normalText("大数据")
                .typeface(Typefaces.get(this, "chinese.ttf"))
                .textSize(15)
                .normalColorRes(R.color.data)
                .listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Toast.makeText(MainActivity.this,"报名大数据",Toast.LENGTH_SHORT).show();
            }
        });
        mBmb.addBuilder(mJavaBuilder);
        mBmb.addBuilder(mWebBuilder);
        mBmb.addBuilder(mAndroidBuilder);
        mBmb.addBuilder(mDataBuilder);

    }
}
