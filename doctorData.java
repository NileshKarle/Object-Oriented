package org.json.simple.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class doctorData {
	public static void main(String []args){
		
	Scanner scan =new Scanner(System.in);
	try {
		 JSONParser parser = new JSONParser();
		Object obj1 = parser.parse(new FileReader("/home/bridgeit/nilesh/jasondoctor.json"));
		JSONObject cliniqueObject =(JSONObject) obj1;
      	JSONArray array1=(JSONArray) cliniqueObject.get("doctor");
      	JSONArray array2=(JSONArray) cliniqueObject.get("patient");
	int i,j,number,k;
	JSONObject dr =new JSONObject();
		/*
		 * collect the doctor details.
		 */
	System.out.println("enter 1 to enter doctor data else enter 0");
	int doc=scan.nextInt();
	if(doc==1){	
		System.out.println("enter the number of doctor");
		number=scan.nextInt();
		for(j=0;j<number;j++)
		{
			JSONObject obj=new JSONObject();
			System.out.println("enter name");
			obj.put("name",scan.next());
			System.out.println("enter ID");
			obj.put("id",scan.next());			
			System.out.println("enter avability");
			obj.put("avability",scan.next());
			System.out.println("enter specialization");
			obj.put("speciality",scan.next());
			System.out.println("enter booked patients");
			obj.put("booked",scan.nextInt());
			array1.add(obj);
		}
		cliniqueObject.put("doctor",array1);
		try {
			PrintWriter print=new PrintWriter("/home/bridgeit/nilesh/jasondoctor.json");
			print.print(cliniqueObject.toJSONString());
			print.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
		/*
		 * collect the patient details.
		 * 
		 */
	System.out.println("enter 1 to enter patient data else enter 0");
	int patient=scan.nextInt();
	if(patient==1){	
		System.out.println("enter the number of patient");
		number=scan.nextInt();
		for(j=0;j<number;j++)
		{
			JSONObject obj=new JSONObject();
			System.out.println("enter name");
			obj.put("name",scan.next());
			System.out.println("enter ID");
			obj.put("id",scan.next());
			System.out.println("enter mobilenumber");
			obj.put("mobilenumber",scan.next());
			System.out.println("enter age");
			obj.put("age",scan.next());
			array2.add(obj);
		}
		cliniqueObject.put("patient",array2);
	try {
		PrintWriter print=new PrintWriter("/home/bridgeit/nilesh/jasondoctor.json");
		print.print(cliniqueObject.toJSONString());
		print.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	}
	/*
	 * search for doctor.
	 * 
	 */
	System.out.println("");
	System.out.println("to search doctor by name enter 1, by id enter 2,by speciality enter 3 by avability enter 4");
	int doctorSearch=scan.nextInt();
	if(doctorSearch==1){
		System.out.println("enter name");
		String keyName=scan.next();
		int z=0;
		Iterator myiterator = array1.iterator();
        while (myiterator.hasNext()) {
       JSONObject temporary=(JSONObject) myiterator.next();
       if(temporary.get("name").equals(keyName))
       {
    	   z=1;
     	  System.out.println(keyName+" found.");
     	  System.out.println("name: " + temporary.get("name"));
     	 System.out.println("id: " + temporary.get("id"));
           System.out.println("speciality: " + temporary.get("speciality"));
           System.out.println("avability: " + temporary.get("avability"));  

           /*
            * take appointment the the respective doctor.
            * 
            */
       	System.out.println("to take appointment enter 1");
       	int appointment=scan.nextInt();
       	if(appointment==1)
       	{
       		long value= (long) temporary.get("booked");
       		System.out.println("enter the number of patient");
       		number=scan.nextInt();
       		if(value+number<=5){
       			int num=(int) (value+number);
       			temporary.put("booked",num);
       			cliniqueObject.put("doctor",array1);
       		for(j=0;j<number;j++)
       		{
       			JSONObject obj=new JSONObject();
       			System.out.println("enter name");
       			obj.put("name",scan.next());
       			System.out.println("enter ID");
       			obj.put("id",scan.next());
       			System.out.println("enter mobilenumber");
       			obj.put("mobilenumber",scan.next());
       			System.out.println("enter age");
       			obj.put("age",scan.next());
       			array2.add(obj);
       		}
       		System.out.println("appointment done.");
       		cliniqueObject.put("patient",array2);
       		try {
    			PrintWriter print=new PrintWriter("/home/bridgeit/nilesh/jasondoctor.json");
    			print.print(cliniqueObject.toJSONString());
    			print.close();
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
       		
       	try {
       			PrintWriter print=new PrintWriter("/home/bridgeit/nilesh/jasondoctor.json");
       		print.print(cliniqueObject.toJSONString());
       		print.close();
       	} catch (FileNotFoundException e) {
       		e.printStackTrace();
       	}
       		}
       		else{
       			System.out.println("doctor is not avaliable.");
       		}
       }
       	
	}
        
        }
        if(z==0){
        	System.out.println("no such doctor found");
    	}
        }
	
	else if(doctorSearch==2){
		System.out.println("enter id");
		String keyName=scan.next();
		int z=0;
		Iterator myiterator = array1.iterator();
        while (myiterator.hasNext()) {
       JSONObject temporary=(JSONObject) myiterator.next();
       if(temporary.get("id").equals(keyName))
       {
    	   z=1;
     	  System.out.println(keyName+"id found.");
     	  System.out.println("name: " + temporary.get("name"));
     	 System.out.println("id: " + temporary.get("id"));
           System.out.println("speciality: " + temporary.get("speciality"));
           System.out.println("avability: " + temporary.get("avability"));   
       } 
	}
        if(z==0){
        	System.out.println("no such doctor id found");
        }
	}
	else if(doctorSearch==3){
		System.out.println("enter speciality");
		String keyName=scan.next();
		int z=0;
		Iterator myiterator = array1.iterator();
        while (myiterator.hasNext()) {
       JSONObject temporary=(JSONObject) myiterator.next();
       if(temporary.get("speciality").equals(keyName))
       {
    	   z=1;
     	  System.out.println(keyName+" specialist found.");
     	  System.out.println("name: " + temporary.get("name"));
     	 System.out.println("id: " + temporary.get("id"));
           System.out.println("speciality: " + temporary.get("speciality"));
           System.out.println("avability: " + temporary.get("avability"));   
       } 
	}
        if(z==0){
        	System.out.println("no such specialist found");
        }
	}
	else if(doctorSearch==4){
		System.out.println("enter avability am or pm");
		String keyName=scan.next();
		int z=0;
		Iterator myiterator = array1.iterator();
		
        while (myiterator.hasNext()) {
        	JSONObject temporary=(JSONObject) myiterator.next();
       if(temporary.get("avability").equals(keyName)||temporary.get("avability").equals("both"))
       {
    	   z=1;
     	  System.out.println(" ");
     	  System.out.println("name: " + temporary.get("name"));
     	 System.out.println("id: " + temporary.get("id"));
           System.out.println("speciality: " + temporary.get("speciality"));
           System.out.println("avability: " + temporary.get("avability"));   
       } 
	}
        
	}
	
	else{
	System.out.println(" ");
	}
	System.out.println("to search patient by name enter 1, by id enter 2,by number enter 3");
	int patientSearch=scan.nextInt();
	if(patientSearch==1){
		System.out.println("enter name");
		String keyName=scan.next();
		int z=0;
		Iterator myiterator = array2.iterator();
        while (myiterator.hasNext()) {
       JSONObject temporary=(JSONObject) myiterator.next();
       if(temporary.get("name").equals(keyName))
       {
    	   z=1;
     	  System.out.println(keyName+" found.");
     	  System.out.println("name: " + temporary.get("name"));
     	 System.out.println("id: " + temporary.get("id"));
           System.out.println("mobile number: " + temporary.get("mobilenumber"));
           System.out.println("age: " + temporary.get("age"));   
       } 
	}
        if(z==0){
        	System.out.println("no such patient found");
        }
	}
	else if(patientSearch==2){
		System.out.println("enter id");
		String keyName=scan.next();
		int z=0;
		Iterator myiterator = array2.iterator();
        while (myiterator.hasNext()) {
       JSONObject temporary=(JSONObject) myiterator.next();
       if(temporary.get("id").equals(keyName))
       {
    	   z=1;
     	  System.out.println(keyName+"id found.");
     	  System.out.println("name: " + temporary.get("name"));
     	 System.out.println("id: " + temporary.get("id"));
           System.out.println("mobilenumber: " + temporary.get("mobilenumber"));
           System.out.println("age: " + temporary.get("age"));   
       } 
	}
        if(z==0){
        	System.out.println("no such doctor id found");
        }
	}
	else if(patientSearch==3){
		System.out.println("enter number");
		String keyName=scan.next();
		int z=0;
		Iterator myiterator = array2.iterator();
        while (myiterator.hasNext()) {
       JSONObject temporary=(JSONObject) myiterator.next();
       if(temporary.get("mobilenumber").equals(keyName))
       {
    	   z=1;
     	  System.out.println(keyName+" mobilenumber found.");
     	  System.out.println("name: " + temporary.get("name"));
     	 System.out.println("id: " + temporary.get("id"));
           System.out.println("mobilenumber: " + temporary.get("mobilenumber"));
           System.out.println("age: " + temporary.get("age"));   
       } 
	}
        if(z==0){
        	System.out.println("no such number found");
        }
	}
	else{
	System.out.println(" ");
	}
	System.out.println("program terminated.");
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
