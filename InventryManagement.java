package org.json.simple.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author nilesh
 * 
 * @description reads data from jasoninventry.json file and displays the required objects total price.
 */
public class InventryManagement {
	public static void main(String []args){
		Scanner scan =new Scanner(System.in);
		try {
			 JSONParser parser = new JSONParser();
			Object obj1 = parser.parse(new FileReader("/home/bridgeit/nilesh/jasoninventry.json"));
			JSONObject cliniqueObject =(JSONObject) obj1;
	      	JSONArray array1=(JSONArray) cliniqueObject.get("Wheats");
	      	JSONArray array2=(JSONArray) cliniqueObject.get("Pulses");
	      	JSONArray array3=(JSONArray) cliniqueObject.get("Rice");
	 		long sum=0;
	      	System.out.println("1) total price of wheats.");
	      	System.out.println("2) total price of pulses.");
	      	System.out.println("3) total price of rice.");
	      	int value=scan.nextInt();
	      	if(value==1){
	     sum=0;
	     long price,weight;
	      	Iterator myiterator = array1.iterator();
	        while (myiterator.hasNext()) {
	       JSONObject temporary=(JSONObject) myiterator.next();
	     	  price=(long) temporary.get("price");	     
	           weight=(long)temporary.get("weight"); 
	           sum=sum+price*weight;
	        }
	        System.out.println("the total price of wheats is "+sum);
		}
		
	      	else if(value==2){
	      		long price,weight;
	      	Iterator myiterator = array2.iterator();
	        while (myiterator.hasNext()) {
	       JSONObject temporary=(JSONObject) myiterator.next();
	       price=(long) temporary.get("price");	     
           weight=(long)temporary.get("weight"); 
           sum=sum+price*weight;
        }
        System.out.println("the total price of pulses is "+sum);
		}
		
	      	else if(value==3){
	      		long price,weight;
      	Iterator myiterator = array3.iterator();
        while (myiterator.hasNext()) {
       JSONObject temporary=(JSONObject) myiterator.next();
       price=(long) temporary.get("price");	     
       weight=(long)temporary.get("weight"); 
       sum=sum+price*weight;
    }
    System.out.println("the total price of rice is "+sum);
	}
	      	else{
	      		System.out.println("you entered a invalid value.");
	}
}
		catch (FileNotFoundException e1) {	
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
}
