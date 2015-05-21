package com.example.myscollviewtest;

import android.R.integer;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Role implements Parcelable{

	private String role_name;
	private int role_img_id;
	public Role(){}
	public Role(String role_name, int role_img_id) {
		this.role_name=role_name;
		this.role_img_id=role_img_id;
	}
	
	
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getRole_img_id() {
		return role_img_id;
	}
	public void setRole_img_id(int role_img_id) {
		this.role_img_id = role_img_id;
	}


	public static final Parcelable.Creator<Role> CREATOR = new Creator<Role>() {  
        public Role createFromParcel(Parcel source) {  
        	Role role = new Role();  
        	role.setRole_name(source.readString()); 
        	role.setRole_img_id(source.readInt());
            return role;  
        }  
  
        public Role[] newArray(int size) {  
            return new Role[size];  
        }  
    };  
	

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	 @Override  
	    public void writeToParcel(Parcel parcel, int flags) {  
	        parcel.writeString(role_name);  
	        parcel.writeInt(role_img_id);  
	    }  
	  
}
