package com.example.myscollviewtest;

import java.util.ArrayList;
import java.util.HashMap;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends FragmentActivity {
	private LinearLayout ll_scollContent;
	private ViewPager vp_content;
	private HorizontalScrollView hs_scoll;

	private HashMap<String, ArrayList<Role>> roleCatogeryMap = new HashMap<String, ArrayList<Role>>();
	private ArrayList<String> roleCatogeryList = new ArrayList<String>();
	private ArrayList<MyFragmentLayout> fragments = new ArrayList<MyFragmentLayout>();

	private TextView tvTabTextView;

	private int screenWidth, tabWidth;
	private int seletedTab = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_main);
		initData();
		initView();
	

	}

	private void initData() {

		roleCatogeryList.add("热门");
		roleCatogeryList.add("最新");
		roleCatogeryList.add("武侠");
		roleCatogeryList.add("二次元");
		roleCatogeryList.add("动漫");
		roleCatogeryList.add("小说");
		roleCatogeryList.add("游戏");
		roleCatogeryList.add("物理界");

		ArrayList<Role> role_list1 = new ArrayList<Role>();
		role_list1.add(new Role("机器人", R.drawable.ic_launcher));
		role_list1.add(new Role("机器人", R.drawable.ic_launcher));
		role_list1.add(new Role("机器人", R.drawable.ic_launcher));
		role_list1.add(new Role("机器人", R.drawable.ic_launcher));
		role_list1.add(new Role("机器人", R.drawable.ic_launcher));
		role_list1.add(new Role("机器人", R.drawable.ic_launcher));
		role_list1.add(new Role("机器人", R.drawable.ic_launcher));

		for (int i = 0; i < roleCatogeryList.size(); i++) {
			roleCatogeryMap.put(roleCatogeryList.get(i), role_list1);

		}

		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		screenWidth = metric.widthPixels;
		tabWidth = screenWidth / 5;
	}

	private void initView() {
		ll_scollContent = (LinearLayout) findViewById(R.id.ll_scollContent);
		vp_content = (ViewPager) findViewById(R.id.vp_content);
		hs_scoll = (HorizontalScrollView) findViewById(R.id.hs_scoll);
		
		
//			ll_scollContent.removeAllViews();
//			for(int i = 0; i< count; i++){
//				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mItemWidth , LayoutParams.WRAP_CONTENT);
//				params.leftMargin = 5;
//				params.rightMargin = 5;
////				TextView localTextView = (TextView) mInflater.inflate(R.layout.column_radio_item, null);
//				TextView columnTextView = new TextView(this);
//				columnTextView.setTextAppearance(this, R.style.top_category_scroll_view_item_text);
////				localTextView.setBackground(getResources().getDrawable(R.drawable.top_category_scroll_text_view_bg));
//				columnTextView.setBackgroundResource(R.drawable.radio_buttong_bg);
//				columnTextView.setGravity(Gravity.CENTER);
//				columnTextView.setPadding(5, 5, 5, 5);
//				columnTextView.setId(i);
//				columnTextView.setText(newsClassify.get(i).getTitle());
//				columnTextView.setTextColor(getResources().getColorStateList(R.color.top_category_scroll_text_color_day));
//				if(columnSelectIndex == i){
//					columnTextView.setSelected(true);
//				}
//				columnTextView.setOnClickListener(new OnClickListener() {
//					
//					@Override
//					public void onClick(View v) {
//				          for(int i = 0;i < mRadioGroup_content.getChildCount();i++){
//					          View localView = mRadioGroup_content.getChildAt(i);
//					          if (localView != v)
//					        	  localView.setSelected(false);
//					          else{
//					        	  localView.setSelected(true);
//					        	  mViewPager.setCurrentItem(i);
//					          }
//				          }
//				          Toast.makeText(getApplicationContext(), newsClassify.get(v.getId()).getTitle(), Toast.LENGTH_SHORT).show();
//					}
//				});
//				mRadioGroup_content.addView(columnTextView, i ,params);
//			

		// 初始化目录行
		ll_scollContent.removeAllViews();
		for (int i = 0; i < roleCatogeryList.size(); i++) {
//			
////			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(tabWidth,
////					LayoutParams.WRAP_CONTENT);
////			lp.leftMargin = 5;
////			lp.rightMargin = 5;
////			
//			tvTabTextView = new TextView(this);
//
//			tvTabTextView.setText("最热");
//			tvTabTextView.setGravity(Gravity.CENTER);
//			tvTabTextView.setText(roleCatogeryList.get(i));
//			tvTabTextView.setTextSize(R.dimen.text_small);
//			tvTabTextView.setTextColor(R.color.black);
//			tvTabTextView.setId(i);
//
//			tvTabTextView.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					for (int i = 0; i < ll_scollContent.getChildCount(); i++) {
//						View localView = ll_scollContent.getChildAt(i);
//						if (localView != v)
//							localView.setSelected(false);
//						else {
//							localView.setSelected(true);
//							vp_content.setCurrentItem(i);
//						}
//					}
//				}
//			});
//			//ll_scollContent.addView(tvTabTextView, i, lp);
//			ll_scollContent.addView(tvTabTextView);
			
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(tabWidth , LayoutParams.WRAP_CONTENT);
			params.leftMargin = 5;
			params.rightMargin = 5;
//			TextView localTextView = (TextView) mInflater.inflate(R.layout.column_radio_item, null);
			TextView columnTextView = new TextView(this);
			//columnTextView.setTextAppearance(this, R.style.top_category_scroll_view_item_text);
//			localTextView.setBackground(getResources().getDrawable(R.drawable.top_category_scroll_text_view_bg));
			//columnTextView.setBackgroundResource(R.drawable.radio_buttong_bg);
			columnTextView.setGravity(Gravity.CENTER);
			columnTextView.setPadding(5, 5, 5, 5);
			columnTextView.setId(i);
			columnTextView.setText(roleCatogeryList.get(i));
			columnTextView.setTextColor(getResources().getColorStateList(R.color.black));
			
			columnTextView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
			          for(int i = 0;i < ll_scollContent.getChildCount();i++){
				          View localView = ll_scollContent.getChildAt(i);
				          if (localView != v)
				        	  localView.setSelected(false);
				          else{
				        	  localView.setSelected(true);
				        	  vp_content.setCurrentItem(i);
				          }
			          }
			         // Toast.makeText(getApplicationContext(), newsClassify.get(v.getId()).getTitle(), Toast.LENGTH_SHORT).show();
				}
			});
			ll_scollContent.addView(columnTextView, i ,params);
		
		}

		for (int i = 0; i < roleCatogeryList.size(); i++) {
			Bundle bundle = new Bundle();
			bundle.putParcelableArrayList("role",
					roleCatogeryMap.get(roleCatogeryList.get(i)));
			MyFragmentLayout myFragmentLayout = new MyFragmentLayout();
			myFragmentLayout.setArguments(bundle);
			fragments.add(myFragmentLayout);
		}
		RoleFragmentPagerAdapter roleFragmentPagerAdapter = new RoleFragmentPagerAdapter(
				getSupportFragmentManager(), fragments);
		vp_content.setAdapter(roleFragmentPagerAdapter);
		vp_content.setOnPageChangeListener(onPageChangeListener);

	}

	OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			vp_content.setCurrentItem(arg0, true);
			seleceTab(arg0);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	private void seleceTab(int selectedTabId) {
		seletedTab = selectedTabId;
		// 滑动
		View selectedTabView = ll_scollContent.getChildAt(selectedTabId);
		int i = selectedTabView.getMeasuredWidth();
		int k = selectedTabView.getLeft();
		int scollLength = k + i / 2 - screenWidth / 2;
//		for (int j = 0; j <= scollLength; j = j + scollLength / 3) {
//			if (j >= scollLength / 3 && j < scollLength / 3 * 2) {
//				tvTabTextView.setTextColor(R.color.yellow);
//				tvTabTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,
//						R.dimen.text_medium);
//			} else if (j >= scollLength / 3 * 2 && j <= scollLength) {
//				tvTabTextView.setTextColor(R.color.red);
//				tvTabTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,
//						R.dimen.text_large);
//			}
//			hs_scoll.smoothScrollTo(j, 0);
//		}
		hs_scoll.smoothScrollTo(scollLength, 0);
//		for (int j = 0; j < ll_scollContent.getChildCount(); j++) {
//			TextView tvTab = (TextView) ll_scollContent.getChildAt(j);
//			if (j != selectedTabId) {
//				tvTabTextView.setTextColor(R.color.black);
//				tvTabTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,
//						R.dimen.text_small);
//			}
//
//		}

	}

}
