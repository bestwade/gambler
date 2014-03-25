package com.gambler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import com.gambler.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;



public class BigdeeFragment extends Fragment {
 
	private String[] player_name;
	private int gobalround;
	private double moneypercard;
	private TextView textmoneypercard;
	private TextView textplayer1;
	private TextView textplayer2;
	private TextView textplayer3;
	private TextView textplayer4;
	private TextView reseltplayer1;
	private TextView reseltplayer2;
	private TextView reseltplayer3;
	private TextView reseltplayer4;
	private Button insectnum;
	private Button setting;
	
	private Button btn_start;
	private Button btn_clear;
	private Button btn_round;
	private Button btn_end;


	//private rules[] rule=null;
	ArrayList<rules> rule = new ArrayList<rules>();
	private TextView ruletext;

	 ListView userList;
	 UserCustomAdapter userAdapter;
	 ArrayList<User> userArray = new ArrayList<User>();
	
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.bigdee, container, false);
        
        textplayer1 = (TextView) rootView.findViewById(R.id.player1);
        textplayer2 = (TextView) rootView.findViewById(R.id.player2);
        textplayer3 = (TextView) rootView.findViewById(R.id.player3);
        textplayer4 = (TextView) rootView.findViewById(R.id.player4);
        reseltplayer1 = (TextView) rootView.findViewById(R.id.totalplayer1);
        reseltplayer2 = (TextView) rootView.findViewById(R.id.totalplayer2);
        reseltplayer3 = (TextView) rootView.findViewById(R.id.totalplayer3);
        reseltplayer4 = (TextView) rootView.findViewById(R.id.totalplayer4);
        player_name= new String[4];
        player_name[0] = "player1";
    	player_name[1] = "player2";
    	player_name[2] = "player3";
    	player_name[3] = "player4";
    	gobalround = 1;
    	moneypercard=1;
    	textmoneypercard= (TextView) rootView.findViewById(R.id.cardpermoney);
    	
    	
    	
    	ruletext= (TextView) rootView.findViewById(R.id.rulestext);
    	
    	insectnum = (Button) rootView.findViewById(R.id.enter);
    	setting = (Button) rootView.findViewById(R.id.setting);
    	btn_start=(Button) rootView.findViewById(R.id.button_start);
    	btn_clear=(Button) rootView.findViewById(R.id.button_clear);
    	btn_round=(Button) rootView.findViewById(R.id.button_insert);
    	btn_end=(Button) rootView.findViewById(R.id.button_end);
    	
    	btn_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				popupsetting(textmoneypercard);
				btn_start.setVisibility(View.GONE);
		    	btn_clear.setVisibility(View.GONE);
		    	btn_round.setVisibility(View.VISIBLE);
		    	btn_end.setVisibility(View.VISIBLE);
		    	setting.setVisibility(View.GONE);
			}
		});
    	btn_clear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						getActivity());

					alertDialogBuilder.setTitle("Notice!");

					alertDialogBuilder
						.setMessage("Are you sure to clear all record?")
						//.setCancelable(false)
						.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								userArray.clear();
								gobalround = 1;
								userAdapter.notifyDataSetChanged();
								updatereselt(userArray,moneypercard,reseltplayer1,reseltplayer2,reseltplayer3,reseltplayer4);
							}
						  })
						.setNegativeButton("No",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, just close
								// the dialog box and do nothing
								dialog.cancel();
							}
						});
						AlertDialog alertDialog = alertDialogBuilder.create();
						alertDialog.show();
				
			}
		});
    	btn_round.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				PopUpNum(gobalround,gobalround,0,0,0,0, player_name);
			}
		});
    	btn_end.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				btn_start.setVisibility(View.VISIBLE);
		    	btn_clear.setVisibility(View.VISIBLE);
		    	btn_round.setVisibility(View.GONE);
		    	btn_end.setVisibility(View.GONE);
		    	setting.setVisibility(View.VISIBLE);
			}
		});
    	insectnum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				PopUpNum(gobalround,gobalround,0,0,0,0, player_name);
				//round++;
				//updatereselt(userArray,1,reseltplayer1,reseltplayer2,reseltplayer3,reseltplayer4);
			}
		});
        //userArray.add(new User(1,4,5,8,0));
        //userArray.add(new User(2,5,4,6,3));
    	setting.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				popupsetting(textmoneypercard);
			}
		});

       
        userAdapter = new UserCustomAdapter(getActivity(), R.layout.listitem,
        	    userArray);
        	  userList = (ListView) rootView.findViewById(R.id.listView);
        	  userList.setItemsCanFocus(false);
        	  userList.setAdapter(userAdapter);

        	  userList.setOnItemClickListener(new OnItemClickListener() {

        		   @Override
        		   public void onItemClick(AdapterView<?> parent, View v,
        		     final int position, long id) {
        		    Log.i("List View Clicked", "**********");
        		    Toast.makeText(getActivity(),
        		      "List View Clicked:" + position, Toast.LENGTH_LONG)
        		      .show();
        		    int p1=solvepowerresult(rule, userArray.get(position).getplayer1()) ;
        		    int p2=solvepowerresult(rule, userArray.get(position).getplayer2()) ;
        		    int p3=solvepowerresult(rule, userArray.get(position).getplayer3()) ;
        		    int p4=solvepowerresult(rule, userArray.get(position).getplayer4()) ;

    				//PopUpNum(position+1,gobalround,userArray.get(position).getplayer1(),userArray.get(position).getplayer2(),
    						//userArray.get(position).getplayer3(),userArray.get(position).getplayer4(), player_name);
    				PopUpNum(position+1,gobalround,p1,p2,
    						p3,p4, player_name);
        		   }
        		  });

        		
        		
        textplayer1.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	//player= ((TextView)v).getText().toString();
            	setplayername(player_name,textplayer1,0);
            	}
            });
        textplayer2.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	//player= ((TextView)v).getText().toString();
            	setplayername(player_name,textplayer2,1);
            	}
            });
        textplayer3.setOnClickListener(new OnClickListener() {
    
		    @Override
		    public void onClick(View v) {
		    	//player= ((TextView)v).getText().toString();
		    	setplayername(player_name,textplayer3,2);
		    	}
		    });
		textplayer4.setOnClickListener(new OnClickListener() {
		    
		    @Override
		    public void onClick(View v) {
		    	//player= ((TextView)v).getText().toString();
		    	setplayername(player_name,textplayer4,3);
		    	}
		    });
        return rootView;
            
    }
    
    
    private  void setplayername( final String[] name, final TextView v,final int playernum) {  
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());  
        helpBuilder.setTitle("Edit "+name[playernum]+" name");  
        final EditText input = new EditText(getActivity());  
        input.setSingleLine();  
        input.setHint(name[playernum]); //Set the text we want to edit  
        helpBuilder.setView(input);  
        
       //Save button  
        helpBuilder.setPositiveButton("Save",  
         new DialogInterface.OnClickListener() {  
         public void onClick(DialogInterface dialog, int which) {  
           //Save info here  
        	 if(!input.getText().toString().matches(""))
        	 {
        	v.setText(input.getText());
        	Editable newTxt=(Editable)input.getText(); 
        	name[playernum]= newTxt.toString();
        	 
        	 }
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
    private void PopUpNum(final int round,final int totalround,int player1num,int player2num,int player3num,int player4num, String[] name_player) {  
        //AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity()); 
        final Dialog dialog = new Dialog(getActivity());
		dialog.setContentView(R.layout.enternum);
		dialog.setTitle("Round: "+round+", Enter Result");
		TextView player1 = (TextView) dialog.findViewById(R.id.player1);
		TextView player2 = (TextView) dialog.findViewById(R.id.player2);
		TextView player3 = (TextView) dialog.findViewById(R.id.player3);
		TextView player4 = (TextView) dialog.findViewById(R.id.player4);
		player1.setText(name_player[0]);
		player2.setText(name_player[1]);
		player3.setText(name_player[2]);
		player4.setText(name_player[3]);

		final NumberPicker picknum1 = (NumberPicker) dialog.findViewById(R.id.numberPicker1);
		final NumberPicker picknum2 = (NumberPicker) dialog.findViewById(R.id.numberPicker2);
		final NumberPicker picknum3 = (NumberPicker) dialog.findViewById(R.id.numberPicker3);
		final NumberPicker picknum4 = (NumberPicker) dialog.findViewById(R.id.numberPicker4);

		picknum1.setMaxValue(13);  
		picknum1.setMinValue(0);    
		picknum1.setValue(player1num);
		picknum2.setMaxValue(13);  
		picknum2.setMinValue(0);    
		picknum2.setValue(player2num);
		picknum3.setMaxValue(13);  
		picknum3.setMinValue(0);    
		picknum3.setValue(player3num);
		picknum4.setMaxValue(13);  
		picknum4.setMinValue(0);    
		picknum4.setValue(player4num);
		
		Button enterbtn = (Button) dialog.findViewById(R.id.enterbtn);
		// if button is clicked, close the custom dialog
		enterbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int finalplayer1value =powerresult(rule, picknum1.getValue());
				int finalplayer2value =powerresult(rule, picknum2.getValue());
				int finalplayer3value =powerresult(rule, picknum3.getValue());
				int finalplayer4value =powerresult(rule, picknum4.getValue());
				String finalplayer1value_text=powerresult_text(rule, picknum1.getValue());
				String finalplayer2value_text=powerresult_text(rule, picknum2.getValue());
				String finalplayer3value_text=powerresult_text(rule, picknum3.getValue());
				String finalplayer4value_text=powerresult_text(rule, picknum4.getValue());


				if(round<totalround){
					//userArray.get(round-1).setplayer1(picknum1.getValue());
					//userArray.get(round-1).setplayer2(picknum2.getValue());
					//userArray.get(round-1).setplayer3(picknum3.getValue());
					//userArray.get(round-1).setplayer4(picknum4.getValue());
					userArray.get(round-1).setplayer1(finalplayer1value);
					userArray.get(round-1).setplayer2(finalplayer2value);
					userArray.get(round-1).setplayer3(finalplayer3value);
					userArray.get(round-1).setplayer4(finalplayer4value);
					userArray.get(round-1).setplayer1_text(finalplayer1value_text);
					userArray.get(round-1).setplayer2_text(finalplayer2value_text);
					userArray.get(round-1).setplayer3_text(finalplayer3value_text);
					userArray.get(round-1).setplayer4_text(finalplayer4value_text);
				}else{
				//userArray.add(new User(round,picknum1.getValue(),picknum2.getValue(),picknum3.getValue(),picknum4.getValue()));
				userArray.add(new User(round,finalplayer1value,finalplayer2value,finalplayer3value
						,finalplayer4value,finalplayer1value_text,finalplayer2value_text,finalplayer3value_text,finalplayer4value_text));

				gobalround++;
				}
				userAdapter.notifyDataSetChanged();
				updatereselt(userArray,moneypercard,reseltplayer1,reseltplayer2,reseltplayer3,reseltplayer4);
				dialog.dismiss();
			}
		});
		Button cancelbtn = (Button) dialog.findViewById(R.id.cancelbtn);
		// if button is clicked, close the custom dialog
		cancelbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		Button clearbtn = (Button) dialog.findViewById(R.id.clearbtn);
		if(round<totalround){
			clearbtn.setVisibility(View.VISIBLE);
			dialog.setTitle("Edit Round: "+round+" Result");

		}
		// if button is clicked, close the custom dialog
		clearbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				userArray.get(round-1).setplayer1(0);
				userArray.get(round-1).setplayer2(0);
				userArray.get(round-1).setplayer3(0);
				userArray.get(round-1).setplayer4(0);
				userArray.get(round-1).setplayer1_text("0");
				userArray.get(round-1).setplayer2_text("0");
				userArray.get(round-1).setplayer3_text("0");
				userArray.get(round-1).setplayer4_text("0");
				userAdapter.notifyDataSetChanged();
				updatereselt(userArray,moneypercard,reseltplayer1,reseltplayer2,reseltplayer3,reseltplayer4);
				dialog.dismiss();
			}
		});
		dialog.show();
		/*helpBuilder.setTitle("Enter Result");  
        LayoutInflater inflater = getActivity().getLayoutInflater();
        helpBuilder.setView(inflater.inflate(R.layout.enternum, null));  
       
       //Save button  
        helpBuilder.setPositiveButton("Save",  
         new DialogInterface.OnClickListener() {  
         public void onClick(DialogInterface dialog, int which) {  
           //Save info here  
        	 
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
        helpDialog.show();  */
       }  
    private void updatereselt(ArrayList<User> allresult,double moneypercard,TextView result_player1,TextView result_player2,TextView result_player3,TextView result_player4) {  
    	
    	double[] num_result= new double[4];
    	double[] money= new double[4];
    	
    	
    	for(int i = 0 ; i < allresult.size() ; i++) {
    		num_result[0]=num_result[0]+allresult.get(i).getplayer1();
    		num_result[1]=num_result[1]+allresult.get(i).getplayer2();
    		num_result[2]=num_result[2]+allresult.get(i).getplayer3();
    		num_result[3]=num_result[3]+allresult.get(i).getplayer4();
    	  
    	}
    	for(int r = 0 ; r < 4 ; r++) {
    		for(int k = 0 ;k < 4 ; k++) {
    			if(k!=r){
    			money[r]= money[r]+num_result[k]-num_result[r];
    			}
    		}
    		money[r]=money[r]*moneypercard;
    	}
    	result_player1.setText(String.format("%.0f",num_result[0])+"($"+String.format("%.1f",money[0])+")");
    	result_player2.setText(String.format("%.0f",num_result[1])+"($"+String.format("%.1f",money[1])+")");
    	result_player3.setText(String.format("%.0f",num_result[2])+"($"+String.format("%.1f",money[2])+")");
    	result_player4.setText(String.format("%.0f",num_result[3])+"($"+String.format("%.1f",money[3])+")");

    }
