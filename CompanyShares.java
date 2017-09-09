package org.json.simple.parser;

import java.util.LinkedList;
import java.util.Scanner;

class Update{
	
	Scanner scan=new Scanner(System.in);
	LinkedList add (LinkedList ll){
		System.out.println("enter the name to add");
		String name=scan.nextLine();
		ll.add(name);
		System.out.println(ll);
		return ll;
	}
	LinkedList remove (LinkedList ll){
		System.out.println("enter the name to remove");
		String name=scan.nextLine();
		ll.remove(name);
		System.out.println(ll);
		return ll;
	}
}
public class CompanyShares {
	
	public static void main(String []args){
	Scanner scan=new Scanner(System.in);
	LinkedList ll=new LinkedList();
	Update up=new Update();
	int value=0;
	while(value!=3)
	{
	System.out.println("enter 1 to add .");
	System.out.println("enter 2 to remove .");
	System.out.println("enter 3 to exit .");
	value=scan.nextInt();
	if(value==1)
	{
		ll=up.add(ll);
	}
	if(value==2)
	{
		ll=up.remove(ll);
	}
	if(value==3)
	{
		System.out.println(" bye ");
		System.exit(0);
	}
	else
	{
		System.out.println("enter a valid input .");
	}
	}
}
}
