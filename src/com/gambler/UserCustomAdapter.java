package com.gambler;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class UserCustomAdapter extends ArrayAdapter<User> {
	 Context context;
	 int layoutResourceId;
	 ArrayList<User> data = new ArrayList<User>();

	 public UserCustomAdapter(Context context, int layoutResourceId,
	   ArrayList<User> data) {
	  super(context, layoutResourceId, data);
	  this.layoutResourceId = layoutResourceId;
	  this.context = context;
	  this.data = data;
	 }

	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	  View row = convertView;
	  UserHolder holder = null;

	  if (row == null) {
		  LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

	   //LayoutInflater inflater = ((Activity) context).getLayoutInflater();
	   row = inflater.inflate(layoutResourceId, parent, false);
	   holder = new UserHolder();
	   holder.textround = (TextView) row.findViewById(R.id.listplayer);
	   holder.textplayer1 = (TextView) row.findViewById(R.id.listplayer1);
	   holder.textplayer2 = (TextView) row.findViewById(R.id.listplayer2);
	   holder.textplayer3 = (TextView) row.findViewById(R.id.listplayer3);
	   holder.textplayer4 = (TextView) row.findViewById(R.id.listplayer4);

	   //holder.btnEdit = (Button) row.findViewById(R.id.button1);
	   //holder.btnDelete = (Button) row.findViewById(R.id.button2);
	   row.setTag(holder);
	  } else {
	   holder = (UserHolder) row.getTag();
	  }
	  User user = data.get(position);
	  holder.textround.setText("Round:"+user.getround());
	  //holder.textplayer1.setText(Integer.toString(user.getplayer1()));
	  //holder.textplayer2.setText(Integer.toString(user.getplayer2()));
	  //holder.textplayer3.setText(Integer.toString(user.getplayer3()));
	  //holder.textplayer4.setText(Integer.toString(user.getplayer4()));
	  holder.textplayer1.setText(user.getplayer1_text());
	  holder.textplayer2.setText(user.getplayer2_text());
	  holder.textplayer3.setText(user.getplayer3_text());
	  holder.textplayer4.setText(user.getplayer4_text());
	  /*holder.btnEdit.setOnClickListener(new OnClickListener() {

	   @Override
	   public void onClick(View v) {
	    // TODO Auto-generated method stub
	    Log.i("Edit Button Clicked", "**********");
	    Toast.makeText(context, "Edit button Clicked",
	      Toast.LENGTH_LONG).show();
	   }
	  });
	  holder.btnDelete.setOnClickListener(new OnClickListener() {

	   @Override
	   public void onClick(View v) {
	    // TODO Auto-generated method stub
	    Log.i("Delete Button Clicked", "**********");
	    Toast.makeText(context, "Delete button Clicked",
	      Toast.LENGTH_LONG).show();
	   }
	  });*/
	  return row;

	 }

	 static class UserHolder {
		 TextView textround;
		 TextView textplayer1;
		 TextView textplayer2;
		 TextView textplayer3;
		 TextView textplayer4;
	  
	  //Button btnEdit;
	 // Button btnDelete;
	 }
	}
