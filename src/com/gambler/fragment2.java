package com.gambler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class fragment2 extends Fragment {
	 //OnHeadlineSelectedListener mCallback;
	 public static final String MyPREFERENCES = "MyPrefs" ;
	   public static final String Name = "nameKey"; 
	    // Container Activity must implement this interface
	    /*public interface OnHeadlineSelectedListener {
	        public void onArticleSelected(String input);
	    }
	    
	    @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        MajerFragment mf = new MajerFragment();
	        // This makes sure that the container activity has implemented
	        // the callback interface. If not, it throws an exception
	        try {
	            mCallback = (OnHeadlineSelectedListener) mf;
	        } catch (ClassCastException e) {
	            throw new ClassCastException(activity.toString()
	                    + " must implement OnHeadlineSelectedListener");
	        }
	    }*/
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  View view = inflater.inflate(R.layout.fragment2, null);
	  Button button = (Button) view.findViewById(R.id.back);
	  Button enter = (Button) view.findViewById(R.id.enter);
	  
	  final EditText input = (EditText) view.findViewById(R.id.edit_text);
	  //button.setText("horizontal");
	  final SharedPreferences sharedpreferences = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

	  button.setOnClickListener(new OnClickListener() {
		  
		   @Override
		   public void onClick(View v) {
			   String in = input.getText().toString();
			   Editor editor = sharedpreferences.edit();
			      editor.putString(Name, in);
			      editor.commit();
			    //fragment1 fh = new fragment1();
			      Fragment fragment1 = getFragmentManager().findFragmentByTag("show");  
			        Fragment fragment2 = getFragmentManager().findFragmentByTag("input");  
		     FragmentManager fm = getFragmentManager();
		    FragmentTransaction ft = fm.beginTransaction();
		     //fm.popBackStack();
		     ft.hide(fragment2);
		     ft.show(fragment1);
		   // fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE); 
		     ft.commit();
		  
		   }
		  });
	  
	  enter.setOnClickListener(new OnClickListener() {
		  
		   @Override
		   public void onClick(View v) {
		        String in = input.getText().toString();
		        Fragment fragment1 = getFragmentManager().findFragmentByTag("show");  
		        ((fragment1) fragment1).updatetextview(in);
		        //mCallback.onArticleSelected(in);
		       // Fragment fragmentlay = getFragmentManager().findFragmentByTag("ground");  
		        //((fragment1) fragmentlay).updatetextview(in);
		   }
		  });
	  return view;
	 }
	 
	}
