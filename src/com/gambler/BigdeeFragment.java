package com.gambler;

import com.gambler.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;



public class BigdeeFragment extends Fragment {
 
	private String player;
	private TextView textplayer1;
	private TextView textplayer2;
	private TextView textplayer3;
	private TextView textplayer4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.bigdee, container, false);
        
        textplayer1 = (TextView) rootView.findViewById(R.id.player1);
        textplayer2 = (TextView) rootView.findViewById(R.id.player2);
        textplayer3 = (TextView) rootView.findViewById(R.id.player3);
        textplayer4 = (TextView) rootView.findViewById(R.id.player4);
        
        
        
        
        textplayer1.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	player= ((TextView)v).getText().toString();
            	showPopUpPhone(player,textplayer1,"player1");
            	}
            });
        textplayer2.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	player= ((TextView)v).getText().toString();
            	showPopUpPhone(player,textplayer2,"player2");
            	}
            });
        textplayer3.setOnClickListener(new OnClickListener() {
    
		    @Override
		    public void onClick(View v) {
		    	player= ((TextView)v).getText().toString();
		    	showPopUpPhone(player,textplayer3,"player3");
		    	}
		    });
		textplayer4.setOnClickListener(new OnClickListener() {
		    
		    @Override
		    public void onClick(View v) {
		    	player= ((TextView)v).getText().toString();
		    	showPopUpPhone(player,textplayer4,"player4");
		    	}
		    });
        return rootView;
            
    }
    
    
    private void showPopUpPhone(String name, final TextView v,final String def) {  
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());  
        helpBuilder.setTitle("Edit name ");  
        final EditText input = new EditText(getActivity());  
        input.setSingleLine();  
        input.setText(name); //Set the text we want to edit  
        helpBuilder.setView(input);        
       //Save button  
        helpBuilder.setPositiveButton("Save",  
         new DialogInterface.OnClickListener() {  
         public void onClick(DialogInterface dialog, int which) {  
           //Save info here  
        	 if(input.getText().toString().matches("")){
        		 v.setText(def);
        	 }else
        	v.setText(input.getText());
         }  
         });  
       //Cancel button  
        helpBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {  
        @Override  
        public void onClick(DialogInterface dialog, int which) {  
         // Do nothing, just close the dialog box  
        	
        }  
        });  
        // Remember, create doesn't show the dialog  
        AlertDialog helpDialog = helpBuilder.create();  
        helpDialog.show();  
       }  
}
