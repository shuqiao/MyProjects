package com.example.myscollviewtest;

import java.util.ArrayList;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MyFragmentLayout extends Fragment {
	private ArrayList<Role> roles = new ArrayList<Role>();
	private ListView lv_role;
	private Activity activity;
	private RoleListAdapter roleListAdapter;
	public static final int LOAD_ROLE = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Bundle bundle = getArguments();
		roles = (ArrayList<Role>) bundle.get("role");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		this.activity = activity;
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View role_fragment = LayoutInflater.from(getActivity()).inflate(
				R.layout.role_content, null);
		ListView lv_role = (ListView) role_fragment.findViewById(R.id.lv_role);
		roleListAdapter = new RoleListAdapter(getActivity(), roles);
		lv_role.setAdapter(roleListAdapter);
		return role_fragment;
	}

//	@Override
//	public void setUserVisibleHint(boolean isVisibleToUser) {
//		
//		if (isVisibleToUser) {
//			handler.obtainMessage(LOAD_ROLE).sendToTarget();
//		}
//		super.setUserVisibleHint(isVisibleToUser);
//	}
//
//	Handler handler = new Handler() {
//		@Override
//		public void handleMessage(Message msg) {
//			switch (msg.what) {
//			case LOAD_ROLE:
//				roleListAdapter = new RoleListAdapter(getActivity(), roles);
//				if (lv_role==null) {
//					Log.i("-------------->lv_role"," null");
//					
//				} else if( roleListAdapter==null){
//					Log.i("-------------->roleListAdapter", "null");
//
//				}
//				lv_role.setAdapter(roleListAdapter);
//				break;
//			default:
//				break;
//			}
//			super.handleMessage(msg);
//		}
//	};
}
