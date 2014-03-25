package com.gambler;



public class rules {
	 
	 int cardnum;
	 int power;
	 public int getcardnum() {
		  return cardnum;
		 }

	public void setcardnum(int cardnum) {
		  this.cardnum = cardnum;
		 }
	public int getpower() {
			return power;
		 }

	public void setpower(int power) {
			this.power = power;
		 }



	 public rules(int cardnum,int power) {
	  super();
	  this.cardnum = cardnum;
	  this.power = power;
	  
	  
	 }
	 
	 
		 
		 
	 
	 /* public int compareTo(rules compareFruit) {
		 
			int compareQuantity = ((rules) compareFruit).getcardnum(); 
	 
			//ascending order
			//return this.cardnum - compareQuantity;
	 
			//descending order
			return compareQuantity - this.cardnum;
	 
		}	
	public static Comparator<rules> CardnumComparator 
     = new Comparator<rules>() {

    	 public int compare(rules fruit1, rules fruit2) {

    		 String fruitName1 = fruit1.getFruitName().toUpperCase();
    		 String fruitName2 = fruit2.getFruitName().toUpperCase();

    		 	//ascending order
    		 return fruitName1.compareTo(fruitName2);

    		 //descending order
    		 //return fruitName2.compareTo(fruitName1);
    	 }

	};*/
}
