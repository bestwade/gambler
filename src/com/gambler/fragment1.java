package com.gambler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class fragment1 extends Fragment {
	  TextView text;
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  View view = inflater.inflate(R.layout.fragment1, null);
	  Button button = (Button) view.findViewById(R.id.next);
	  text =(TextView) view.findViewById(R.id.textView1);
	  //button.setText("horizontal");
	  button.setOnClickListener(new OnClickListener() {
		  
		   @Override
		   public void onClick(View v) {
		    
		    fragment2 fh = new fragment2();
		     FragmentManager fm = getFragmentManager();
		     FragmentTransaction ft = fm.beginTransaction();
		     ft.replace(R.id.layoutToReplace, fh);
		     ft.commit();
		     
		   }
		  });
	  return view;
	 }
	 public void updatetextview(String input) {
		 
		 text.setText(input);
		 
	 }
	}
