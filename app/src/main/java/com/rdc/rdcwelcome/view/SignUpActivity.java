package com.rdc.rdcwelcome.view;

import android.Manifest;
import android.animation.ValueAnimator;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.CircularProgressButton;
import com.rdc.constant.Content;
import com.rdc.entiy.Person;
import com.rdc.rdcwelcome.R;
import com.rdc.rdcwelcome.utils.Typefaces;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rey.material.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class SignUpActivity extends AppCompatActivity {
    private static String TAG = "SignUpActivity";

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
    @BindView(R.id.circularButton_submit)
    CircularProgressButton circularButtonSubmit;
    private int mGroupType;
    private String mGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.android));
        setContentView(R.layout.activity_sign_up);

        Bmob.initialize(this, Content.APPLICATION_ID); //初始化BombSdk
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
        if (mGroupType == 0) {
            mGroup = "后台";
        } else {
            mGroup = Content.NAME_SIGN[mGroupType];
        }
        hideRbGroup();
    }

    private void onClick() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        circularButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(SignUpActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SignUpActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    if(circularButtonSubmit.getProgress()==100||circularButtonSubmit.getProgress()==-1){
                        circularButtonSubmit.setProgress(0);
                    }else{
                        upLoadBmob();
                    }
                }
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
                mGroup = "后台";
                rbJava.setChecked(true);
                rbAndroid.setChecked(false);
                rbData.setChecked(false);
                rbWeb.setChecked(false);
                break;
            case R.id.rb_web:
                mGroup = "前端";
                rbJava.setChecked(false);
                rbAndroid.setChecked(false);
                rbData.setChecked(false);
                rbWeb.setChecked(true);
                break;
            case R.id.rb_android:
                mGroup = "Android";
                rbJava.setChecked(false);
                rbAndroid.setChecked(true);
                rbData.setChecked(false);
                rbWeb.setChecked(false);
                break;
            case R.id.rb_data:
                mGroup = "大数据";
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

    private void upLoadBmob() {
        Person person = new Person();
        person.setName(getString(editName));
        person.setSex(getString(editSex));
        person.setStudentId(getString(editStudentId));
        person.setCollege(getString(editCollege));
        person.setTeam(getString(editClass));
        person.setWork(getString(editWork));
        person.setPhoneNum(getString(editPhoneNum));
        person.setEmail(getString(editEmail));
        person.setQq(getString(editQq));
        person.setSignDirection(mGroup);
        person.setSkills(getString(editSkill));
        person.setIntroduction(getString(editIntroduction));
        person.setHope(getString(editHope));
        person.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    simulateSuccessProgress(circularButtonSubmit);
                } else {
                    simulateErrorProgress(circularButtonSubmit);
                    Log.d(TAG, "error: " + e.toString());
                }
            }
        });


    }

    private String getString(EditText editText) {
        return editText.getText().toString();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(circularButtonSubmit.getProgress()==100||circularButtonSubmit.getProgress()==-1){
                        circularButtonSubmit.setProgress(0);
                    }else{
                        upLoadBmob();
                    }
                } else {
                    Toast.makeText(this, "未获取到权限无法提交", Toast.LENGTH_SHORT);
                }
                break;
            default:
                break;
        }
    }

    //设置提交成功的动画
    private void simulateSuccessProgress(final CircularProgressButton button) {
        ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 100);
        widthAnimation.setDuration(Content.BUTTON_DURATION);
        widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setProgress(value);
            }
        });
        widthAnimation.start();
    }
    //失败时候的动画
    private void simulateErrorProgress(final CircularProgressButton button) {
        ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 99);
        widthAnimation.setDuration(Content.BUTTON_DURATION);
        widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setProgress(value);
                if (value == 99) {
                    button.setProgress(-1);
                }
            }
        });
        widthAnimation.start();
    }

}
