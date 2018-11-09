package com.rdc.rdcwelcome.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


import com.rdc.constant.Content;
import com.rdc.rdcwelcome.R;
import com.rdc.rdcwelcome.utils.Typefaces;


public class ContentActivity extends AppCompatActivity {

    public static final String GROUP_TYPE = "group_type";

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingTool;
    private ImageView mGroupImg;
    private TextView mGroupContent;
    private int mGroupType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_content);

        initData();
        initView();
        onClick();

    }
    private void initView(){
        mToolbar = findViewById(R.id.toolbar);
        mCollapsingTool = findViewById(R.id.collapsing_toolbar);
        mGroupImg = findViewById(R.id.iv_group_img);
        mGroupContent = findViewById(R.id.tv_group_content);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mCollapsingTool.setTitle(Content.NAME[mGroupType]);
        //标题栏刚开始的字体颜色
        mCollapsingTool.setExpandedTitleColor(getResources().getColor(Content.COLOR[mGroupType]));
        mCollapsingTool.setExpandedTitleTypeface(Typefaces.get(ContentActivity.this,"chinese.ttf"));
        //标题栏结束的字体
        mCollapsingTool.setCollapsedTitleTypeface(Typefaces.get(ContentActivity.this,"chinese.ttf"));
        //标题栏的颜色
        mCollapsingTool.setContentScrimResource(Content.COLOR_TITLE[mGroupType]);
        mGroupContent.setText(Content.CONTENT[mGroupType]);
        mGroupImg.setImageResource(Content.IMG[mGroupType]);

        if(mGroupType == 0){
            mToolbar.setNavigationIcon(R.drawable.back);
            mCollapsingTool.setCollapsedTitleTextColor(getResources().getColor(R.color.rdc_back));
        }

    }
    private void initData(){
        Intent intent = getIntent();
        mGroupType = intent.getIntExtra(GROUP_TYPE,-1);

        Window window =getWindow();

    }
    private void onClick(){
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
