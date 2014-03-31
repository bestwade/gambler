package com.gambler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class fragment2 extends Fragment {
	 OnHeadlineSelectedListener mCallback;

	    // Container Activity must implement this interface
	    public interface OnHeadlineSelectedListener {
	        public void onArticleSelected(int position);
	    }
	    
	    @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        
	        // This makes sure that the container activity has implemented
	        // the callback interface. If not, it throws an exception
	        try {
	            mCallback = (OnHeadlineSelectedListener) activity;
	        } catch (ClassCastException e) {
	            throw new ClassCastException(activity.toString()
	                    + " must implement OnHeadlineSelectedListener");
	        }
	    }
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  View view = inflater.inflate(R.layout.fragment2, null);
	  Button button = (Button) view.findViewById(R.id.back);
	  //button.setText("horizontal");
	  button.setOnClickListener(new OnClickListener() {
		  
		   @Override
		   public void onClick(View v) {
		    
			    fragment1 fh = new fragment1();
		     FragmentManager fm = getFragmentManager();
		     FragmentTransaction ft = fm.beginTransaction();
		     ft.replace(R.id.layoutToReplace, fh);
		     ft.commit();
		     
		   }
		  });
	  return view;
	 }
	 
	}
