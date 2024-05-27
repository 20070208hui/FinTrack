package com.cashflow.fintrack;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import com.cashflow.fintrack.adapter.RecordPagerAdapter;
import com.cashflow.fintrack.record_fragment.IncomeFragment;
import com.cashflow.fintrack.record_fragment.OutcomeFragment;

public class recordingActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recording);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //查找控件
        tabLayout = findViewById(R.id.record_iv_tabs);
        viewPager = findViewById((R.id.record_vp));
        //设置加载页面
        initPager();
    }

    private void initPager(){
        //initialize viewpager list
        ArrayList <Fragment> fragmentList = new ArrayList<>();
        //创建收入支出页面
        OutcomeFragment outFrag = new OutcomeFragment();//支出
        IncomeFragment inFrag = new IncomeFragment();//收入
        fragmentList.add(outFrag);
        fragmentList.add(inFrag);

        //创建适配器
        RecordPagerAdapter pagerAdapter = new RecordPagerAdapter(getSupportFragmentManager(),fragmentList);

        //设置适配器
        viewPager.setAdapter(pagerAdapter);

        //将tabLayout和viewPager关联
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.record_iv_back){
            finish();
        }
    }
}