package com.rdc.rdcwelcome.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rdc.constant.Content;
import com.rdc.rdcwelcome.R;
import com.rdc.rdcwelcome.utils.Typefaces;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rey.material.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_title)
    TextView mTitle;
    @BindView(R.id.edit_name)
    MaterialEditText editName;
    @BindView(R.id.sex)
    MaterialEditText editSex;
    @BindView(R.id.edit_student_id)
    MaterialEditText editStudentId;
    @BindView(R.id.edit_college)
    MaterialEditText editCollege;
    @BindView(R.id.edit_class)
    MaterialEditText editClass;
    @BindView(R.id.edit_work)
    MaterialEditText editWork;
    @BindView(R.id.edit_phone_num)
    MaterialEditText editPhoneNum;
    @BindView(R.id.edit_email)
    MaterialEditText editEmail;
    @BindView(R.id.edit_qq)
    MaterialEditText editQq;
    @BindView(R.id.edit_skill)
    MaterialEditText editSkill;
    @BindView(R.id.edit_introduction)
    MaterialEditText editIntroduction;
    @BindView(R.id.edit_hope)
    MaterialEditText editHope;
    @BindView(R.id.rb_java)
    RadioButton rbJava;
    @BindView(R.id.rb_web)
    RadioButton rbWeb;
    @BindView(R.id.rb_android)
    RadioButton rbAndroid;
    @BindView(R.id.rb_data)
    RadioButton rbData;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.card_sign_direction)
    CardView mSignDirection;
    private int mGroupType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.android));
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);
        initView();
        initData();
        onClick();
        setColor();
    }

    private void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mTitle.setTypeface(Typefaces.get(SignUpActivity.this, "chinese.ttf"));
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initData() {
        mGroupType = getIntent().getIntExtra(ContentActivity.GROUP_TYPE, 0);
        hideRbGroup();
    }

    private void onClick() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setColor() {
        mTitle.setText(Content.NAME_SIGN[mGroupType] + "报名表");
        mToolbar.setBackgroundResource(Content.COLOR[mGroupType]);
        getWindow().setStatusBarColor(getResources().getColor(Content.COLOR[mGroupType]));
        //改变输入框的颜色
        editName.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editSex.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editStudentId.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editCollege.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editClass.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editWork.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editPhoneNum.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editEmail.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editQq.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editSkill.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editIntroduction.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));
        editHope.setPrimaryColor(getResources().getColor(Content.COLOR[mGroupType]));

    }

    @OnClick({R.id.rb_java, R.id.rb_web, R.id.rb_android, R.id.rb_data})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_java:
                rbJava.setChecked(true);
                rbAndroid.setChecked(false);
                rbData.setChecked(false);
                rbWeb.setChecked(false);
                break;
            case R.id.rb_web:
                rbJava.setChecked(false);
                rbAndroid.setChecked(false);
                rbData.setChecked(false);
                rbWeb.setChecked(true);
                break;
            case R.id.rb_android:
                rbJava.setChecked(false);
                rbAndroid.setChecked(true);
                rbData.setChecked(false);
                rbWeb.setChecked(false);
                break;
            case R.id.rb_data:
                rbJava.setChecked(false);
                rbAndroid.setChecked(false);
                rbData.setChecked(true);
                rbWeb.setChecked(false);
                break;
        }
    }

    private void hideRbGroup() {
        if (mGroupType == 0) {
            mSignDirection.setVisibility(View.VISIBLE);
        } else {
            mSignDirection.setVisibility(View.GONE);
        }
    }
}
