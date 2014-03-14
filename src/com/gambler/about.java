package com.gambler;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class about extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
 
        // get action bar   
        ActionBar actionBar = getActionBar();
   
        
     // set the icon
     actionBar.setIcon(R.drawable.ic_action_about);
        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
