package org.json.simple.parser;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class Updated{
	Stack<String> added=new Stack<String>();
	Stack<String> removed=new Stack<String>();
	Scanner scan=new Scanner(System.in);
	Stack add (Stack ll){
		System.out.println("enter the name to add");
		String name=scan.nextLine();
		ll.add(name);
		added.add(name);
		//System.out.println(ll);
		return ll;
	}
	Stack remove (Stack ll){
		System.out.println("enter the name to remove");
		String name=scan.nextLine();
		ll.remove(name);
		removed.add(name);
		//System.out.println(ll);
		return ll;
	}
}

public class TransactionsDone {

	public static void main(String []args){
		Scanner scan=new Scanner(System.in);
		Stack ll=new Stack();
		Updated up=new Updated();
		int value=0;
		while(value!=5)
		{
		System.out.println("enter 1 to add .");
		System.out.println("enter 2 to remove .");
		System.out.println("enter 3 to transactionsdone .");
		System.out.println("enter 4 to check present stacks");
		System.out.println("enter 5 to exit .");
		value=scan.nextInt();
		if(value==1)
		{
			ll=up.add(ll);
		}
		else if(value==2)
		{
			ll=up.remove(ll);
		}
		else if(value==3)
		{
			System.out.println("stocks added till now");
			System.out.println(up.added);
			System.out.println("stocks removed till now");
			System.out.println(up.removed);
		}
		else if(value==4)
		{
			System.out.println(ll);
		}
		else if(value==5)
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
