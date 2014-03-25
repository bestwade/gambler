package com.gambler;

public class User {
	 //String name;
	 //String address;
	 //String location;
	 int round;
	 int player1;
	 int player2;
	 int player3;
	 int player4;
	 String player1_text;
	 String player2_text;
	 String player3_text;
	 String player4_text;
	 public int getround() {
		  return round;
		 }

	public void setround(int round) {
		  this.round = round;
		 }
	public int getplayer1() {
			return player1;
		 }

	public void setplayer1(int player1) {
			this.player1 = player1;
		 }
	public int getplayer2() {
		 return player2;
		 }

	public void setplayer2(int player2) {
		this.player2 = player2;
		 }
	public int getplayer3() {
		return player3;
			 }

	public void setplayer3(int player3) {
		  this.player3 = player3;
			 }
	public int getplayer4() {
			  return player4;
			 }

	public void setplayer4(int player4) {
			 this.player4 = player4;
			 }
	
	 public String getplayer1_text() {
	  return player1_text;
	 }

	 public void setplayer1_text(String player1_text) {
	  this.player1_text = player1_text;
	 }
	 
	 public String getplayer2_text() {
		 return player2_text;
		 }

	 	public void setplayer2_text(String player2_text) {
		  this.player2_text = player2_text;
		 }
	 	
		 	public String getplayer3_text() {
			  return player3_text;
			 }

			 public void setplayer3_text(String player3_text) {
			  this.player3_text = player3_text;
			 }
			 
			 public String getplayer4_text() {
				  return player4_text;
				 }

			public void setplayer4_text(String player4_text) {
				  this.player4_text = player4_text;
				 }
	 /*public String getAddress() {
	  return address;
	 }

	 public void setAddress(String address) {
	  this.address = address;
	 }

	 public String getLocation() {
	  return location;
	 }

	 public void setLocation(String location) {
	  this.location = location;
	 }*/

	 public User(int round,int player1,int player2,int player3,int player4, String player1_text,String player2_text,String player3_text,String player4_text) {
	  super();
	  this.round = round;
	  this.player1 = player1;
	  this.player2 = player2;
	  this.player3 = player3;
	  this.player4 = player4;
	  this.player1_text = player1_text;
	  this.player2_text = player2_text;
	  this.player3_text = player3_text;
	  this.player4_text = player4_text;
	 }

	}