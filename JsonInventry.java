package org.json.simple.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonInventry {
	public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	String array[]=new String[]{"Rice","Pulses","Wheats"}; //Array to store values.
	int i,j,number,k;
	JSONObject invenry =new JSONObject();
	for(i=0;i<3;i++)
	{
		JSONArray array1 = new JSONArray(); 
		System.out.println("enter the number of types of " + array[i]);
		number=scan.nextInt();
		for(j=0;j<number;j++)
		{
			JSONObject obj=new JSONObject();
			System.out.println("enter name");
			obj.put("name",scan.next());
			System.out.println("enter weight");
			obj.put("weight",scan.nextLong());
			System.out.println("enter price per kg");
			obj.put("price",scan.nextLong());
			array1.add(obj);
		}	
		invenry.put(array[i], array1);
	}
	
	try {
		PrintWriter print=new PrintWriter("/home/bridgeit/nilesh/jasoninventry.json");
		print.print(invenry.toJSONString());
		print.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	 

      try {
    	  JSONParser parser = new JSONParser();
    	  JSONArray readArray =new JSONArray();
          Object obj1 = parser.parse(new FileReader("/home/bridgeit/nilesh/jasoninventry.json"));
          JSONObject object=(JSONObject) obj1;
        //  System.out.println(object);
          
        	  //System.out.println(object.get("Wheats"));
          float value=0.0f;
        	JSONArray wheat=(JSONArray) object.get("Wheats");
        	Iterator iterator = wheat.iterator();
            while (iterator.hasNext()) {
              JSONObject temporary=(JSONObject) iterator.next();
              //System.out.println("Name: " + temporary.get("name"));
              //System.out.println("Price: " + temporary.get("price"));
              //System.out.println("Weight: " + temporary.get("weight"));
            long p=(long) temporary.get("price");
            long w=(long) temporary.get("weight");
            value=(float) value+p*w;           
            }
            System.out.println("wheats :"+value);

      	  //System.out.println(object.get("Rice"));
            value=0.0f;
      	JSONArray rice=(JSONArray) object.get("Rice");
      	 iterator = rice.iterator();
          while (iterator.hasNext()) {
            JSONObject temporary=(JSONObject) iterator.next();
            //System.out.println("Name: " + temporary.get("name"));
            //System.out.println("Price: " + temporary.get("price"));
            //System.out.println("Weight: " + temporary.get("weight"));
            long p=(long) temporary.get("price");
            long w=(long) temporary.get("weight");
            value=(float)value+p*w;  
          }
          System.out.println("rice :"+value);

    	 // System.out.println(object.get("Pulses"));
          value=0.0f;
    	JSONArray pulse=(JSONArray) object.get("Pulses");
    	iterator = pulse.iterator();
        while (iterator.hasNext()) {
          JSONObject temporary=(JSONObject) iterator.next();
          //System.out.println("Name: " + temporary.get("name"));
          //System.out.println("Price: " + temporary.get("price"));
          //System.out.println("Weight: " + temporary.get("weight"));
          long p=(long) temporary.get("price");
          long w=(long) temporary.get("weight");
          value=(float)value+p*w;  
        }
        System.out.println("pulses :"+value);
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