private void popupsetting(final TextView money_text) {  
	final Dialog dialog = new Dialog(getActivity());
	dialog.setContentView(R.layout.setting);
	dialog.setTitle("Rules Setting");
	final EditText money=(EditText)dialog.findViewById(R.id.edit_text);
	final EditText power=(EditText)dialog.findViewById(R.id.edit_power);
	final NumberPicker picknum1 = (NumberPicker) dialog.findViewById(R.id.numberPicker1);
	picknum1.setMaxValue(13);  
	picknum1.setMinValue(1);    
	picknum1.setValue(1);
	final TextView alertruletext=(TextView)dialog.findViewById(R.id.rulestext);
	showruletext(rule, alertruletext);
	dialog.setCancelable(false);
	Button addbtn = (Button) dialog.findViewById(R.id.addbtn);
	// if button is clicked, close the custom dialog
	addbtn.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (power.getText().toString().matches("")) {
				Toast.makeText(getActivity(),
	        		      "Please Enter Power Number", Toast.LENGTH_LONG)
	        		      .show();
				
			}else if(findcardnum(picknum1.getValue())){
				Toast.makeText(getActivity(),
	        		      "the card number:"+picknum1.getValue()+" condition is changed", Toast.LENGTH_LONG)
	        		      .show();
				for(int i=0;i<rule.size();i++){
			        if(rule.get(i).getcardnum()==picknum1.getValue() ){
			        	rule.get(i).setpower(Integer.parseInt(power.getText().toString()));
			            break;
			        }
				}
				showruletext(rule, ruletext);
				showruletext(rule, alertruletext);
			}else{
				
				rule.add(new rules(picknum1.getValue(),Integer.parseInt(power.getText().toString()))) ; 
				showruletext(rule, ruletext);
				showruletext(rule, alertruletext);

			}
			
		
		}
	});
	Button clearbtn = (Button) dialog.findViewById(R.id.clearbtn);
	clearbtn.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			
				rule.clear();
				alertruletext.setText("No rules yet");
				ruletext.setText("No rules yet");
				//showruletext(rule, ruletext);
		
		}
	});
	
	Button enterbtn = (Button) dialog.findViewById(R.id.enterbtn);
	// if button is clicked, close the custom dialog
	enterbtn.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (money.getText().toString().matches("")) {
				moneypercard=1;
				
			}else{
			moneypercard=Double.parseDouble(money.getText().toString());
			}
			money_text.setText("$/Card: "+moneypercard);
			
			dialog.dismiss();
		}
	});
	Button cancelbtn = (Button) dialog.findViewById(R.id.cancelbtn);
	// if button is clicked, close the custom dialog
	cancelbtn.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			dialog.dismiss();
		}
	});
	dialog.show();

    }

	private void showruletext(ArrayList<rules> rule, TextView ruletext) {
		Collections.sort(rule, new Comparator<rules>(){
			 @Override
			 public int compare(rules o1, rules o2) {
			  return  o2.cardnum - o1.cardnum;
			 }   
			});
		ruletext.setText("");
		if(rule.size()==0){
			ruletext.setText("No rules yet");
		}else{
		for(int i = 0 ; i < rule.size() ; i++) {
			
			if(i==0){
				ruletext.append("Rules: >=" + rule.get(i).getcardnum() + 
						" X " + rule.get(i).getpower());
				}else{
					ruletext.append(", >=" + rule.get(i).getcardnum() + 
							" X " + rule.get(i).getpower());
				}
    	  
    	}
		}
	}
	Boolean findcardnum(int cardnum){
		Boolean exist = false;
		 for(int i=0;i<this.rule.size();i++){
		        if(this.rule.get(i).getcardnum() == cardnum){
		            exist=true;
		            break;
		        }
		       
		} 
		 return exist;
	}
	
	int powerresult(ArrayList<rules> rule, int input) {
		int output=input;
		for(int i=0;i<rule.size();i++){
	        if(input >= rule.get(i).getcardnum() ){
	        	output=input*rule.get(i).getpower();
	            break;
	        }
		}
		return output;
	}
	int solvepowerresult(ArrayList<rules> rule, int input) {
		int output=input;
		int temp=0;
		for(int r=1;r<14;r++){
			temp=r;
		for(int i=0;i<rule.size();i++){
	        if(r >= rule.get(i).getcardnum() ){
	        	temp=r*rule.get(i).getpower();
	            break;
	        }
		}
		if(input==temp){
	        	output= r;
	        	break;
	        }
		}
		return output;
	}
	String powerresult_text(ArrayList<rules> rule, int input) {
		String output=String.valueOf(input);
		for(int i=0;i<rule.size();i++){
	        if(input >= rule.get(i).getcardnum() ){
	        	output=output+"(X"+String.valueOf(rule.get(i).getpower())+")";
	            break;
	        }
		}
		return output;
	}
}
