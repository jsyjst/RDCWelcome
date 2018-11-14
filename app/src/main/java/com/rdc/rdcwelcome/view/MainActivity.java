package com.rdc.rdcwelcome.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

import com.rdc.adapter.GroupAdapter;
import com.rdc.entiy.Group;
import com.rdc.rdcwelcome.R;
import com.rdc.rdcwelcome.utils.CommonUtil;
import com.rdc.rdcwelcome.utils.Typefaces;

import java.util.ArrayList;
import java.util.List;

import static com.rdc.rdcwelcome.view.ContentActivity.GROUP_TYPE;


public class MainActivity extends AppCompatActivity {
    private TextView mWelcomeTv;
    private BoomMenuButton mBmb;
    private TextOutsideCircleButton.Builder mAndroidBuilder, mJavaBuilder, mWebBuilder, mDataBuilder,mRdcBuilder;
    private List<Group> mGroupList = new ArrayList<>();
    private GroupAdapter mAapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonUtil.hideStatusBar(this, this, true);
        setContentView(R.layout.activity_main);

        initView();
        initBottom();
        initData();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        //1.4,0.5
        SkidRightLayoutManager skidRightLayoutManager = new SkidRightLayoutManager(1.175f, 0.35f);
        recyclerView.setLayoutManager(skidRightLayoutManager);
        mAapter = new GroupAdapter(this, mGroupList);
        recyclerView.setAdapter(mAapter);
        mAapter.setItemOnClick(new GroupAdapter.ItemOnClick() {
            @Override
            public void itemOnClick(int position, View v) {
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                intent.putExtra(GROUP_TYPE, position);
                startActivity(intent, ActivityOptions.
                        makeSceneTransitionAnimation(MainActivity.this, v, "group_img").toBundle());
            }
        });
    }

    private void initData() {
        Group group5 = new Group();
        group5.setGroupImg(R.drawable.rdc_small);
        group5.setGroupName("RDC 研发中心");
        mGroupList.add(group5);

        Group group2 = new Group();
        group2.setGroupImg(R.drawable.java_big);
        group2.setGroupName("Java 后台");
        mGroupList.add(group2);

        Group group3 = new Group();
        group3.setGroupImg(R.drawable.web_big);
        group3.setGroupName("Web前端");
        mGroupList.add(group3);

        Group group1 = new Group();
        group1.setGroupName("Android 移动");
        group1.setGroupImg(R.drawable.android_big);
        mGroupList.add(group1);

        Group group4 = new Group();
        group4.setGroupImg(R.drawable.big_data);
        group4.setGroupName("BigData 大数据");
        mGroupList.add(group4);


    }

    private void initView() {
//       mWelcomeTv = findViewById(R.id.tv_welcome);
//        mWelcomeTv.setTypeface(Typefaces.get(this, "chinese.ttf"));
        mBmb = findViewById(R.id.bmb);
    }

    private void initBottom() {
        mAndroidBuilder = new TextOutsideCircleButton.Builder();
        mJavaBuilder = new TextOutsideCircleButton.Builder();
        mWebBuilder = new TextOutsideCircleButton.Builder();
        mDataBuilder = new TextOutsideCircleButton.Builder();
        mRdcBuilder = new TextOutsideCircleButton.Builder();

        mJavaBuilder.normalImageRes(R.drawable.java)
                .normalText("后台")
                .typeface(Typefaces.get(this, "chinese.ttf"))
                .textSize(15)
                .normalColorRes(R.color.java)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        toSignUpActivity(1);
                    }
                });
        mWebBuilder.normalImageRes(R.drawable.web)
                .normalText("前端").normalColorRes(R.color.web)
                .typeface(Typefaces.get(this, "chinese.ttf"))
                .textSize(15)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        toSignUpActivity(2);
                    }
                });
        mRdcBuilder.normalImageRes(R.drawable.rdc_icon)
                .normalText("研发中心")
                .typeface(Typefaces.get(this, "chinese.ttf"))
                .textSize(15)
                .normalColorRes(R.color.rdc)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        toSignUpActivity(0);
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
                        toSignUpActivity(3);
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
                        toSignUpActivity(4);
                    }
                });

        mBmb.addBuilder(mJavaBuilder);
        mBmb.addBuilder(mWebBuilder);
        mBmb.addBuilder(mRdcBuilder);
        mBmb.addBuilder(mAndroidBuilder);
        mBmb.addBuilder(mDataBuilder);

    }

    private void toSignUpActivity(int groupType) {
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        intent.putExtra(ContentActivity.GROUP_TYPE, groupType);
        startActivity(intent);
    }
}
