package com.example.myscollviewtest;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RoleListAdapter extends BaseAdapter {

	private ArrayList<Role> rolesList = new ArrayList<Role>();
	private Context context;

	public RoleListAdapter(Context context, ArrayList<Role> rolesList) {
		this.rolesList = rolesList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return rolesList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return rolesList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int pos, View convetrViewv, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convetrViewv == null) {
			viewHolder = new ViewHolder();
			convetrViewv = LayoutInflater.from(context).inflate(
					R.layout.item_role, null);
			viewHolder.line1= (LinearLayout) convetrViewv
					.findViewById(R.id.ll_role_line1);
			viewHolder.line2= (LinearLayout) convetrViewv
					.findViewById(R.id.ll_role_line2);
			viewHolder.role_name1 = (TextView) convetrViewv
					.findViewById(R.id.tv_role_name1);
			viewHolder.role_name2 = (TextView) convetrViewv
					.findViewById(R.id.tv_role_name2);
			viewHolder.role_img1 = (ImageView) convetrViewv
					.findViewById(R.id.img_role1);
			viewHolder.role_img2 = (ImageView) convetrViewv
					.findViewById(R.id.img_role2);
			convetrViewv.setTag(viewHolder);
		} else {

			viewHolder = (ViewHolder) convetrViewv.getTag();
		}

		for (int i = 0; i < rolesList.size(); i += 2) {
			viewHolder.role_name1.setText(rolesList.get(i).getRole_name());
			viewHolder.role_img1.setImageResource(rolesList.get(i).getRole_img_id());
			if (i + 1 < rolesList.size()) {
				viewHolder.role_name2.setText(rolesList.get(i + 1).getRole_name());
				viewHolder.role_img2.setImageResource(rolesList.get(i + 1).getRole_img_id());
			}
		}
		viewHolder.line1.setOnClickListener(listener);
		viewHolder.line2.setOnClickListener(listener);

		return convetrViewv;
	}
	private OnClickListener listener=new View.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			//将数据更新到已选择上
			
		}
		
	};

}

class ViewHolder {
	LinearLayout line1;
	LinearLayout line2;
	TextView role_name1;
	TextView role_name2;
	ImageView role_img1;
	ImageView role_img2;

}
