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

public class fragment1 extends Fragment {
	  
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  View view = inflater.inflate(R.layout.fragment1, null);
	  Button button = (Button) view.findViewById(R.id.next);
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
	 
	}
