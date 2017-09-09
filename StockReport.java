package org.json.simple.parser;

import java.util.Scanner;
class stock{
	int total=0;
	String name;
	int number,price;
	public void collect(String name,int number,int price){
		this.name=name;
		this.number=number;
		this.price=price;
		int sum=0;
		sum=number*price;
		System.out.println("the sum of "+name+" is "+sum);
		total=total+sum;
	}
}
public class StockReport {
	
	
	public static void main(String []args){
		Scanner scan=new Scanner(System.in);
		stock s=new stock();
		System.out.println("enter the number of stocks");
		int n= scan.nextInt();
		for(int i=0;i<n;i++)
		{
		  System.out.println("enter stock name ");
		  String name=scan.next();
		  System.out.println("enter number of stock ");
		  int number=scan.nextInt();
		  System.out.println("enter share price ");
		  int price=scan.nextInt();
		  s.collect(name, number, price);
		}
		System.out.println("the total price is "+s.total);
	}

}
