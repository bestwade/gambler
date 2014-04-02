package com.gambler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class fragment1 extends Fragment {
	  TextView text;
	  public static final String MyPREFERENCES = "MyPrefs" ;
	   public static final String Name = "nameKey"; 

	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  View view = inflater.inflate(R.layout.fragment1, null);
	  
	  SharedPreferences sharedpreferences = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	  Button button = (Button) view.findViewById(R.id.next);
	  text =(TextView) view.findViewById(R.id.textView1);
	  if (sharedpreferences.contains(Name))
      {
         //text.setText(sharedpreferences.getString(Name, ""));
		  //updatetextview(sharedpreferences.getString(Name, ""));

      }
	  //button.setText("horizontal");
	  button.setOnClickListener(new OnClickListener() {
		  
		   @Override
		   public void onClick(View v) {
			   Fragment fragment1 = getFragmentManager().findFragmentByTag("show");  
		        Fragment fragment2 = getFragmentManager().findFragmentByTag("input");  
			   
		    //fragment2 fh = new fragment2();
		     FragmentManager fm = getFragmentManager();
		     FragmentTransaction ft = fm.beginTransaction();
		     ft.show(fragment2);
		     ft.hide(fragment1);
		     //ft.addToBackStack("show");
		     //ft.replace(R.id.layoutToReplace, fh);
		     ft.commit();
		     
		   }
		  });
	  return view;
	 }
	 
	 public void updatetextview(String input) {
		 
		 text.setText(input);
		 
	 }
	}
//http://cheng-min-i-taiwan.blogspot.hk/2013/01/fragment.html