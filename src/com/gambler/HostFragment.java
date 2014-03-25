package com.gambler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class HostFragment  extends Fragment {
	private TextView player1_name;
	private TextView player2_name;
	private TextView player3_name;
	private String[] players_name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.host, container, false);
        player1_name = (TextView) rootView.findViewById(R.id.player1_name);
        player2_name = (TextView) rootView.findViewById(R.id.player2_name);
        player3_name = (TextView) rootView.findViewById(R.id.player3_name);
   
        players_name= new String[3];
        players_name[0] = "player1";
    	players_name[1] = "player2";
    	players_name[2] = "player3";
    	
        
    	
    	 player1_name.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	setplayername(players_name,player1_name,0);
            	}
            });
    	 player2_name.setOnClickListener(new OnClickListener() {
             
             @Override
             public void onClick(View v) {
             	setplayername(players_name,player2_name,1);
             	}
             });
    	 player3_name.setOnClickListener(new OnClickListener() {
             
             @Override
             public void onClick(View v) {
                 setplayername(players_name,player3_name,2);
             	}
             });
    	
        return rootView;
    }
    
    
    
    private  void setplayername( final String[] players_name, final TextView player_name_view,final int player_num) {  
        AlertDialog.Builder setnameBuilder = new AlertDialog.Builder(getActivity());  
        setnameBuilder.setTitle("Edit "+players_name[player_num]+" name");  
        final EditText input = new EditText(getActivity());  
        input.setSingleLine();  
        input.setHint(players_name[player_num]); 
        setnameBuilder.setView(input);  
      
        setnameBuilder.setPositiveButton("Save",  
         new DialogInterface.OnClickListener() {  
         public void onClick(DialogInterface dialog, int which) {   
        	 if(!input.getText().toString().matches(""))
        	 {
        		 player_name_view.setText(input.getText());
        	Editable newTxt=(Editable)input.getText(); 
        	players_name[player_num]= newTxt.toString();
        	 
        	 }
        	 }  
         });  
      
        setnameBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {  
        @Override  
        public void onClick(DialogInterface dialog, int which) {  
       
        	
        }  
        });   
        AlertDialog helpDialog = setnameBuilder.create();  
        helpDialog.show();  
       } 
}