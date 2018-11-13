package com.rdc.rdcwelcome.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;


import com.rdc.constant.Content;
import com.rdc.rdcwelcome.R;
import com.rdc.rdcwelcome.utils.CommonUtil;
import com.rdc.rdcwelcome.utils.Typefaces;


public class ContentActivity extends AppCompatActivity {
    private static final String TAG="ContentActivity";

    public static final String GROUP_TYPE = "group_type";

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingTool;
    private AppBarLayout mAppBarLayout;
    private ImageView mGroupImg;
    private TextView mGroupContent;
    private int mGroupType;
    private FloatingActionButton mSingUpFat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_content);

        initData();
        initView();
        onClick();
        changeColor();

    }
    private void initView(){
        mToolbar = findViewById(R.id.toolbar);
        mCollapsingTool = findViewById(R.id.collapsing_toolbar);
        mAppBarLayout = findViewById(R.id.appBar);
        mGroupImg = findViewById(R.id.iv_group_img);
        mGroupContent = findViewById(R.id.tv_group_content);
        mSingUpFat = findViewById(R.id.float_sign_up);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
    private void initData(){
        Intent intent = getIntent();
        mGroupType = intent.getIntExtra(GROUP_TYPE,-1);

        getWindow().setSharedElementExitTransition(new Slide());

    }
    private void onClick(){
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSingUpFat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSignUpActivity(mGroupType);
            }
        });

    }
    private void changeColor(){
        //按钮的颜色改变
        mSingUpFat.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(Content.COLOR[mGroupType])));
        mCollapsingTool.setTitle(Content.NAME[mGroupType]);
        //标题栏刚开始的字体颜色
        mCollapsingTool.setExpandedTitleColor(getResources().getColor(Content.COLOR[mGroupType]));
        mCollapsingTool.setExpandedTitleTypeface(Typefaces.get(ContentActivity.this,"chinese.ttf"));
        //标题栏结束的字体
        mCollapsingTool.setCollapsedTitleTypeface(Typefaces.get(ContentActivity.this,"chinese.ttf"));
        //标题栏的颜色
        mCollapsingTool.setContentScrimResource(Content.COLOR_TITLE[mGroupType]);
        //状态栏的颜色
        mCollapsingTool.setStatusBarScrimResource(Content.COLOR_TITLE[mGroupType]);
        mGroupContent.setText(Content.CONTENT[mGroupType]);
        mGroupImg.setImageResource(Content.IMG[mGroupType]);

        if(mGroupType == 0){
            mToolbar.setNavigationIcon(R.drawable.back);
            mCollapsingTool.setCollapsedTitleTextColor(getResources().getColor(R.color.rdc_back));
        }
    }

    private void toSignUpActivity(int groupType){
        Intent intent = new Intent(ContentActivity.this, SignUpActivity.class);
        intent.putExtra(ContentActivity.GROUP_TYPE, groupType);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

}
