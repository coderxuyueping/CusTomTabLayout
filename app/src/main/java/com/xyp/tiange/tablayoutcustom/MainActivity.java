package com.xyp.tiange.tablayoutcustom;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        initTabTitleView(3);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetTabTitleBg(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    //给每一个Tab初始化自定义的样式
    private void initTabTitleView(int count) {
        for (int i = 0; i < count; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(R.layout.tablayout_title);


            TextView tv=(TextView)tab.getCustomView().findViewById(android.R.id.text1);
            BadgeView badgeView=new BadgeView(this);
            badgeView.setTargetView(tv);
            badgeView.setBadgeCount(i);
        }
    }

    //更新选中tab的样式
    private void resetTabTitleBg(int position) {
        for (int i = 0; i < 3; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (i == position) {
                tab.getCustomView().findViewById(android.R.id.text1).setSelected(true);
            } else {
                tab.getCustomView().findViewById(android.R.id.text1).setSelected(false);
            }
        }
    }
    class MyAdapter extends FragmentPagerAdapter{
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            MyFragment fragment=new MyFragment();
            String str="";
            if(position==0){
                str="1";
            }else if(position==1){
                str="2";
            }else{
                str="3";
            }
            fragment.setText(str);
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return "标题";
        }
    }
}
