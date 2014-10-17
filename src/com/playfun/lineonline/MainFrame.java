package com.playfun.lineonline;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.TabHost;

public class MainFrame extends FragmentActivity {
	
	private ViewPager viewPager;
    private MainTabsAdapter mAdapter;
    private TabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_frame);
		
		//Initialization

        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();

        viewPager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MainTabsAdapter(this, mTabHost, viewPager);

        mAdapter.addTab(mTabHost.newTabSpec("1").setIndicator("[�Ŷ�]"), LineFragment.class, null);
        mAdapter.addTab(mTabHost.newTabSpec("2").setIndicator("[��ͼ]"), MapFragment.class, null);
        mAdapter.addTab(mTabHost.newTabSpec("3").setIndicator("[����]"), CommentFragment.class, null);
        mAdapter.addTab(mTabHost.newTabSpec("4").setIndicator("[Ȧ��]"), ShareFragment.class, null);

        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        }
	}
}
