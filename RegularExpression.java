package org.json.simple.parser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.*;
class PatternMacher{
	public String change(String str,String ptrn) {
		  Pattern patt = Pattern.compile("<<name>>|<<fullname>>|x{10}");
		  Matcher m = patt.matcher(str);
		  return m.replaceAll(ptrn);
		}
}
public class RegularExpression {


	public static void main(String []args){
		
	
	Scanner scan=new Scanner(System.in);
	PatternMacher pm= new PatternMacher();
	String name="my name is <<name>>";
	System.out.println(name);
	String fullname="my fullname is <<fullname>>";
	System.out.println(fullname);
	String contact="+91-xxxxxxxxxx";
	System.out.println(contact);
	System.out.println("enter your name to replace ");
	String first=scan.nextLine();
	 if(first.matches("")==false)
	 {
	name=pm.change(name,first);
	System.out.println(name);
	 }
	 else
	 {
		 System.out.println(name);
	 }
	System.out.println("enter your fullname to replace ");
	String second=scan.nextLine();
	 if(second.matches("")==false)
	 {
	fullname=pm.change(fullname,second);
	System.out.println(fullname);
	 }
	 else
	 {
		 System.out.println(fullname);
	 }
	System.out.println("enter your contact number to replace ");
	String number=scan.nextLine();
	 if(number.matches("")==true)
	 {
		 System.out.println(contact);
	 }
	 else if(number.matches("[0-9]{10}")==true)
	 {
	contact=pm.change(contact,number);
	System.out.println("updated number is "+contact);
	 }
	 else
	 {
		 System.out.println("the number is not in a correct format. ");
	 }
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	System.out.println(sdf.format(date));
	}
}
