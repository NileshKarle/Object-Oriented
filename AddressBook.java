package org.json.simple.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author nilesh
 * 
 * @description reads, stores, search and edit the user data using the JSON.
 */
public class AddressBook {

	public static void main(String []args) {
		
			Scanner scan =new Scanner(System.in);
			int i=1,j=0,number,k;
			try {
		    	  JSONParser parser = new JSONParser();
		    	  Object obj1 = parser.parse(new FileReader("/home/bridgeit/nilesh/jasonaddressbook.json"));
		  
	            	JSONArray temp=(JSONArray) obj1;
	            	System.out.println("enter 1 to start to enter. ");
	            	i=scan.nextInt();
				while(i==1){
					
					JSONObject obj=new JSONObject();
					System.out.println("enter name ");
					String nameCheck=scan.next();
					obj.put("name",nameCheck);
					System.out.println("enter address ");
					String addressCheck=scan.next();
					obj.put("address",addressCheck);
					System.out.println("enter number ");
					int numberCheck=scan.nextInt();
					obj.put("number",numberCheck);
				
					temp.add(obj);
					
				
				System.out.println("enter 1 to continue to enter data else enter 2.");
				i=scan.nextInt();
				}
				
			
			try {
				PrintWriter print=new PrintWriter("/home/bridgeit/nilesh/jasonaddressbook.json");
				print.print(temp.toJSONString());
				print.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			/*
			 *Display the containt's present in the .json file along with the new data that has been added.
			 */
			Iterator iterat = temp.iterator();
	           while (iterat.hasNext()) {       
           JSONObject temporary=(JSONObject) iterat.next();
           {
         	 // System.out.println(keyName+" found.");
         	  System.out.println("name: " + temporary.get("name"));
               System.out.println("address: " + temporary.get("address"));
               System.out.println("number: " + temporary.get("number"));   
           } 
		}
	           
	           /*
	            * this while loop keeps on repeating unless the user press 3 to exit.
	            * 
	            */
			while(j!=3)
			{
			System.out.println("enter 1 to search.");
			System.out.println("enter 2 to edit.");
			System.out.println("enter 3 to exit.");
			j=scan.nextInt();
			if(j==1)
			{
				System.out.println("enter name");
				String keyName=scan.next();
			
				/*if(temp.contains(keyName)==true)
				{
					System.out.println(temp.get(temp.lastIndexOf(keyName)));
				}
				System.out.println("entered ");*/
				  Iterator myiterator = temp.iterator();
		           while (myiterator.hasNext()) {
	              JSONObject temporary=(JSONObject) myiterator.next();
	              if(temporary.get("name").equals(keyName))
	              {
	            	  System.out.println(keyName+" found.");
	            	  System.out.println("name: " + temporary.get("name"));
	                  System.out.println("address: " + temporary.get("address"));
	                  System.out.println("number: " + temporary.get("number"));   
	              } 
			}
			}
			else if(j==3)
			{
				System.out.println("bye");
				System.exit(0);
			}
			else if(j==2)
			{
				System.out.println("enter name");
				String keyName=scan.next();
				  Iterator iterat1 = temp.iterator();
				  int z=0;
		           while (iterat1.hasNext()) {
	              JSONObject temporary=(JSONObject) iterat1.next();
	              if(temporary.get("name").equals(keyName))
	              {  
	            	  z=1;
	            	  temp.remove(temporary);
	            	  JSONObject obj=new JSONObject();
	            	  System.out.println("enter name ");
	            	  String nameCheck=scan.next();
	            	  obj.put("name",nameCheck);	            	 
	            	  System.out.println("enter address ");
						String addressCheck=scan.next();
						obj.put("address",addressCheck);
						System.out.println("enter number ");
						int numberCheck=scan.nextInt();
						obj.put("number",numberCheck);
						temp.add(obj);
	              }
			}
		           if(z==0){
		        	   System.out.println("name not found.");
		           }
			}
			else{
				System.out.println("enter valid input. ");
			}
			}
			}
			 catch (FileNotFoundException e) {
		          e.printStackTrace();
		      } catch (IOException e) {
		          e.printStackTrace();
		      } catch (ParseException e) {
		          e.printStackTrace();
		      }
		
	}
}
