package com.example.myscollviewtest;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

public class RoleFragmentPagerAdapter extends FragmentPagerAdapter {
	private ArrayList<MyFragmentLayout> fragments;
	private FragmentManager fm;

	public RoleFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		this.fm=fm;
	}

	public RoleFragmentPagerAdapter (FragmentManager fm,ArrayList<MyFragmentLayout> fragments) {
		super(fm);
		this.fragments=fragments;
		this.fm=fm;
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}
	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
	public void setFragments(ArrayList<MyFragmentLayout> fragments) {
		if (this.fragments!=null) {
			FragmentTransaction ftFragmentTransaction=fm.beginTransaction();
			for(Fragment f:fragments){
				ftFragmentTransaction.remove(f);
			}
			ftFragmentTransaction.commit();
			ftFragmentTransaction=null;
			fm.executePendingTransactions();
		}
		this.fragments=fragments;
		notifyDataSetChanged();
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Object object= super.instantiateItem(container, position);
		return object;
	}
}
